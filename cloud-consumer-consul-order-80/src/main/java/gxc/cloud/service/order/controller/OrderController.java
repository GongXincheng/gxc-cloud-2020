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

/**
 * @author GongXincheng
 * @date 2020-03-07 02:16
 */
@Slf4j
@RestController
public class OrderController {

    @Resource
    private OrderServer orderServer;

    @GetMapping("/order/payment/{id}")
    public ServerResponse<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = orderServer.getPaymentById(id);
        return ServerResponse.ok(payment);
    }

    @PostMapping("/order/payment")
    public ServerResponse create(@RequestBody Payment payment) {
        orderServer.create(payment);
        return ServerResponse.ok();
    }


}
