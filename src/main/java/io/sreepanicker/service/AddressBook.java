/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.sreepanicker.service;

import io.sreepanicker.model.Address;
import io.sreepanicker.persistance.AddressComponent;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Main controller for Address book application. 
 * @author sreejithu panicker
 */
@RestController
public class AddressBook {
    
    @Autowired
    private AddressComponent  addressComponent;
    
    
    @RequestMapping(value ="/v1/address" ,method=RequestMethod.GET)
    public List<Address> getAddressList() throws NotFoundException{
        List<Address> address = addressComponent.getAddressBookList();
        if (address.size() < 0){
            throw new NotFoundException("No records found");
        }
        return address;
    }
    
    @RequestMapping(value="/v1/address/{id}", method=RequestMethod.GET)
    public  void getAddressById(@PathVariable("id") int id){
        //return Address;
    }
    
    @RequestMapping(value="/v1/address", method=RequestMethod.POST)
    public void createAddress(@RequestBody Address address){
        addressComponent.insertAddress(address);
        
    }
    
    @RequestMapping(value="/v1/address/{id}", method=RequestMethod.DELETE)
    public  void removeAddressById(@PathVariable("id") int id){
        addressComponent.deleteAddress(id);
    }
    
    @RequestMapping(value="/v1/address/{id}", method=RequestMethod.PUT)
    public  void updateAddressById(@PathVariable("id") int id){
        //return Address;
    }
    
    @ExceptionHandler({DataAccessException.class, SQLException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void dataAccessException(Exception e){
        System.out.println("********************"+ e);
    }
}
