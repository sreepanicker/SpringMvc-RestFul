/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.sreepanicker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.sreepanicker.model.Address;
import java.util.ArrayList;
import static junit.framework.Assert.*;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author sreep
 */
public class AddressBookTest {
    /**
     * This function will call the URI "v1/address" to get all the addressbook details.
     */
    @Test
    public void getAllAddress() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ArrayList<Address>> resposeEntity = restTemplate.exchange("http://localhost:8080/Spring-Restful/v1/address", HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<ArrayList<Address>>() {
        });
        ArrayList<Address> list = resposeEntity.getBody();
        list.forEach((addr) -> {
            System.out.println(addr.getFirstName());
        });

        assertNotNull("Address Book is null", list);
    }
    
    @Test
    public  void insertRecord(){
        RestTemplate restTemplate = new RestTemplate();
        Address address = new Address();
        address.setId(3);
        address.setFirstName("Adi");
        address.setLastName("Pan");
        address.setStreet("XXXXX");
        address.setProvince("ON");
        Address addr =restTemplate.postForObject("http://localhost:8080/Spring-Restful/v1/address", address, Address.class);
       assertNotNull("Inserted Address Box is null", addr);
    }

}
