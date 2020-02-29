package com.JDBC_Demo;
import com.zaxxer.hikari.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
    JDBC Pool的基本用法，如何建立一个HIkari配置
    然后用配置新建 datasource
    再用datasource建立新的连接


 */
public class JDBC_Connection_Pool {
    public static void main(String[] args) {
        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "password";

        final HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(JDBC_URL);
        hikariConfig.setUsername(JDBC_USER);
        hikariConfig.setPassword(JDBC_PASSWORD);

        hikariConfig.addDataSourceProperty("connectionTimeout",1000);
        hikariConfig.addDataSourceProperty("idleTimeout",60000);
        //最大连接数
        hikariConfig.addDataSourceProperty("maximumPoolSize",10);

        DataSource ds = new HikariDataSource(hikariConfig);

        //创建线程池后， 不需要DriverManager.getconnecntion
        //而是 ds。get
        //不需要传入 地址，用户密码信息，因为config已经配置过了
        try(final Connection connection = ds.getConnection()){
            try(final PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,grade,name,gender,score FROM students WHERE score > 90"))
            {
                final ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    long id = resultSet.getLong(1); // index = 1 开始
                    long grade = resultSet.getLong(2);
                    String name = resultSet.getString(3);
                    int gender = resultSet.getInt(4);
                    int score = resultSet.getInt(5);
                    System.out.println("id : " + id + " grade : " + grade +
                            " name : " + name + " gender : " + gender + " score : " + score);
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
