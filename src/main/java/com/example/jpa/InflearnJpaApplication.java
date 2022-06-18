package com.example.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SpringBootApplication
public class InflearnJpaApplication {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/springdata";
        String username = "postgres";
        String password= "chu";

        try(Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection created: " + connection);
//            String sql = "create table account (id int, username varchar(255), password varchar(255));";
            String sql = "insert into account values(1, 'chu', 'chu');";
            try(PreparedStatement statment = connection.prepareStatement(sql)) {
                statment.execute();
            }
        }

        SpringApplication.run(InflearnJpaApplication.class, args);

    }

}
