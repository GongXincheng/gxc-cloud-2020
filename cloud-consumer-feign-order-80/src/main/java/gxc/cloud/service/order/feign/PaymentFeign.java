package gxc.cloud.service.order.feign;

import gxc.cloud.commons.entity.Payment;
import gxc.cloud.commons.entity.ServerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author GongXincheng
 * @date 2020-03-09 23:28
 */
@FeignClient(name = "cloud-payment-service")
public interface PaymentFeign {

    @PostMapping("/payment")
    ServerResponse create(@RequestBody Payment payment);

    @GetMapping("/payment/{id}")
    ServerResponse<Payment> getPaymentById(@PathVariable(name = "id") Long id);

    @GetMapping("/payment/discovery")
    ServerResponse<Map> discovery();

    @GetMapping("/payment/timeOut")
    String feignTimeOut();
}
