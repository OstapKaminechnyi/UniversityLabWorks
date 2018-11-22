package com.scrubele.controller;

import com.scrubele.DTO.impl.CustomerDTO;
import com.scrubele.domain.Customer;
import com.scrubele.exceptions.ExistsMobilesForCustomerException;
import com.scrubele.exceptions.NoSuchMobileException;
import com.scrubele.exceptions.NoSuchCustomerException;
import com.scrubele.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/api/Customer/Mobile/{Mobile_id}")
    public ResponseEntity<Set<CustomerDTO>> getCustomersByMobileID(@PathVariable Long Mobile_id) throws NoSuchMobileException, NoSuchCustomerException {
        Set<Customer> CustomerSet = customerService.getCustomersByMobileId(Mobile_id);
        Link link = linkTo(methodOn(CustomerController.class).getAllCustomers()).withSelfRel();

        Set<CustomerDTO> CustomersDTO = new HashSet<>();
        for (Customer entity : CustomerSet) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            CustomerDTO dto = new CustomerDTO(entity, selfLink);
            CustomersDTO.add(dto);
        }

        return new ResponseEntity<>(CustomersDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/Customer/{Customer_id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Long Customer_id) throws NoSuchCustomerException, NoSuchMobileException {
        Customer Customer = customerService.getCustomer(Customer_id);
        Link link = linkTo(methodOn(CustomerController.class).getCustomer(Customer_id)).withSelfRel();

        CustomerDTO customerDTO = new CustomerDTO(Customer, link);

        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/Customer")
    public ResponseEntity<Set<CustomerDTO>> getAllCustomers() throws NoSuchCustomerException, NoSuchMobileException {
        List<Customer> CustomerSet = customerService.getAllCustomers();
        Link link = linkTo(methodOn(CustomerController.class).getAllCustomers()).withSelfRel();

        Set<CustomerDTO> CustomersDTO = new HashSet<>();
        for (Customer entity : CustomerSet) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            CustomerDTO dto = new CustomerDTO(entity, selfLink);
            CustomersDTO.add(dto);
        }

        return new ResponseEntity<>(CustomersDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/Customer")
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody Customer newCustomer) throws NoSuchCustomerException, NoSuchMobileException {
        customerService.createCustomer(newCustomer);
        Link link = linkTo(methodOn(CustomerController.class).getCustomer(newCustomer.getId())).withSelfRel();

        CustomerDTO customerDTO = new CustomerDTO(newCustomer, link);

        return new ResponseEntity<>(customerDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/Customer/{Customer_id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody Customer uCustomer, @PathVariable Long Customer_id) throws NoSuchCustomerException, NoSuchMobileException {
        customerService.updateCustomer(uCustomer, Customer_id);
        Customer Customer = customerService.getCustomer(Customer_id);
        Link link = linkTo(methodOn(CustomerController.class).getCustomer(Customer_id)).withSelfRel();

        CustomerDTO customerDTO = new CustomerDTO(Customer, link);

        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/Customer/{Customer_id}")
    public  ResponseEntity deleteCustomer(@PathVariable Long Customer_id) throws ExistsMobilesForCustomerException, NoSuchCustomerException {
        customerService.deleteCustomer(Customer_id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
