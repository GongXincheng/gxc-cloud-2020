package gxc.cloud.service.payment.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import gxc.cloud.service.payment.service.PaymentService;
import org.springframework.stereotype.Service;

/**
 * @author GongXincheng
 * @date 2020-03-07 01:47
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    /**
     * 测试成功
     */
    @Override
    public String infoOk(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " payment info ok! -> " + id + "\t hhhhh";
    }


    /**
     * 测试失败
     * <p>
     * 1：使用 @HystrixCommand 测试，hystrix的超时时间设置为3秒，但是业务逻辑执行了 5秒 或者 执行报错
     */
    @Override
    @HystrixCommand(fallbackMethod = "infoTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String infoTimeOut(Integer id) {
        // int i = 1 / 0;
        int timeOutNum = 3;
        try {
            Thread.sleep(timeOutNum * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + " payment info Error ! -> " + id + "\t 耗时[" + timeOutNum + "]秒钟";
    }

    public String infoTimeOutHandler(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " infoTimeOutHandler() ! -> " + id + "  WWWWWWWWW";
    }
}
