package com.zycus.costSharing.repositories;

import com.zycus.costSharing.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface CustomerRepo extends MongoRepository<Customer, String>{

    Customer findByCustomerName(String customername);
    Customer findByCustomerEmail(String customeremail);
    Customer findByCustomerEmailAndCustomerPassword(String email, String password);
    Customer findByCustID(long custID);
    List<Customer> findAll();

}