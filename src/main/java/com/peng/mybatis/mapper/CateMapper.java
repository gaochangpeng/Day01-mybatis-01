package com.peng.mybatis.mapper;

import com.peng.mybatis.entity.Cate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

// 一级分类
public interface CateMapper {

    // 查询所有（返回List集合）
    List<Cate> selectList();

    // 添加（返回影响行数）
    int insert(@Param("cate") Cate cate);

}
