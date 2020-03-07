package gxc.cloud.service.payment.controller;

import gxc.cloud.commons.entity.Payment;
import gxc.cloud.commons.entity.ServerResponse;
import gxc.cloud.service.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author GongXincheng
 * @date 2020-03-07 01:49
 */
@Slf4j
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;


    @PostMapping("/payment")
    public ServerResponse create(@RequestBody Payment payment) {
        paymentService.create(payment);
        return ServerResponse.ok();
    }

    @GetMapping("/payment/{id}")
    public ServerResponse<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        payment.setSerial(payment.getSerial() + port);
        return ServerResponse.ok(payment);
    }
}
