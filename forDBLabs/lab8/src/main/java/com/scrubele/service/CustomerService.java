package com.scrubele.service;

import com.scrubele.Repository.MobileRepository;
import com.scrubele.Repository.CustomerRepository;
import com.scrubele.domain.Mobile;
import com.scrubele.domain.Customer;
import com.scrubele.exceptions.ExistsMobilesForCustomerException;
import com.scrubele.exceptions.NoSuchMobileException;
import com.scrubele.exceptions.NoSuchCustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository CustomerRepository;

    @Autowired
    MobileRepository MobileRepository;

    public Set<Customer> getCustomersByMobileId(Long Mobile_id) throws NoSuchMobileException {
        Mobile Mobile = MobileRepository.findById(Mobile_id).get();//2.0.0.M7
        if (Mobile == null) throw new NoSuchMobileException();
        return Mobile.getCustomers();
    }

    public Customer getCustomer(Long Customer_id) throws NoSuchCustomerException {
        Customer Customer = CustomerRepository.findById(Customer_id).get();//2.0.0.M7
        if (Customer == null) throw new NoSuchCustomerException();
        return Customer;
    }

    public List<Customer> getAllCustomers() {
        return CustomerRepository.findAll();
    }

    @Transactional
    public void createCustomer(Customer Customer) {
        CustomerRepository.save(Customer);
    }

    @Transactional
    public void updateCustomer(Customer uCustomer, Long Customer_id) throws NoSuchCustomerException {
        Customer Customer= CustomerRepository.findById(Customer_id).get();//2.0.0.M7
        if (Customer == null) throw new NoSuchCustomerException();
        //update
        Customer.setSNM(uCustomer.getSNM());
    }

    @Transactional
    public void deleteCustomer(Long Customer_id) throws NoSuchCustomerException, ExistsMobilesForCustomerException {
        Customer Customer = CustomerRepository.findById(Customer_id).get();//2.0.0.M7

        if (Customer == null) throw new NoSuchCustomerException();
        if (Customer.getMobileSet().size() != 0) throw new ExistsMobilesForCustomerException();
        CustomerRepository.delete(Customer);
    }
}
