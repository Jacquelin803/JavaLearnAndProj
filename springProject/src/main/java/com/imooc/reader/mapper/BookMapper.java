package com.imooc.reader.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imooc.reader.entity.Book;

public interface BookMapper extends BaseMapper<Book> {

    /**
     * 更新图书评分/评价数量，这个函数在BaseMapper中不会封装
     */
    public void updateEvaluation();

}
