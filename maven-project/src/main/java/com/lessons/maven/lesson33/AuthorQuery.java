package com.lessons.maven.lesson33;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AuthorQuery {
    public boolean createTable() {
        String createSql = "CREATE TABLE IF NOT EXISTS tb_authors(" +
                "unique_name VARCHAR(60) PRIMARY KEY," +
                "registered_at DATE DEFAULT CURRENT_DATE NOT NULL," +
                "is_active BOOLEAN DEFAULT TRUE)";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try (Connection connection = DriverManager.getConnection(Lesson33.CONNECTION_STR, Lesson33.LOGIN, Lesson33.PWD)){
            try (Statement statement = connection.createStatement()) {
                //Для не SELECT запросов
                statement.executeUpdate(createSql);
            } catch (SQLException e) {
                System.out.println("Ошибка синтаксиса, отсутствие или наличие таблицы," +
                        "разрыв соединения");
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка во время соединения с сервером Postgresql");
            throw new RuntimeException(e);
        }
        return true;
    }

    public int[] insertAllIntoTable(List<Author> authors) {
        String insertSQL = "INSERT INTO tb_authors(unique_name) VALUES(?)";
        try (PreparedStatement statement = C3p0ConnectionsPool.getConnectionFromPool().prepareStatement(insertSQL)) {
            for (Author auhtor: authors) {
                statement.setString(1, auhtor.getUniqueName());
                statement.addBatch();
            }
            int[] result = statement.executeBatch();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertIntoTable(Author author) {
        String insertSQL = "INSERT INTO tb_authors(unique_name)" +
                "VALUES(?)";
        try (Connection connection = DriverManager.getConnection(Lesson33.CONNECTION_STR, Lesson33.LOGIN, Lesson33.PWD)){
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
                preparedStatement.setString(1, author.getUniqueName());
            } catch (SQLException e) {
                System.out.println("Ошибка синтаксиса, отсутствие или наличие таблицы," +
                        "разрыв соединения");
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка во время соединения с сервером Postgresql");
            throw new RuntimeException(e);
        }
        return 1;
    }

    public int update(Author author) {
        String updateSql = "UPDATE tb_authors " +
                "SET is_active = ? WHERE unique_name = ?";
        try (Connection connection = C3p0ConnectionsPool.getConnectionFromPool()) {
            try (PreparedStatement statement = connection.prepareStatement(updateSql)) {
                statement.setBoolean(1, author.isActive());
                statement.setString(2, author.getUniqueName());
                return statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Author> getAllAuthors() {
        String selectSql = "SELECT unique_name, registered_at AS registered, is_active " +
                "FROM tb_authors";
        List<Author> authors = new ArrayList<>();
        try (Statement statement = C3p0ConnectionsPool.getConnectionFromPool().createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectSql);
            while (resultSet.next()) {
                String uniqueName = resultSet.getString("unique_name");
                LocalDate registeredAt = resultSet.getObject("registered", LocalDate.class);
                boolean isActive = resultSet.getBoolean("is_active");
                Author author = new Author(uniqueName, registeredAt, isActive);
                authors.add(author);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return authors;
    }

    public List<String> getActiveAuthorsByRegisteredAt(LocalDate date) {
        String selectSql = "SELECT unique_name FROM tb_authors " +
                "WHERE is_active = TRUE AND registered_at = ?";
        List<String> authors = new ArrayList<>();
        try (PreparedStatement statement = C3p0ConnectionsPool.getConnectionFromPool().prepareStatement(selectSql)) {
            statement.setObject(1, date);
            ResultSet resultSet = statement.executeQuery();
            authors.add(resultSet.getString("unique_name"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return authors;
    }
}
