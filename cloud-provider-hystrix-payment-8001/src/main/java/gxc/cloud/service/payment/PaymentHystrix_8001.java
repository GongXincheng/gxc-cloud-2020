package gxc.cloud.service.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author GongXincheng
 * @date 2020-03-07 01:17
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
public class PaymentHystrix_8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrix_8001.class, args);
    }

}
