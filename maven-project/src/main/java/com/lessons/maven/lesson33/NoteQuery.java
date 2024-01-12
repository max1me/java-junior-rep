package com.lessons.maven.lesson33;


import java.sql.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/*
* private long id;
    private String title;
    private String text;
    private ZonedDateTime createdAt;
    private Author author;
* */
public class NoteQuery {
    //DATE LocalDate
    //TIME LocalTime
    //TIMESTAMP дата + время без временной зоны LocalDateTime
    //TIMESTAMPZ дата + время + utc OffsetDateTime
    public boolean createTable() {
        String createSql = "CREATE TABLE IF NOT EXISTS tb_notes(" +
                "id SERIAL PRIMARY KEY, " +
                "title VARCHAR(100) NOT NULL, " +
                "note_text TEXT NOT NULL, " +
                "created_at TIMESTAMPTZ, " +
                "author_unique_name VARCHAR(60) NOT NULL, " +
                "CONSTRAINT fk_authors_notes FOREIGN KEY(author_unique_name) " +
                "REFERENCES tb_authors (unique_name))";
        try (Connection connection = C3p0ConnectionsPool.getConnectionFromPool()) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(createSql);
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Note insert(Note note) {
        String insertSQL = "INSERT INTO tb_notes(title, note_text, created_at, author_unique_name) " +
                "VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement statement = C3p0ConnectionsPool.getConnectionFromPool().prepareStatement(insertSQL,
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, note.getTitle());
            statement.setString(2, note.getText());
            statement.setObject(3, note.getCreatedAt());
            statement.setString(4, note.getAuthor().getUniqueName());
            statement.executeUpdate();
            try (ResultSet key = statement.getGeneratedKeys()) {
                if (!key.next()) throw new RuntimeException("Key error!");
                note.setId((key.getInt(1)));
            }
            return note;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Note> getNotesByTitle(String title) {
        String selectSql = "SELECT tb_notes.*, tb_authors.* FROM tb_notes, tb_authors" +
                "WHERE tb_notes.author_unique_name = tb_authors.unique_name " +
                "AND tb_notes.title ILIKE ? " +
                "ORDER BY tb_notes.created_at DESC";
        List<Note> notes = new ArrayList<>();

        try (PreparedStatement statement = C3p0ConnectionsPool.getConnectionFromPool().prepareStatement(selectSql)) {
            statement.setString(1, title);
            ResultSet resultSet = statement.executeQuery(selectSql);
            while (resultSet.next()) {
                Author author = new Author(
                        resultSet.getString("tb_authors.unique_name"),
                        resultSet.getObject("tb_authors.registered_at", LocalDate.class),
                        resultSet.getBoolean("tb_authors.is_active"));
                Note note = new Note(resultSet.getLong("tb_notes.id"),
                        resultSet.getString("tb_notes.title"),
                        resultSet.getString("tb_notes.note_text"),
                        resultSet.getObject("created_at", ZonedDateTime.class),
                        author);
                notes.add(note);
            }
            return notes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
