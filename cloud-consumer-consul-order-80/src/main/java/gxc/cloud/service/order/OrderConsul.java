package gxc.cloud.service.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author GongXincheng
 * @date 2020-03-07 02:10
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsul {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsul.class, args);
    }
}
