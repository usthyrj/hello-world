package ltd.regis.config;

import io.swagger.models.parameters.Parameter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.*;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: mybatis-demo
 * @BelongsPackage: ltd.regis.config
 * @Author: Regis
 * @CreateTime: 2023-03-04  08:51
 * @Description:
 * @Version: 1.0
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger2.enable}")
    private boolean enable;
    @Bean
    public Docket createDocket() {
        List<RequestParameter> headers = new ArrayList<>();
        RequestParameterBuilder requestParameterBuilder = new RequestParameterBuilder();
        requestParameterBuilder.name("token")
                .description("模拟调试token").in("header");
        headers.add(requestParameterBuilder.build());


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("ltd.regis.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalRequestParameters(headers)
                .enable(enable);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Spring Boot")
                .description("接口文档描述")
                .version("1.0")
                .build();
    }


}