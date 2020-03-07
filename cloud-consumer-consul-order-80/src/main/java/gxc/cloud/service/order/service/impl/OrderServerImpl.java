package gxc.cloud.service.order.service.impl;

import gxc.cloud.commons.entity.Payment;
import gxc.cloud.commons.entity.ServerResponse;
import gxc.cloud.service.order.service.OrderServer;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author GongXincheng
 * @date 2020-03-07 02:17
 */
@Service
public class OrderServerImpl implements OrderServer {

    @Resource
    private RestTemplate restTemplate;

    @Override
    public Payment getPaymentById(Long id) {
        return Objects.requireNonNull(restTemplate.exchange("http://CLOUD-PAYMENT-SERVICE/payment/{1}", HttpMethod.GET, null,
                new ParameterizedTypeReference<ServerResponse<Payment>>() {
                }, id).getBody()).getData();
    }

    @Override
    public void create(Payment payment) {
        ServerResponse serverResponse = restTemplate.postForObject("http://CLOUD-PAYMENT-SERVICE/payment", payment, ServerResponse.class);
        System.out.println(serverResponse);
    }
}
