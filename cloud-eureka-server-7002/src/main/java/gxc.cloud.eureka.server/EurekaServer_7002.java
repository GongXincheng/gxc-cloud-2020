package gxc.cloud.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author GongXincheng
 * @date 2020-03-07 15:31
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer_7002 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7002.class, args);
    }

}
