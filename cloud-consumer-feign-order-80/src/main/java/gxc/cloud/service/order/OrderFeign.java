package gxc.cloud.service.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author GongXincheng
 * @date 2020-03-07 02:10
 */
@EnableFeignClients
@SpringBootApplication
public class OrderFeign {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeign.class, args);
    }
}
