package gxc.cloud.service.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author GongXincheng
 * @date 2020-03-07 01:17
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentService_8006 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentService_8006.class, args);
    }

}
