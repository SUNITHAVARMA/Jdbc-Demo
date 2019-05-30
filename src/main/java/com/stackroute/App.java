package com.stackroute;

import com.stackroute.jdbcdemo.*;


import javax.sql.RowSetMetaData;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        DataManager dataManager=new DataManager();
        dataManager.getAllStudents();

        PreparedStatementDemo preparedStatementDemo=new PreparedStatementDemo();
        preparedStatementDemo.getAllStudents();
        preparedStatementDemo.getStudentByName("sunitha");

        ResultSetMetaDataDemo resultSetMetaDataDemo=new ResultSetMetaDataDemo();
        resultSetMetaDataDemo.getAllStudents();

        DatabaseMetaDataDemo databaseMetaDataDemo=new DatabaseMetaDataDemo();
        databaseMetaDataDemo.getDatabaseMetaData();

        JdbcTransactionDemo jdbcTransactionDemo=new JdbcTransactionDemo();
        jdbcTransactionDemo.transactionData();

        JdbcBatchProcessingDemo jdbcBatchProcessingDemo=new JdbcBatchProcessingDemo();
        jdbcBatchProcessingDemo.batchProcessing();

        RowSetDemo rowSetDemo=new RowSetDemo();
        rowSetDemo.rowSet();

    }
}
