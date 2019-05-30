package com.stackroute.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JdbcBatchProcessingDemo {
    public void batchProcessing(){
        PreparedStatement preparedStatement=null;
        Connection connection=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase", "root", "Root@123");
            con.setAutoCommit(false);

            Statement stmt = con.createStatement();
            stmt.addBatch("insert into student values(14,'rohith',23)");
            stmt.addBatch("insert into student values(15,'vijay',24)");


            stmt.executeBatch();//executing the batch

            con.commit();
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
            }
        }
    }

}
