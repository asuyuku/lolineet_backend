package com.lolineet.standard.conf;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                /**
                 * 重点说明:
                 * 其余都是可以默认,但是controller扫描的路径一定要该队,是该项目的controller包路径
                 */
                .apis(RequestHandlerSelectors.basePackage("com.lolineet.standard.controller"))
                //.paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                /**
                 * 指定项目的名称和主题
                 */
                .title("某某某系统")
                /**
                 * 描述项目的用途
                 */
                .description("某某某系统后端接口")
                /**
                 * name:使用者的姓名
                 * url:使用者的相关技术文章
                 * email:使用者的邮箱地址
                 */
                .contact(new Contact("janson", "http://www.baidu.com", "zdh@data.com"))
                .version("1.0")
                .build();
    }
}