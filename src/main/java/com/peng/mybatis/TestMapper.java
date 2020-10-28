package com.peng.mybatis;

import com.peng.mybatis.entity.Test1;
import com.peng.mybatis.entity.User;
import com.peng.mybatis.mapper.TestInsertMapper;
import com.peng.mybatis.mapper.TestSelectMapper;
import com.peng.mybatis.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

public class TestMapper {
    public static void main(String[] args) {
        // 工厂模式
        // 构建者模式
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                TestMapper.class.getClassLoader().getResourceAsStream("mybatis-config.xml")
        );
        // 原生mybatis 默认为 false  // 类似获取连接对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 通过传入接口的反射对象获取mapper对象
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // mapper对象调用添加的方法（返回结果是影响行）
        /*User user = new User();
        user.setUsername("哈啦啦");
        user.setPassword("10086");
        int insert = mapper.insert(user);
        System.out.println(insert);*/

        /*User user = mapper.selectById(2);
        System.out.println(user);*/



        // 通过接口的放射对象 获取 mapper 对象
        /*TestSelectMapper mapper = sqlSession.getMapper(TestSelectMapper.class);
        Test1 test1 = mapper.selectById(1);
        System.out.println(test1);

        List<Test1> test1s = mapper.selectList(0, 5);
        test1s.forEach(item ->{
            System.out.println(item.getId());
        });*/


        // 通过接口的反射对象 获取 mapper 对象
        TestInsertMapper mapper = sqlSession.getMapper(TestInsertMapper.class);
        Test1 test1 = new Test1();
        test1.setName("路飞");
        int insert = mapper.insert(test1);
        if(insert>0){
            System.out.println("添加成功！");
            System.out.println(test1.getId());  // 获取到 Id 可以做其他操作
        }else {
            System.out.println("添加失败！");
        }

    }
}
