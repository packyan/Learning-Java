package com.JDBC_Demo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC_Batch_Demo {
    public static void main(String[] args)  {
        // learnjdbc 数据库名称
        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "password";
        List<String> list = new ArrayList<>();
        list.add("xiaoxiao");
        list.add("xiaobai");
        list.add("xiaomm");
        /*
            循环执行每个PreparedStatement ，效率低

         */
        try(Connection con = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD))
        {

            for(String name : list){
                PreparedStatement preparedStatement = con.prepareStatement(
                        "INSERT INTO students (name, gender,score, grade) VALUE (?,?,?,?)");
                preparedStatement.setString(1,name);
                preparedStatement.setInt(2,1);
                preparedStatement.setInt(3,90);
                preparedStatement.setInt(4,5);
                preparedStatement.executeUpdate();
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }


        try(Connection con = DriverManager.getConnection(JDBC_URL,JDBC_USER, JDBC_PASSWORD)){
            PreparedStatement preparedStatement = con.prepareStatement("" +
                    "INSERT INTO students (name, gender, score, grade) VALUE (?,?,?,?)");

            for(var name: list){
                preparedStatement.setString(1,name);
                preparedStatement.setInt(2,1);
                preparedStatement.setInt(3,99);
                preparedStatement.setInt(4,5);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        }
        catch (SQLException e){
            e.printStackTrace();
        }


    }


}
