package com.scrubele.controller;

import com.scrubele.DTO.impl.MobileDTO;
import com.scrubele.domain.Mobile;
import com.scrubele.exceptions.*;
import com.scrubele.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class MobileController {
    @Autowired
    MobileService MobileService;
// get Mobile by class id
    @GetMapping(value = "/api/mobile/cpu/{cpu_id}")
    public ResponseEntity<List<MobileDTO>> getMobilesbyCpuId(@PathVariable Long cpu_id) throws NoSuchCpuException, NoSuchMobileException, NoSuchCustomerException {
        Set<Mobile> MobileSet= MobileService.getMobilesByCpuId(cpu_id);

        Link link = linkTo(methodOn(MobileController.class).getAllMobiles()).withSelfRel();

        List<MobileDTO> MobilesDTO = new ArrayList<>();
        for (Mobile entity : MobileSet) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            MobileDTO dto = new MobileDTO(entity, selfLink);
            MobilesDTO.add(dto);
        }

        return new ResponseEntity<>(MobilesDTO, HttpStatus.OK);
    }
// get Mobile
    @GetMapping(value = "/api/mobile/{mobile_id}")
    public ResponseEntity<MobileDTO> getMobile(@PathVariable Long Mobile_id) throws NoSuchMobileException, NoSuchCustomerException, NoSuchCpuException {
        Mobile Mobile = MobileService.getMobile(Mobile_id);
        Link link = linkTo(methodOn(MobileController.class).getMobile(Mobile_id)).withSelfRel();

        MobileDTO mobileDTO = new MobileDTO(Mobile, link);

        return new ResponseEntity<>(mobileDTO, HttpStatus.OK);
    }
// get all Mobiles
    @GetMapping(value = "/api/Mobile")
    public ResponseEntity<Set<MobileDTO>> getAllMobiles() throws NoSuchMobileException, NoSuchCustomerException, NoSuchCpuException {
        List<Mobile> MobileSet = MobileService.getAllMobile();
        Link link = linkTo(methodOn(MobileController.class).getAllMobiles()).withSelfRel();

        Set<MobileDTO> MobilesDTO = new HashSet<>();
        for (Mobile entity : MobileSet) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            MobileDTO dto = new MobileDTO(entity, selfLink);
            MobilesDTO.add(dto);
        }

        return new ResponseEntity<>(MobilesDTO, HttpStatus.OK);
    }
// get Mobile
    @GetMapping(value = "/api/Mobile/Customer/{Customer_id}")
    public ResponseEntity<Set<MobileDTO>> getMobilesByCustomerID(@PathVariable Long Customer_id) throws NoSuchCustomerException, NoSuchMobileException, NoSuchCpuException {
        Set<Mobile> MobileSet = MobileService.getMobilesByCustomerId(Customer_id);
        Link link = linkTo(methodOn(MobileController.class).getAllMobiles()).withSelfRel();

        Set<MobileDTO> MobilesDTO = new HashSet<>();
        for (Mobile entity : MobileSet) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            MobileDTO dto = new MobileDTO(entity, selfLink);
            MobilesDTO.add(dto);
        }

        return new ResponseEntity<>(MobilesDTO, HttpStatus.OK);
    }
// add Mobile
    @PostMapping(value = "/api/Mobile/Cpu/{Cpu_id}")
    public  ResponseEntity<MobileDTO> addMobile(@RequestBody Mobile newMobile, @PathVariable Long Cpu_id)
            throws NoSuchCpuException, NoSuchMobileException, NoSuchCustomerException {
        MobileService.createMobile(newMobile, Cpu_id);
        Link link = linkTo(methodOn(MobileController.class).getMobile(newMobile.getId())).withSelfRel();

        MobileDTO mobileDTO = new MobileDTO(newMobile, link);

        return new ResponseEntity<>(mobileDTO, HttpStatus.CREATED);
    }
//update Mobile
    @PutMapping(value = "/api/Mobile/{Mobile_id}/Cpu/{Cpu_id}")
    public  ResponseEntity<MobileDTO> updateMobile(@RequestBody Mobile uMobile,
                                                   @PathVariable Long Mobile_id, @PathVariable Long Cpu_id)
            throws NoSuchCpuException, NoSuchMobileException, NoSuchCustomerException {
        MobileService.updateMobile(uMobile, Mobile_id, Cpu_id);
        Mobile Mobile = MobileService.getMobile(Mobile_id);
        Link link = linkTo(methodOn(MobileController.class).getMobile(Mobile_id)).withSelfRel();

        MobileDTO mobileDTO = new MobileDTO(Mobile, link);

        return new ResponseEntity<>(mobileDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/Mobile/{Mobile_id}")
    public  ResponseEntity deleteMobile(@PathVariable Long Mobile_id) throws NoSuchMobileException, ExistsCustomerForMobileException, ExistsCustomerForMobileException {
        MobileService.deleteMobile(Mobile_id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/api/Mobile/{Mobile_id}/Customer/{Customer_id}")
    public  ResponseEntity<MobileDTO> addCustomerForMobile(@PathVariable Long Mobile_id, @PathVariable Long Customer_id)
            throws NoSuchMobileException, NoSuchCustomerException, NoSuchCpuException, AlreadyExistsCustomerInMobileException, CustomerAbsentException {
        MobileService.addCustomersForMobile(Mobile_id,Customer_id);
        Mobile Mobile = MobileService.getMobile(Mobile_id);
        Link link = linkTo(methodOn(MobileController.class).getMobile(Mobile_id)).withSelfRel();

        MobileDTO mobileDTO = new MobileDTO(Mobile, link);

        return new ResponseEntity<>(mobileDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/Mobile/{Mobile_id}/{Customer_id}")
    public  ResponseEntity<MobileDTO> removeCustomerForMobile(@PathVariable Long Mobile_id, @PathVariable Long Customer_id)
            throws NoSuchMobileException, NoSuchCustomerException, NoSuchCpuException, MobileHasNotCustomerException {
        MobileService.removeCustomerForMobile(Mobile_id,Customer_id);
        Mobile Mobile = MobileService.getMobile(Mobile_id);
        Link link = linkTo(methodOn(MobileController.class).getMobile(Mobile_id)).withSelfRel();

        MobileDTO mobileDTO = new MobileDTO(Mobile, link);

        return new ResponseEntity<>(mobileDTO, HttpStatus.OK);
    }

}

