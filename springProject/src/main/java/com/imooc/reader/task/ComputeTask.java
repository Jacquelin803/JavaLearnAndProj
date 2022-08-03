package com.imooc.reader.task;

import com.imooc.reader.mapper.BookMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 完成自动计算任务 : 定时更新图书评分/评价数量
 */
@Component  // 不知道是该归于service还是controller，就用component
public class ComputeTask {

    @Resource
    private BookMapper bookMapper;

    @Scheduled(cron = "0 * * * * ?")  // 每分钟的0秒进行计算，也就是每分钟计算一次    // 加了Scheduled(cron = "0 * * * * ?") 这个注解，容器就会扫描到这个函数需要跑定时任务
    public void updateEvaluation(){
        bookMapper.updateEvaluation();
        System.out.println("已更新所有图书评分");

    }

}
