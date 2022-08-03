package com.imooc.reader.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imooc.reader.entity.Test;

/**
 * 继承BaseMapper，BaseMapper里含有各种crud函数，
 * BaseMapper<Test>表示针对Test实体类，也就是针对test这张表进行crud
 */
public interface TestMapper extends BaseMapper<Test> {

    public void insertSample();
}
