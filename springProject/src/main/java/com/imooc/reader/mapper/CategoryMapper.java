package com.imooc.reader.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imooc.reader.entity.Category;

/*图书分类Mapper接口*/
// BaseMapper默认提供了Crud方法，这里不需要写各种方法就可实现增删改查了

public interface CategoryMapper extends BaseMapper<Category> {

}
