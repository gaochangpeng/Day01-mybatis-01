package com.peng.mybatis.mapper;

import com.peng.mybatis.entity.Test1;
import org.apache.ibatis.annotations.Param;

// 增删改永远返回影响的行数
// 添加
public interface TestInsertMapper {

    /**
     *
     * @param test
     * @return      对应的是持久化对象
     */
    int insert(@Param("test") Test1 test);
}
