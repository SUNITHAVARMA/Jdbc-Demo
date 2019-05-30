package com.stackroute.jdbcdemo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class DatabaseMetaDataDemo {
    public void getDatabaseMetaData(){
        Connection connection = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/studentdatabase", "root", "Root@123");
            DatabaseMetaData databaseMetaData=con.getMetaData();

            System.out.println("Driver Name: "+databaseMetaData.getDriverName());
            System.out.println("Driver Version: "+databaseMetaData.getDriverVersion());
            System.out.println("UserName: "+databaseMetaData.getUserName());
            System.out.println("Database Product Name: "+databaseMetaData.getDatabaseProductName());
            System.out.println("Database Product Version: "+databaseMetaData.getDatabaseProductVersion());

            con.close();
        }catch(Exception e){ System.out.println(e);}
        finally {
            try{
                if (connection != null) connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
