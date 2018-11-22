package com.scrubele.DTO.impl;

import com.scrubele.DTO.DTO;
import com.scrubele.domain.Customer;
import com.scrubele.exceptions.NoSuchCustomerException;
import org.springframework.hateoas.Link;

import java.sql.Date;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

public class CustomerDTO extends DTO<Customer> {
    public CustomerDTO(Customer customer, Link link) throws NoSuchCustomerException {
        super(customer, link);
    }

    public Long getCustomerId() {
        return getEntity().getId();
    }

    public String getSNM() {
        return getEntity().getSNM();
    }

    public Date getBirth_day() {
        return getEntity().getBirth_day();
    }

    public String getAdress() {
        return getEntity().getAdress();
    }
    public String getNumber(){return getEntity().getNumber();}

}
