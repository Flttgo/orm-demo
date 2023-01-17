package com.example.orm.mapper;

import com.example.orm.dao.UserDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    //只是整合测试，为了可读性，只写了一个方法
    List<UserDao> queryUserList();

    @Update("update users set age = age+100 where id=1;")
    void updateAge();
}
