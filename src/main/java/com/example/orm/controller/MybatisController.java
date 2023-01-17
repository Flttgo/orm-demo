package com.example.orm.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.orm.dao.UserDao;
import com.example.orm.exception.CustomException;
import com.example.orm.mapper.UserMapper;
import com.example.orm.services.Counter;
import com.example.orm.services.UserService;
import com.example.orm.threads.MyThread;
import com.example.orm.threads.MyThread2;
import com.mysql.cj.ServerVersion;
import com.mysql.cj.Session;
import com.mysql.cj.exceptions.ExceptionInterceptor;
import com.mysql.cj.interceptors.QueryInterceptor;
import com.mysql.cj.jdbc.*;
import com.mysql.cj.jdbc.result.CachedResultSetMetaData;
import com.mysql.cj.jdbc.result.ResultSetInternalMethods;
import com.mysql.cj.log.Log;
import com.mysql.cj.protocol.ServerSessionStateController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

@RestController
@RequestMapping("/user")
public class MybatisController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;


    @GetMapping("/list")
    public JSONObject selectUser(){
        List<UserDao> userdaos = userMapper.queryUserList();
        JSONObject json = new JSONObject();
        json.put("code", 0);
        json.put("msg", "请求成功");

        List<Object> list = new ArrayList<>();
        for (UserDao user : userdaos) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", user.getId());
            map.put("name", user.getName());
            list.add(map);
        }
//        new Thread(()->{
//            json.put("test", 1);
//        }).start();

//        System.out.println("main start...");
//
//
//        Thread t = new Thread() {
//            public void run() {
//                System.out.println("thread run...");
//                System.out.println("thread end.");
//            }
//        };
//        t.start();
//        (new MyThread()).start();
//        (new Thread(new MyThread2())).start();
        json.put("data", list);
//        System.out.println("main end...");
        return json;
    }

    @GetMapping("/test")
    public int test() throws Exception {
//        Counter counter = new Counter();
//        counter.add(3);
//        counter.add(5);
//        String s = "abc";
//        int n = Integer.parseInt(s);

//        if (true) {
//            throw new CustomException("测试");
//        }

//        int a = 10 / 0;
        userService.addUser();

        return 2;
    }
}
