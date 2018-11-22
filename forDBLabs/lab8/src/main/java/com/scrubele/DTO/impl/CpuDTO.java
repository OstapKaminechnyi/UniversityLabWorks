package com.scrubele.DTO.impl;

import com.scrubele.DTO.DTO;
import com.scrubele.controller.MobileController;
import com.scrubele.domain.Mobile;
import com.scrubele.domain.Cpu;
import com.scrubele.exceptions.NoSuchMobileException;
import com.scrubele.exceptions.NoSuchCpuException;
import com.scrubele.exceptions.NoSuchCustomerException;
import org.springframework.hateoas.Link;

import java.util.Date;
import java.util.Set;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;


public class CpuDTO extends DTO<Cpu> {
    public CpuDTO(Cpu cpu, Link link) throws NoSuchCpuException, NoSuchCustomerException, NoSuchMobileException {
        super(cpu, link);
        add(linkTo(methodOn(MobileController.class).getMobilesbyCpuId(getEntity().getId())).withRel("mobile"));
    }

    public Long getMobileId() {
        return getEntity().getId();
    }

    public Integer getCpuVolume() {
        return getEntity().getVolume();
    }

    public float getCpuFee() {
        return getEntity().getFee();
    }

    public Date getCpuProd_year() {
        return getEntity().getProd_year();
    }

  

    public Set<Mobile> getMobiles() {
        return getEntity().getMobile();
    }
}
