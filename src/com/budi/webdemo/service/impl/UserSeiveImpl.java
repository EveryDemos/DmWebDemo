package com.budi.webdemo.service.impl;

import com.budi.webdemo.dao.UserDao;
import com.budi.webdemo.domain.User;
import com.budi.webdemo.service.Userservice;

import javax.annotation.Resource;
import javax.jws.WebService;
import java.sql.ResultSet;
import java.util.List;

public class UserSeiveImpl implements Userservice {
    UserDao ud=new UserDao();

    @Override
    public List<User> selectAllUser() {
        return ud.selectAllUser();
    }
}
