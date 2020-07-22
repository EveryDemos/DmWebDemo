package com.budi.webdemo.jdbc;

import java.sql.*;

public class DBconn {

    private final static String url="jdbc:dm://127.0.0.1:5236/test";
    private final static String username="SYSDBA";
    private final static String password="SYSDBA";
    private static Connection conn=null;
    private static ResultSet rs=null;
    private static PreparedStatement ps=null;
    private static DBconn instance=null;
    static {
        try {
            Class.forName("dm.jdbc.driver.DmDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private DBconn (){}
    public static DBconn getInstance(){
        if(instance==null){
            synchronized (DBconn.class){
                if(instance==null){
                    instance=new DBconn();
                }
            }
        }
        return instance;
    }

    public  Connection getConnection()  {
        try {
            conn=DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            System.out.println("链接数据库异常***********************");
            e.printStackTrace();
        }
        return conn;
    }
    public void release(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;//如果rs没有被关闭，就置为空，变成一个垃圾对象，被垃圾回收器回收
        }
        if (st != null) {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            st = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        conn=DBconn.getInstance().getConnection();
        try {
            ps=conn.prepareStatement("select * from SYSDBA.USERS ");
            rs=ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
