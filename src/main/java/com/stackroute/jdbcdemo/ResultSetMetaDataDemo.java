package com.stackroute.jdbcdemo;

import java.sql.*;

public class ResultSetMetaDataDemo {
    public void getAllStudents(){
        PreparedStatement preparedStatement=null;
        Connection connection=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtain connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase", "root", "Root@123");
            preparedStatement=connection.prepareStatement("select * from student");
            ResultSet rs=preparedStatement.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();

            System.out.println("Total columns: "+rsmd.getColumnCount());
            System.out.println("First column name: "+rsmd.getColumnName(1));
            System.out.println("First column datatype: "+rsmd.getColumnTypeName(1));

            connection.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
            }
        }

    }

}
