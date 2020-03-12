package gxc.cloud.service.payment.controller;

import gxc.cloud.service.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private String serverPort;

    /**
     * 测试 Hystrix
     */
    @GetMapping("/hystrix/info-ok/{id}")
    public String infoOk(@PathVariable("id") Integer id) {
        String result = paymentService.infoOk(id);
        log.info(result);
        return result;
    }

    /**
     * 测试 Hystrix
     */
    @GetMapping("/hystrix/info-time-out/{id}")
    public String infoTimeOut(@PathVariable("id") Integer id) {
        String result = paymentService.infoTimeOut(id);
        log.info(result);
        return result;
    }
}
