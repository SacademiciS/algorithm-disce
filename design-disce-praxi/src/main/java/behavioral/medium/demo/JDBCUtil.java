package behavioral.medium.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtil {

    public static final String URL = "jdbc:mysql://42.194.146.108:3306/itstack-demo-design";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    public static void main(String[] args) throws Exception {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获得数据库连接
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.操作数据库，实现增删改查
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT id, name, age, createTime, updateTime FROM user");
        //如果有数据，rs.next()返回true
        while (resultSet.next()) {
            System.out.println(String.format("测试结果 姓名：%s 年龄：%s", resultSet.getString("name"), resultSet.getInt("age")));
        }
    }
}
