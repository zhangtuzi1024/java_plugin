package com.zhangtuzi.study;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.exceptions.ValidateException;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.RuntimeUtil;
import cn.hutool.cron.CronUtil;
import org.junit.Test;

import java.net.URL;
import java.util.List;

public class SampleTest {

    /**
     * 图形验证码
     */
    @Test
    public void captcha() {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        System.out.println(lineCaptcha.getCode());

        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);

        lineCaptcha.write(projectPath + "/captcha.png");
    }

    /**
     * 正则提取
     */
    @Test
    public void regular() {
        //提取标签里的内容
        String content = "<div>你好</div><span>你叫什么</span>";
        List<String> results = ReUtil.findAll("<.*?>(.+?)</.*?>", content, 1);
        for (String result : results) {
            System.out.println(result);
        }

        //去除标签
        String noLabelContent = ReUtil.replaceAll(content, "(<.*?>|</.*?>)", "");
        System.out.println(noLabelContent);
    }

    /**
     * 资源工具
     */
    @Test
    public void resource() {
        URL url = ResourceUtil.getResource("");
        System.out.println(url);

        url = ResourceUtil.getResource("test.txt");
        System.out.println(url);

        String txt = ResourceUtil.readUtf8Str("test.txt");
        System.out.println(txt);
    }

    /**
     * 随机数
     */
    @Test
    public void random() {
        //取值范围(大于等于下标，小于上标)
        int num = RandomUtil.randomInt(1, 10);
        System.out.println(num);
    }

    /**
     * 命令行工具
     */
    @Test
    public void runtime() {
        String result = RuntimeUtil.execForStr("ipconfig");
        System.out.println(result);
    }

    /**
     * 定时任务
     */
    @Test
    public void cron() throws InterruptedException {
        //支持秒级别定时任务
        CronUtil.setMatchSecond(true);
        //启动
        CronUtil.start();

        while (true) {
            Thread.sleep(1000 * 60);
        }
    }

    /**
     * 校验类
     */
    @Test
    public void validate() {
        System.out.println(Validator.isEmail("1@qq.com"));
        System.out.println(Validator.isMobile("13712345678"));
        System.out.println(Validator.isPlateNumber("皖A12345"));
        System.out.println(Validator.isMoney("20.5"));
        System.out.println(Validator.isWord("abc"));

        try {
            Validator.validateNumber("abc", "xxx不是数字");
        } catch (ValidateException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
