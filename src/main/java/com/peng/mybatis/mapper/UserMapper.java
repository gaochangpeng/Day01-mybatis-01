package com.peng.mybatis.mapper;

import com.peng.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    // 保存（添加）
    int insert(@Param("user") User user);

    // 根据id查询（返回对象）
    User selectById(@Param("userId") int userId);
}
