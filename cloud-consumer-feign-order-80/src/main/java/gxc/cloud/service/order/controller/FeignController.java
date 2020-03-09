package gxc.cloud.service.order.controller;

import gxc.cloud.commons.entity.Payment;
import gxc.cloud.commons.entity.ServerResponse;
import gxc.cloud.service.order.service.OrderServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author GongXincheng
 * @date 2020-03-09 23:26
 */
@Slf4j
@RestController
public class FeignController {

    @Resource
    private OrderServer orderServer;

    @GetMapping("/feign/payment/{id}")
    public ServerResponse<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = orderServer.getPaymentById(id);
        return ServerResponse.ok(payment);
    }

    @PostMapping("/feign/payment")
    public ServerResponse create(@RequestBody Payment payment) {
        orderServer.create(payment);
        return ServerResponse.ok();
    }

    @GetMapping("/feign/payment/discovery")
    public ServerResponse<Map> discovery() {
        Map<String, Object> result = orderServer.discovery();
        return ServerResponse.ok(result);
    }


    @GetMapping("/feign/payment/timeOut")
    public ServerResponse<String> feignTimeOut() {
        String result = orderServer.feignTimeOut();
        return ServerResponse.ok(result);
    }
}
