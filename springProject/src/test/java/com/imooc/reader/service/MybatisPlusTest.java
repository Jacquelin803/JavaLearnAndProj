package com.imooc.reader.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imooc.reader.entity.Test;
import com.imooc.reader.mapper.TestMapper;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MybatisPlusTest {

    @Resource
    private TestMapper testMapper;   // test entity

    @org.junit.Test
    public void testInsert(){
        Test test = new Test(); //约定表结构的类
        test.setContent("Mybatis Plus Test");
        testMapper.insert(test);
    }
    @org.junit.Test
    public void testUpdate(){
        Test test = testMapper.selectById(8);
        test.setContent("Mybatis Plus Test1");
        testMapper.updateById(test);
    }
    @org.junit.Test
    public void testDelete(){
        testMapper.deleteById(8);
    }
    @org.junit.Test
    public void testSelect(){
        QueryWrapper<Test> queryWrapper = new QueryWrapper<Test>();
        queryWrapper.eq("id",18);   // =
        queryWrapper.gt("id",5);  // >   , 有两条，就会用and连起来
        List<Test> testList = testMapper.selectList(queryWrapper);
        System.out.println(testList.get(0).getContent());
    }

}
