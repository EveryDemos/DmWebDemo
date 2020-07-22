package com.budi.webdemo.dao;

import com.budi.webdemo.domain.User;
import com.budi.webdemo.jdbc.DBconn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class  UserDao {
    private Connection conn=DBconn.getInstance().getConnection();
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    public List<User> selectAllUser(){
        List<User> usersList = new ArrayList<>();
        User user=null;
        String sql="select * from  SYSDBA.USERS";
        try {
           ps= conn.prepareStatement(sql);
           rs=ps.executeQuery(sql);
           while (rs.next()){
               user=new User();
               user.setId(rs.getString("id"));
               user.setName(rs.getString("name"));
               user.setPwd(rs.getString("pwd"));
               user.setSex(rs.getString("sex"));
               user.setHome(rs.getString("home"));
               user.setInfo(rs.getString("info"));
               usersList.add(user);
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBconn.getInstance().release(conn,ps,rs);
        }
        return  usersList;
    }
}
