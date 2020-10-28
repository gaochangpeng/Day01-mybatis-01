package com.peng.mybatis;

import com.peng.mybatis.entity.Cate;
import com.peng.mybatis.entity.Product;
import com.peng.mybatis.entity.Test1;
import com.peng.mybatis.mapper.CateMapper;
import com.peng.mybatis.mapper.ProductMapper;
import com.peng.mybatis.mapper.TestInsertMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.math.BigDecimal;
import java.util.List;

public class TestMapper2 {
    public static void main(String[] args) {
        // 工厂模式
        // 构建者模式
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                TestMapper2.class.getClassLoader().getResourceAsStream("mybatis-config.xml")
        );
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 通过传入接口的反射对象获取mapper对象
        CateMapper cm = sqlSession.getMapper(CateMapper.class);
        ProductMapper pm = sqlSession.getMapper(ProductMapper.class);

        // 先保存主表的数据
        Cate cate = new Cate();
        cate.setName("华为");
        cm.insert(cate);

        // 再保存从表的数据
        System.out.println(cate.getCateId());
        for (int i = 0; i < 2; i++) {
            Product product = new Product();
            product.setTitle("华人牌-傻妞手机" + i);
            product.setContent("2060年-华人牌手机" + i);
            product.setImg("/imgs/phone/" +i+ ".png");
            product.setPrice(new BigDecimal("520"));
            product.setCateId(cate.getCateId());
            pm.insert(product);
        }

        // 先查询主表的数据
        List<Cate> cates = cm.selectList();
        System.out.println(cates);
        // 再查询从表的数据
        cates.forEach(item -> {
            List<Product> products = pm.selectByCateId(item.getCateId());
            item.setProductList(products);
        });
        System.out.println(cates);
    }
}
