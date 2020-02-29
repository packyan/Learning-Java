package com.JDBC_Demo;
/*
    用JDBC 来对数据库进行操作
    一个MySQL的JDBC的驱动就是一个jar包，
    它本身也是纯Java编写的。
    我们自己编写的代码只需要引用Java标准库提供的java.sql包下面的相关接口，
    由此再间接地通过MySQL驱动的jar包通过网络访问MySQL服务器，
    所有复杂的网络通讯都被封装到JDBC驱动中，
    因此，Java程序本身只需要引入一个MySQL驱动的jar包就可以正常访问MySQL服务器：
 */
import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {
        // learnjdbc 数据库名称
        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc?useSSL=false&characterEncoding=utf8";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "password";
        //用createStateMent查询
        /*
        JDBC查询
            获取到JDBC连接后，下一步我们就可以查询数据库了。查询数据库分以下几步：

            第一步，通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；

            第二步，执行Statement对象提供的executeQuery("SELECT * FROM students")并传入SQL语句，执行查询并获得返回的结果集，使用ResultSet来引用这个结果集；

            第三步，反复调用ResultSet的next()方法并读取每一行结果。
         */
        try(Connection connection = DriverManager.getConnection(JDBC_URL,JDBC_USER, JDBC_PASSWORD)){
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery("SELECT id,grade,name,gender FROM students WHERE gender=1")){
                    while(resultSet.next()){
                        //通过 resultset 。next 获取数据
                        long id = resultSet.getLong(1); // index = 1 开始
                        long grade = resultSet.getLong(2);
                        String name = resultSet.getString(3);
                        int gender = resultSet.getInt(4);
                        System.out.println("id : " + id + " grade : " + grade +
                                " name : " + name + " gender : " + gender);
                    }
                }
            }
        }catch (SQLException r){
            r.printStackTrace();
        }

    //使用Statement拼字符串非常容易引发SQL注入的问题，
        // 这是因为SQL参数往往是从方法参数传入的。
        // 容易引发SQL 注入攻击
        //PreparedStatement 比Statement更安全，而且更快。
        // 使用Java对数据库进行操作时，必须使用PreparedStatement，严禁任何通过参数拼字符串的代码！
        try(Connection connection_2 = DriverManager.getConnection(JDBC_URL, JDBC_USER,JDBC_PASSWORD)){

            try(PreparedStatement ps =  connection_2.prepareStatement("SELECT id, grade, name, gender FROM students WHERE gender = ? AND grade = ?")){
                ps.setObject(1,1);
                ps.setObject(2,3);
                System.out.println("\n using  prepareStatement");
                try(ResultSet resultSet = ps.executeQuery()){
                    while(resultSet.next()){
                    long id = resultSet.getLong(1); // index = 1 开始
                    long grade = resultSet.getLong(2);
                    String name = resultSet.getString(3);
                    int gender = resultSet.getInt(4);
                    System.out.println("id : " + id + " grade : " + grade +
                            " name : " + name + " gender : " + gender);
                    }
                }

                /*
                插入操作是INSERT，即插入一条新记录。通过JDBC进行插入，本质上也是用PreparedStatement执行一条SQL语句，
                不过最后执行的不是executeQuery()，
                而是executeUpdate()。示例代码如下：
                 */
            try(PreparedStatement preparedStatement = connection_2.prepareStatement("" +
                    "INSERT INTO students (grade,name,gender,score) VALUE (?,?,?,?)")){
                /*
                有几个?占位符就必须设置对应的参数
                 */
                preparedStatement.setObject(1,4);
                preparedStatement.setObject(2, "xiaoming");
                preparedStatement.setObject(3,1);
                preparedStatement.setObject(4,99);
                int n = preparedStatement.executeUpdate();


             }

            //返回主键的值

                /*
                一是调用prepareStatement()时，第二个参数必须传入常量Statement.RETURN_GENERATED_KEYS，否则JDBC驱动不会返回自增主键；

            二是执行executeUpdate()方法后，必须调用getGeneratedKeys()获取一个ResultSet对象，这个对象包含了数据库自动生成的主键的值，读取该对象的每一行来获取自增主键的值。
            如果一次插入多条记录，那么这个ResultSet对象就会有多行返回值。
            如果插入时有多列自增，那么ResultSet对象的每一行都会对应多个自增值
            （自增列不一定必须是主键）。
                 */
            try(PreparedStatement preparedStatement = connection_2.prepareStatement(
                    "INSERT INTO students (grade,name,gender,score) VALUE (?,?,?,?)"
            ,Statement.RETURN_GENERATED_KEYS)){
                preparedStatement.setObject(1,2);
                preparedStatement.setObject(2, "小马");
                preparedStatement.setObject(3,1);
                preparedStatement.setObject(4,39);
                int k = preparedStatement.executeUpdate();
                try(ResultSet rs = preparedStatement.getGeneratedKeys()){
                    if(rs.next()){
                        long id = rs.getLong(1);
                        System.out.println(" primary key : " + id);
                    }
                }
            }

                try(PreparedStatement preparedStatement = connection_2.prepareStatement(
                        "UPDATE students SET name = ? WHERE id = ?"
                )){
                    preparedStatement.setObject(1,"xiaoxu");
                    preparedStatement.setObject(2,1);
                    int i = preparedStatement.executeUpdate();
                    System.out.println(i);
                }
                try(PreparedStatement preparedStatement = connection_2.prepareStatement(
                        "DELETE FROM students WHERE id = ?"
                )){
                    preparedStatement.setObject(1,17);
                    preparedStatement.executeUpdate();
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
