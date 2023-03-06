package ltd.regis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

/**
 * @BelongsProject: mybatis-demo
 * @BelongsPackage: ltd.regis
 * @Author: Regis
 * @CreateTime: 2023-02-28  08:19
 * @Description:
 * @Version: 1.0
 */

@SpringBootApplication(scanBasePackages = "ltd.regis")
@MapperScan("ltd.regis.mapper")
public class WebApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(WebApplication.class, args);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            if(beanDefinitionName.toLowerCase().contains("ebmvcconfig")){
                System.out.println(beanDefinitionName);
            }
        }
    }
}
