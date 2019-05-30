package com.stackroute.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcTransactionDemo {
    public void transactionData(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase", "root", "Root@123");
            connection.setAutoCommit(false);

            Statement stmt=connection.createStatement();
            stmt.executeUpdate("insert into student values(12,'sri',23)");
            stmt.executeUpdate("insert into student values(13,'anu',24)");

            connection.commit();
            connection.close();

        }catch (Exception e){
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
