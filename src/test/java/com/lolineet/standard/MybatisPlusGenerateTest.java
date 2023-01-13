package com.lolineet.standard;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class MybatisPlusGenerateTest {
//    @Test
    public void generate() {
        FastAutoGenerator.create("jdbc:mysql://192.168.199.2:3306/lolineet", "root", "123456")
            .globalConfig(builder -> {
                builder.author("YUKI.N") // 设置作者
                        .enableSwagger() // 开启 swagger 模式
                        .fileOverride() // 覆盖已生成文件
                        .outputDir("F:\\mybatis-plus生成\\java"); // 指定输出目录
            })
            .packageConfig(builder -> {
                builder.parent("com.lolineet") // 设置父包名
                        .moduleName("standard") // 设置父包模块名
                        .pathInfo(Collections.singletonMap(OutputFile.xml, "F:\\mybatis-plus生成\\xml")); // 设置mapperXml生成路径
            })
            .strategyConfig(builder -> {
                builder.addInclude("district");
//                        .addInclude("anime")
//                        .addInclude("anime_video_middle");// 设置需要生成的表名
//                        .addTablePrefix("t_", "c_"); // 设置过滤表前缀
            })
            .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
            .execute();
    }
}
