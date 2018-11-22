package com.scrubele.DTO.impl;

import com.scrubele.DTO.DTO;
import com.scrubele.domain.Mobile;
import com.scrubele.domain.Cpu;
import com.scrubele.exceptions.NoSuchMobileException;
import com.scrubele.exceptions.NoSuchCpuException;
import com.scrubele.exceptions.NoSuchCustomerException;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

public class MobileDTO extends DTO<Mobile> {
    public MobileDTO(Mobile mobile, Link link) throws NoSuchCustomerException, NoSuchCpuException, NoSuchMobileException {
        super(mobile, link);
    }

    public Long getMobileId() {
        return getEntity().getId();
    }

    public String getCategory() {
        return getEntity().getCatery();
    }

    public String getMark() {
        return getEntity().getMark();
    }

    public String getColour() {
        return getEntity().getColour();
    }

//    public Set<Project> getArtistProjects() {
//        return getEntity().getProjects();
//    }

    public Cpu getCpu() {
        return getEntity().getCpuByCpu();
    }


}
