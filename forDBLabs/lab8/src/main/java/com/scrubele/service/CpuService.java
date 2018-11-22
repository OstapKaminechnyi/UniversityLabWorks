package com.scrubele.service;

import com.scrubele.Repository.CpuRepository;
import com.scrubele.Repository.MobileRepository;
import com.scrubele.domain.Cpu;
import com.scrubele.exceptions.ExistsMobilesForCpuException;
import com.scrubele.exceptions.NoSuchCpuException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CpuService {
    @Autowired
    CpuRepository CpuRepository;
    private boolean ascending;

    @Autowired
    MobileRepository MobileRepository;

    public List<Cpu> getAllCpu() {
        return CpuRepository.findAll();
    }

    public Cpu getCpu(Long mobile_id) throws NoSuchCpuException {
//        Organization Organization =diagnosisRepository.findOne(diagnosis_id);//1.5.9
        Cpu cpu = CpuRepository.findById(mobile_id).get();//2.0.0.M7
        System.out.println(cpu);
        if (cpu == null) throw new NoSuchCpuException();
        return cpu;
    }

    @Transactional
    public void createCpu (Cpu cpu) {
        CpuRepository.save(cpu);
    }

    @Transactional
    public void updateCpu(Cpu uCpu, Long mobile_id) throws NoSuchCpuException {
        Cpu cpu = CpuRepository.findById(mobile_id).get();//2.0.0.M7

        if (cpu == null) throw new NoSuchCpuException();
        cpu.setMobile(uCpu.getMobile());
        CpuRepository.save(cpu);
    }

    @Transactional
    public void deleteCpu(Long mobile_id) throws NoSuchCpuException, ExistsMobilesForCpuException {
        Cpu cpu = CpuRepository.findById(mobile_id).get();//2.0.0.M7
        if (cpu == null) throw new NoSuchCpuException();
        if (cpu.getMobile().size() != 0) throw new ExistsMobilesForCpuException();
        CpuRepository.delete(cpu);
    }


}
