package gxc.cloud.service.order;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author GongXincheng
 * @date 2020-03-10 00:28
 */
@Configuration
public class FeignConfiguration {

    /**
     * 设置Feign的日志级别
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
