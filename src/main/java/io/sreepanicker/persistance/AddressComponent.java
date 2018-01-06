/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.sreepanicker.persistance;

import io.sreepanicker.model.Address;
import java.util.List;

/**
 *
 * @author sreejithu panicker
 */
public interface AddressComponent {
    public List<Address> getAddressBookList();
    public void insertAddress(Address address);
    public void deleteAddress(int id);
}
