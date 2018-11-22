package com.scrubele.controller;

import com.scrubele.DTO.impl.CpuDTO;
import com.scrubele.domain.Cpu;

import com.scrubele.exceptions.*;
import com.scrubele.service.CpuService;
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
public class CpuController {
    @Autowired
    CpuService cpuService;

    @GetMapping(value = "/api/Cpu")
    public ResponseEntity<Set<CpuDTO>> getAllCpu() throws NoSuchMobileException, NoSuchCustomerException, NoSuchCpuException {
        List<Cpu> CpuSet = cpuService.getAllCpu();
        Link link = linkTo(methodOn(CpuController.class).getAllCpu()).withSelfRel();

        Set<CpuDTO> cpuDTO = new HashSet<>();
        for (Cpu entity : CpuSet) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            CpuDTO dto = new CpuDTO(entity, selfLink);
            cpuDTO.add(dto);
        }

        return new ResponseEntity<>(cpuDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/Cpu/{Cpu_id}")
    public ResponseEntity<CpuDTO> getCpu(@PathVariable Long Cpu_id) throws NoSuchCpuException, NoSuchMobileException, NoSuchCustomerException {
        Cpu Cpu = cpuService.getCpu(Cpu_id);
        Link link = linkTo(methodOn(CpuController.class).getCpu(Cpu_id)).withSelfRel();
        System.out.println(Cpu);
        CpuDTO cpuDTO = new CpuDTO(Cpu, link);

        return new ResponseEntity<>(cpuDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/Cpu/{Cpu_id}")
    public  ResponseEntity<CpuDTO> addCpu(@RequestBody Cpu newCpu) throws NoSuchCpuException, NoSuchMobileException, NoSuchCustomerException {
        cpuService.createCpu(newCpu);
        Link link = linkTo(methodOn(CpuController.class).getCpu(newCpu.getId())).withSelfRel();

        CpuDTO cpuDTO = new CpuDTO(newCpu, link);

        return new ResponseEntity<>(cpuDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/Cpu/{Cpu_id}")
    public  ResponseEntity<CpuDTO> updateCpu(@RequestBody Cpu uCpu, @PathVariable Long Cpu_id) throws NoSuchCpuException, NoSuchMobileException, NoSuchCustomerException {
        cpuService.updateCpu(uCpu, Cpu_id);
        Cpu Cpu = cpuService.getCpu(Cpu_id);
        Link link = linkTo(methodOn(CpuController.class).getCpu(Cpu_id)).withSelfRel();

        CpuDTO cpuDTO = new CpuDTO(Cpu, link);

        return new ResponseEntity<>(cpuDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/Cpu/{Cpu_id}")
    public  ResponseEntity deleteCpu(@PathVariable Long Cpu_id) throws NoSuchCpuException, ExistsMobilesForCustomerException, ExistsMobilesForCpuException {
        cpuService.deleteCpu(Cpu_id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
