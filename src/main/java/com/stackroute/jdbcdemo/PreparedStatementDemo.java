package com.stackroute.jdbcdemo;

import java.sql.*;

public class PreparedStatementDemo {
    public void getAllStudents() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase", "root", "Root@123");
            String query = "insert into student values(?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 5);
            preparedStatement.setString(2, "santhosh varma");
            preparedStatement.setInt(3, 23);
            int count = preparedStatement.executeUpdate();
            System.out.println(count + " row inserted");


        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
            }
        }
    }

    public void getStudentByName(String name) {
        Connection connection = null;
        try {
            //register driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase", "root", "Root@123");
            String query = "select * from student where name=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String name1 = result.getString("name");
                int age = result.getInt("age");
                System.out.println(id + "\t" + name1 + "\t" + age);

            }
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }

    }
}
