package com.spangular.spangular.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import com.amazonaws.util.StringUtils;
import com.spangular.spangular.database.dynamodb.models.Customer;
import com.spangular.spangular.database.dynamodb.repositories.CustomerRepository;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerRepository repository;

    @GetMapping()
    public Iterable<Customer> findAll(@RequestParam(name = "lastname") Optional<String> lastName) {
        // String result = "";
        Iterable<Customer> result = null;

        String MyLastName = "";

        // lastName.ifPresentOrElse(theLastName -> result = repository.findByLastName(theLastName),  result = repository.findAll());

        if(lastName.isPresent()){
            MyLastName = lastName.get();

            if (!StringUtils.isNullOrEmpty(MyLastName)) {
                result = repository.findByLastName(MyLastName);
            }
        }
        else{
            result = repository.findAll();
        }

        return result;
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable("id") String id) {
        Customer result;
        result = repository.findById(id).orElse(null);
        return result;
    }

    // @GetMapping
    // public List<Customer> fetchDataByLastName(@RequestParam(required = false,
    // name = "lastname") String lastName) {
    // List<Customer> result = repository.findByLastName(lastName);

    // // for (Customer cust : repository.findByLastName(lastName)) {
    // // result += cust.toString() + "<br>";
    // // }

    // return result;
    // }

    @DeleteMapping
    public String delete() {
        repository.deleteAll();
        return "Done";
    }

    @PostMapping
    public String save() {
        // save a single Customer
        repository.save(new Customer("JSA-1", "Jack", "Smith"));

        // // save a list of Customers
        // repository.save(Arrays.asList(new Customer("JSA-2", "Adam", "Johnson"), new
        // Customer("JSA-3", "Kim", "Smith"),
        // new Customer("JSA-4", "David", "Williams"), new Customer("JSA-5", "Peter",
        // "Davis")));

        return "Done";
    }
}