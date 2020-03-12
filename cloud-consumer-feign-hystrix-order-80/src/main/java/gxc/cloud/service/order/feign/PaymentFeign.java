package gxc.cloud.service.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author GongXincheng
 * @date 2020-03-13 01:37
 */
@FeignClient(name = "cloud-hystrix-payment-service")
public interface PaymentFeign {

    /**
     * 测试 Hystrix
     */
    @GetMapping("/hystrix/info-ok/{id}")
    String infoOk(@PathVariable("id") Integer id);

    /**
     * 测试 Hystrix
     */
    @GetMapping("/hystrix/info-time-out/{id}")
    String infoTimeOut(@PathVariable("id") Integer id);

}
