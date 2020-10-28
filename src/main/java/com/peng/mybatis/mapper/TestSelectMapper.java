package com.peng.mybatis.mapper;

import com.peng.mybatis.entity.Test1;
import org.apache.ibatis.annotations.Param;

import java.util.List;

// 查询
public interface TestSelectMapper {
    /**
     * 一个 mapper借口对应一个数据库表的操作
     * 方法命名 一般使用SQL的关键字
     * 返回值  查询返回对应的持久化对象或者集合
     * 参数   如果参数数量比较少  直接使用基本类型声明 使用对象(不要使用 map)
     * 能用id尽量使用id
     */

    // 通过id查询（能用id尽量使用id查询）
    Test1 selectById(@Param("id") Integer id);

    // 分页查询
    List<Test1> selectList(@Param("page") Integer page, @Param("size") Integer size);

}
