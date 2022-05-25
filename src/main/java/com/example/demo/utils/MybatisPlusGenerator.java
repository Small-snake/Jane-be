/*
package com.example.demo.utils;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Collections;

*/
/**
 * @className: MybatisPlusGenerator
 * @description:
 * @author: sh.Liu
 * @date: 2022-01-26 11:19
 *//*

public class MybatisPlusGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://120.48.25.213:3306/Jane?useUnicode=true&useSSL=false&characterEncoding=utf8", "root", "Huang520!")
                .globalConfig(builder -> {
                    builder.author("smallsnake") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                           // .fileOverride() // 覆盖已生成文件
                            .outputDir(System.getProperty("user.dir")+"/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example") // 设置父包名
                            .moduleName("demo") // 设置父包模块名
                            // .service()  // 设置自定义service路径,不设置就是默认路径
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, System.getProperty("user.dir") +"/src/main/resources/mapper/")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("")  // 设置需要生成的表名
                            //.addTablePrefix("t_", "c_")// 设置过滤表前缀

                            .entityBuilder().addTableFills(
                                    new Column("create_time", FieldFill.INSERT),new Column("update_time", FieldFill.INSERT_UPDATE)); // 设置自动填充的时间字段

                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}



*/
