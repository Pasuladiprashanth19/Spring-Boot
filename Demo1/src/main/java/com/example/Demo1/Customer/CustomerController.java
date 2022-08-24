package com.example.Demo1.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;


    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService= customerService;
    }



    @GetMapping
    public List<Customer> getCustomer(){
        return customerService.getCustomer();
    }
    @PostMapping
    public void registerNewCustomer(@RequestBody Customer customer){
        customerService.addNewCustomer(customer);
    }
    @DeleteMapping(path = "customerId")
    public void deleteStudent(@PathVariable("customerId" )Long customerId){
        customerService.deletecustomer(customerId);
    }
    @PutMapping(path = "customerId")
    public  void updateCustomer(
            @PathVariable("customerID") Long customerId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        customerService.updateCustomer(customerId,name,email);
    }





}
