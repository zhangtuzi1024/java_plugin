package com.zhangtuzi.study.job;

import cn.hutool.core.util.StrUtil;

public class Job1 implements Runnable {
    private int count;

    @Override
    public void run() {
        increase();
        System.out.println(StrUtil.format("【{}】-任务1执行次数：{}", Thread.currentThread().getName(), count));
    }

    private synchronized void increase() {
        count++;
    }
}
