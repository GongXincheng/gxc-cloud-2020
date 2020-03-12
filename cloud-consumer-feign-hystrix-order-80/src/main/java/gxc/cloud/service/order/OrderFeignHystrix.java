package gxc.cloud.service.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author GongXincheng
 * @date 2020-03-13 01:36
 */
@EnableFeignClients
@SpringBootApplication
@EnableCircuitBreaker
public class OrderFeignHystrix {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHystrix.class, args);
    }

}
