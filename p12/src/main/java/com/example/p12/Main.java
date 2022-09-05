package com.example.p12;

import com.google.gson.Gson;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.security.KeyStore;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
//        RestTemplate restTemplate = new RestTemplate();
//        Gson gson = new Gson();
//        OrderWithdrawRestRequestDto dto = new OrderWithdrawRestRequestDto(new BigDecimal(100), "4111111111111111");
//        ResponseEntity<String> orderRestResponseDtoResponseEntity = restTemplate.postForEntity(
//                "/https://api-sandbox.cibpay.co/orders/credit",
//                dto,
//                String.class
//        );
//        List<String> location = orderRestResponseDtoResponseEntity.getHeaders().get("Location");
//        OrderListDto orderListDto = gson.fromJson(orderRestResponseDtoResponseEntity.getBody(), OrderListDto.class);
//        orderListDto.getOrders().get(0).setCheckoutUrl(location.get(0));
//        System.out.println(orderListDto.getOrders().get(0));

//        BasicCredentialsProvider credential = new BasicCredentialsProvider();
//        credential.setCredentials(AuthScope.ANY, new NTCredentials(null, "Basic VG9wYXouQVBJOmpPdHpCMU1jWnR3andhU2lLWUJyMS8vSA=='", null, "domain"));

        KeyStore clientStore = KeyStore.getInstance("PKCS12");
        clientStore.load(new FileInputStream("/home/parvin/Downloads/Topaz.API.p12"), "hyTQpGvGFH04".toCharArray());

        SSLContext sslContext = SSLContextBuilder.create()
                .setProtocol("TLS")
                .loadKeyMaterial(clientStore, "hyTQpGvGFH04".toCharArray())
                .loadTrustMaterial(new TrustSelfSignedStrategy())
                .build();

        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext);
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(sslConnectionSocketFactory)
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);

        RestTemplate restTemplate = new RestTemplate(requestFactory);
        Gson gson = new Gson();
        OrderWithdrawRestRequestDto dto = new OrderWithdrawRestRequestDto(new BigDecimal(100), "4111111111111111");
        ResponseEntity<String> orderRestResponseDtoResponseEntity = restTemplate.postForEntity(
                "/https://api-sandbox.cibpay.co/orders/credit",
                dto,
                String.class
        );
        List<String> location = orderRestResponseDtoResponseEntity.getHeaders().get("Location");
        OrderListDto orderListDto = gson.fromJson(orderRestResponseDtoResponseEntity.getBody(), OrderListDto.class);
        orderListDto.getOrders().get(0).setCheckoutUrl(location.get(0));
        System.out.println(orderListDto.getOrders().get(0));
    }
}
