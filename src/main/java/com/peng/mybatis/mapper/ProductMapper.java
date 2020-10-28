package com.peng.mybatis.mapper;

import com.peng.mybatis.entity.Cate;
import com.peng.mybatis.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

// 商品信息
public interface ProductMapper {
    // 根据分类CateId 查询商品
    List<Product> selectByCateId(@Param("cateId") int cateId);

    // 添加
    int insert(@Param("cate") Product product);
}
