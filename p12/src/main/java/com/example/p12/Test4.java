package com.example.p12;

import com.google.gson.Gson;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.security.KeyStore;
import java.util.List;

public class Test4 {
    public static void main(String[] args) throws Exception {

        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(new FileInputStream("/home/parvin/Downloads/Topaz.API.p12"), "hyTQpGvGFH04".toCharArray());

        SSLContext sslContext = SSLContextBuilder.create()
                .loadKeyMaterial(keyStore, "hyTQpGvGFH04".toCharArray())
                .loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();

        HttpClient client = HttpClients.custom().setSSLContext(sslContext).build();

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(client);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor("Topaz.API", "jOtzB1McZtwjwaSiKYBr1//H"));
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("https://api-sandbox.cibpay.co"));
        restTemplate.setRequestFactory(factory);

        Gson gson = new Gson();

        OrderWithdrawRestRequestDto dto = new OrderWithdrawRestRequestDto(new BigDecimal(100), "4111111111111111");
        ResponseEntity<String> orderRestResponseDtoResponseEntity = restTemplate.postForEntity(
                "https://api-sandbox.cibpay.co/orders/credit",
                dto,
                String.class
        );
        System.out.println(orderRestResponseDtoResponseEntity.getBody());
//        List<String> location = orderRestResponseDtoResponseEntity.getHeaders().get("Location");
//        OrderListDto orderListDto = gson.fromJson(orderRestResponseDtoResponseEntity.getBody(), OrderListDto.class);
//        orderListDto.getOrders().get(0).setCheckoutUrl(location.get(0));
//        System.out.println(orderListDto.getOrders().get(0));
    }
}
