package com.stackroute.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataManager {
    public void getAllStudents(){
        Connection connection=null;
        try {
            //register driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase", "root", "Root@123");
            //create statement
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                System.out.println(id);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                if (connection != null) connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
