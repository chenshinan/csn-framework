package com.chenshinan.framework.infra.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author shinan.chen
 * @date 2021/05/29
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // 方法需要有ApiOperation注解才能生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 路径使用any风格
                .paths(PathSelectors.any())
                .build()
                // 接口文档的基本信息
                .apiInfo(apiInfo());
    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://localhost:8011/swagger-ui.html
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("csn-framework")
                .termsOfServiceUrl("http://localhost:8011")
                .version("1.0.0")
                .build();
    }
}
