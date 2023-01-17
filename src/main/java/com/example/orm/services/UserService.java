package com.example.orm.services;

import com.example.orm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
   private UserMapper userMapper;

    @Transactional
    public void addUser() throws Exception {
        userMapper.updateAge();

        throw new RuntimeException("事务测试");
    }
}
