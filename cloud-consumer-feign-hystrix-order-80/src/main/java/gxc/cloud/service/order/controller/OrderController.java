package gxc.cloud.service.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import gxc.cloud.service.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author GongXincheng
 * @date 2020-03-13 01:38
 */
@Slf4j
@RestController
public class OrderController {


    @Resource
    private OrderService orderService;

    /**
     * 测试 Hystrix
     */
    @GetMapping("/order/info-ok/{id}")
    public String infoOk(@PathVariable("id") Integer id) {
        return orderService.info(id);
    }

    /**
     * 测试 Hystrix
     */
    @GetMapping("/order/info-time-out/{id}")
    @HystrixCommand(fallbackMethod = "infoTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    public String infoTimeOut(@PathVariable("id") Integer id) {
        return orderService.infoTimeOut(id);
    }


    public String infoTimeOutHandler(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " infoTimeOutHandler() ! -> " + id + "  WWWWWWWWW";
    }

}
