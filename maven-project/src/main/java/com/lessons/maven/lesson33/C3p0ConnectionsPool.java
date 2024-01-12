package com.lessons.maven.lesson33;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class C3p0ConnectionsPool {
    private static ComboPooledDataSource pool = new ComboPooledDataSource();
    public static Connection getConnectionFromPool() throws SQLException {
        return pool.getConnection();
    }
}
