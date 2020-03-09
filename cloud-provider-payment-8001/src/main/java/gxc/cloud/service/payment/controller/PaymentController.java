package gxc.cloud.service.payment.controller;

import gxc.cloud.commons.entity.Payment;
import gxc.cloud.commons.entity.ServerResponse;
import gxc.cloud.service.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GongXincheng
 * @date 2020-03-07 01:49
 */
@Slf4j
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

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

    /**
     * 服务发现
     */
    @GetMapping("/payment/discovery")
    public ServerResponse<Map> discovery() {
        List<String> services = discoveryClient.getServices();
        String description = discoveryClient.description();
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        Map<String, Object> result = new HashMap<>(16);
        result.put("services", services);
        result.put("description", description);
        result.put("instances", instances);
        result.put("discoveryClient", discoveryClient);
        return ServerResponse.ok(result);
    }

    /**
     * 测试客户端Feign调用超时
     */
    @GetMapping("/payment/timeOut")
    public String feignTimeOut() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return port;
    }
}
