package com.yixin.db;

import java.sql.*;

public class Main {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/imooc?useUnicode=true&characterEncoding=utf-8";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection conn = null;

    static {
        try {
//            1、加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
//            2、获得数据库的连接
            conn = DriverManager.getConnection(URL,USER,PASSWORD);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

    public static Connection getConnection () {
        return conn;
    }


//    public static void main(String[] args) throws Exception{
//	// write your code here
////        3、通过数据库的连接操作数据库，实现增删改查
//        Statement stmt = conn.createStatement();    //创建statement对象
//        ResultSet rs = stmt.executeQuery("select user_name,age from imooc_goddess");
//
//        //rs.next() 返回布尔值，true证明有数据；
//        while(rs.next()){
//            System.out.println(rs.getString("user_name")+","+rs.getInt("age"));
//        }
//
//    }
}
