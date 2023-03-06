package ltd.regis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @BelongsProject: mybatis-demo
 * @BelongsPackage: ltd.regis.config
 * @Author: Regis
 * @CreateTime: 2023-03-04  09:21
 * @Description:
 * @Version: 1.0
 */
//swagger2.9.2无需这个
//@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 访问静态资源
     * */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * SpringBoot自动配置本身并不会把/swagger-ui.html
         * 这个路径映射到对应的目录META-INF/resources/下面
         * 采用WebMvcConfigurerAdapter将swagger的静态文件进行发布;
         */
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        //将所有/static/** 访问都映射到classpath:/static/ 目录下
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX +"/static/");
//        super.addResourceHandlers(registry);
    }
}
