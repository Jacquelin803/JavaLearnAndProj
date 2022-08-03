package com.imooc.reader.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imooc.reader.entity.Category;
import com.imooc.reader.mapper.CategoryMapper;
import com.imooc.reader.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("categoryService") // 实现类在容器中的名与接口名保持一致,面向接口编程
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)   // 查询一般不使用事务
public class CategoryServiceImpl implements CategoryService {

    @Resource     // 必须注释，在容器中建立这个crud Mapper
    private CategoryMapper categoryMapper;  // 继承了BaseMapper，可以实现Crud
    /**
     * 查询所有图书分类
     * @return 图书分类List
     */
    public List<Category> selectAll() {
        List<Category> list = categoryMapper.selectList(new QueryWrapper<Category>());
        return list;

    }
}
