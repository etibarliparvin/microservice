package com.example.p12;

import com.google.gson.Gson;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.security.KeyStore;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        String basicAuth = "Basic " + new String(new Base64().encode("VG9wYXouQVBJOmpPdHpCMU1jWnR3andhU2lLWUJyMS8vSA==".getBytes()));

        KeyStore clientStore = KeyStore.getInstance("PKCS12");
        clientStore.load(new FileInputStream("/home/parvin/Downloads/Topaz.API.p12"), "hyTQpGvGFH04".toCharArray());

        SSLContext sslContext = SSLContextBuilder.create()
                .setProtocol("TLS")
                .loadKeyMaterial(clientStore, "hyTQpGvGFH04".toCharArray())
                .build();

        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext);
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(sslConnectionSocketFactory)
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", basicAuth);
        HttpEntity request = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        Gson gson = new Gson();

        OrderCreateRestRequestDto requestDto = new OrderCreateRestRequestDto(new BigDecimal(100), null, null);
        ResponseEntity<String> orderRestResponseDtoResponseEntity = restTemplate.postForEntity(
                "https://api-sandbox.cibpay.co/orders/9",
                request,
                String.class
        );
        List<String> location = orderRestResponseDtoResponseEntity.getHeaders().get("Location");
        OrderListDto orderListDto = gson.fromJson(orderRestResponseDtoResponseEntity.getBody(), OrderListDto.class);
        orderListDto.getOrders().get(0).setCheckoutUrl(location.get(0));
        System.out.println(orderListDto.getOrders().get(0));
    }
}
