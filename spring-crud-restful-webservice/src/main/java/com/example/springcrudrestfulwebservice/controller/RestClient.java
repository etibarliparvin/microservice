package com.example.springcrudrestfulwebservice.controller;

import com.example.springcrudrestfulwebservice.entity.Person;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RestClient {

    private static final String GET_ALL_PEOPLE_API = "http://localhost:9090/person";
    private static final String GET_PERSON_BY_ID_API = "http://localhost:9090/person/{id}";
    private static final String CREATE_PERSON_API = "http://localhost:9090/person";
    private static final String UPDATE_PERSON_API = "http://localhost:9090/person/{id}";
    private static final String DELETE_PERSON_API = "http://localhost:9090/person/{id}";

    static RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        System.out.println("#############################################3");
        callGetAllPeopleApi();
        System.out.println("##############################################");
        callGetPersonByIdApi();
        System.out.println("###############################################");
        callCreatePersonApi();
        System.out.println("###############################################");
        callUpdatePersonApi();
        System.out.println("###############################################");
        callDeleteApi();
    }

    private static void callGetAllPeopleApi() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<String> result = restTemplate.exchange(GET_ALL_PEOPLE_API, HttpMethod.GET, entity, String.class);
        System.out.println(result);
    }

    private static void callGetPersonByIdApi() {
        Map<String, Integer> param = new HashMap<>();
        param.put("id", 1);
        Person person = restTemplate.getForObject(GET_PERSON_BY_ID_API, Person.class, param);
        System.out.println(person);
    }

    private static void callCreatePersonApi() {
        Person person = new Person("Burak", "Yilmaz", "burak@gmail.com");
        ResponseEntity<Person> entity = restTemplate.postForEntity(CREATE_PERSON_API, person, Person.class);
        System.out.println(entity.getBody());
    }

    private static void callUpdatePersonApi() {
        Map<String, Integer> param = new HashMap<>();
        param.put("id", 3);
        Person person = new Person("Burakcik", "Yilmaz", "burakcik@gmail.com");
        restTemplate.put(UPDATE_PERSON_API, person, param);
    }

    private static void callDeleteApi() {
        Map<String, Integer> param = new HashMap<>();
        param.put("id", 3);
        restTemplate.delete(DELETE_PERSON_API, param);
    }
}
