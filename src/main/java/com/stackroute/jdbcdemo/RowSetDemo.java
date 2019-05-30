package com.stackroute.jdbcdemo;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSetDemo {
    public void rowSet(){
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            rowSet.setUrl("jdbc:mysql://localhost:3306/studentdatabase");
            rowSet.setUsername("root");
            rowSet.setPassword("Root@123");
            rowSet.setCommand("select * from Student");
            rowSet.execute();
            while(rowSet.next())
            {
                System.out.println("id: "+ rowSet.getInt(1));
                System.out.println("Name: "+ rowSet.getString(2));
                System.out.println("age: "+ rowSet.getInt(3));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
