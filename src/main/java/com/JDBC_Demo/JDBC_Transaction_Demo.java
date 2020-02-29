package com.JDBC_Demo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC_Transaction_Demo {
    public static void main(String[] args) {
        // learnjdbc 数据库名称
        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "password";
        List<String> list = new ArrayList<>();
        list.add("xiaoxiao");
        list.add("xiaobai");
        list.add("xiaomm");
        // 设定隔离级别为READ COMMITTED:
       //
        // conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        /*
            数据库事务（Transaction）是由若干个SQL语句构成的一个操作序列，
            有点类似于Java的synchronized同步。
            数据库系统保证在一个事务中的所有SQL要么全部执行成功，
            要么全部不执行，即数据库事务具有ACID特性：

                Atomicity：原子性
                Consistency：一致性
                Isolation：隔离性
                Durability：持久性

         */
        /*mindmanager离线激活
        Connection conn = openConnection();
            try {
                // 关闭自动提交:
                conn.setAutoCommit(false);
                // 执行多条SQL语句:
                insert(); update(); delete();
                // 提交事务:
                conn.commit();
            } catch (SQLException e) {
                // 回滚事务:
                conn.rollback();
            } finally {
                conn.setAutoCommit(true);
                conn.close();
}
         */
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
            //
            connection.setAutoCommit(false);

            //do some thing

            connection.commit();
        }
        catch (SQLException e){
            try{
                connection.rollback();
            }
            catch (SQLException rollback){
                rollback.printStackTrace();
            }
        }
        finally {
            try{
            connection.setAutoCommit(true);
            connection.close();
            }
            catch (SQLException autocommit){
                autocommit.printStackTrace();
            }
        }



    }


}
