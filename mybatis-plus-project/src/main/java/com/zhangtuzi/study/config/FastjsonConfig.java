package com.zhangtuzi.study.config;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;

public class FastjsonConfig {
    static {
        //java.lang.IncompatibleClassChangeError: Found interface xx.xxx, but class was expected
        //原因是自jdk1.8以后支持接口缺省方法。
        //JavaBeanSerializer序列化正常，使用ASMJavaBeanSerializer则报错。
        //类的上层接口有default方法没有被实现，导致此方法依旧属于接口，引起的序列化异常。
        //禁止fastjson使用asm反系列化
        ParserConfig.getGlobalInstance().setAsmEnable(false);
        SerializeConfig.getGlobalInstance().setAsmEnable(false);
    }
}
