package com.budi.webdemo.service;

import com.budi.webdemo.domain.User;

import java.sql.ResultSet;
import java.util.List;

public interface Userservice {
   public List<User> selectAllUser();
}
