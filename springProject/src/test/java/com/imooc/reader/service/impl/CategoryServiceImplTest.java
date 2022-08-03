package com.imooc.reader.service.impl;


/**
 * 开发流程：
 * entity-Mapper-Service - category.xml -
 * test -
 * controller - 与模板引擎index.ftl进行整合，模板引擎进行读取数据然后展示
 */

import com.imooc.reader.entity.Category;
import com.imooc.reader.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CategoryServiceImplTest {
    @Resource
    private CategoryService categoryService;  // 属性名与容器里实现类的名一致
    @Test
    public void selectAll() {
        List<Category> list = categoryService.selectAll();
        System.out.println(list);
    }
}