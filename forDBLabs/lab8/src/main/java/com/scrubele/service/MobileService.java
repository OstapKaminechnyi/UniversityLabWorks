package com.scrubele.service;

import com.scrubele.Repository.CpuRepository;
import com.scrubele.Repository.MobileRepository;
import com.scrubele.Repository.CustomerRepository;
import com.scrubele.domain.Cpu;
import com.scrubele.domain.Mobile;
import com.scrubele.domain.Customer;
import com.scrubele.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class MobileService {
    @Autowired
    MobileRepository MobileRepository;

    @Autowired
    CpuRepository CpuRepository;

    @Autowired
    CustomerRepository CustomerRepository;

    public Set<Mobile> getMobilesByCpuId(Long mobile_id) throws NoSuchCpuException {
        Cpu Cpu = CpuRepository.findById(mobile_id).get();//2.0.0.M7
        if (Cpu == null) throw new NoSuchCpuException();
        return Cpu.getMobile();
    }

    public Mobile getMobile(Long Mobile_id) throws NoSuchMobileException {
        Mobile Mobile = MobileRepository.findById(Mobile_id).get();//2.0.0.M7
        if (Mobile == null) throw new NoSuchMobileException();
        return Mobile;
    }

    public List<Mobile> getAllMobile() {
        return MobileRepository.findAll();
    }

    public Set<Mobile> getMobilesByCustomerId(Long Customer_id) throws NoSuchCustomerException {
        Customer Customer = CustomerRepository.findById(Customer_id).get();//2.0.0.M7
        if (Customer == null) throw new NoSuchCustomerException();
        return Customer.getMobileSet();
    }

    @Transactional
    public void createMobile(Mobile Mobile, Long Cpu_id) throws NoSuchCpuException {
        if (Cpu_id > 0) {
            Cpu Cpu = CpuRepository.findById(Cpu_id).get();//2.0.0.M7
            if (Cpu == null) throw new NoSuchCpuException();
            Mobile.setCpuByCpu(Cpu);
        }
        MobileRepository.save(Mobile);
    }

    @Transactional
    public void updateMobile(Mobile uMobile, Long Mobile_id, Long mobile_id) throws NoSuchCpuException, NoSuchMobileException {
        Cpu Cpu = CpuRepository.findById(mobile_id).get();//2.0.0.M7
        if (mobile_id > 0) {
            if (Cpu == null) throw new NoSuchCpuException();
        }
        Mobile Mobile = MobileRepository.findById(Mobile_id).get();//2.0.0.M7
        if (Mobile == null) throw new NoSuchMobileException();
        //update
        Mobile.setCatery(uMobile.getCatery());
        Mobile.setMark(uMobile.getMark());
        Mobile.setColour(uMobile.getColour());
        Mobile.setV_number(uMobile.getV_number());
        Mobile.setSpecifics(uMobile.getSpecifics());
        Mobile.setImage(uMobile.getImage());
        if (mobile_id > 0) Mobile.setCpuByCpu(Cpu);
        else Mobile.setCpuByCpu(null);
        MobileRepository.save(Mobile);
    }

    @Transactional
    public void deleteMobile(Long Mobile_id) throws NoSuchMobileException, ExistsCustomerForMobileException {
        Mobile Mobile = MobileRepository.findById(Mobile_id).get();//2.0.0.M7
        if (Mobile == null) throw new NoSuchMobileException();
        if (Mobile.getCustomers().size() != 0) throw new ExistsCustomerForMobileException();
        MobileRepository.delete(Mobile);
    }

    @Transactional
    public void addCustomersForMobile(Long Mobile_id, Long Customer_id)
            throws NoSuchMobileException, NoSuchCustomerException, AlreadyExistsCustomerInMobileException, CustomerAbsentException {
        Mobile Mobile = MobileRepository.findById(Mobile_id).get();//2.0.0.M7
        if (Mobile == null) throw new NoSuchMobileException();
        Customer Customer = CustomerRepository.findById(Customer_id).get();//2.0.0.M7
        if (Customer == null) throw new NoSuchCustomerException();
        if (Mobile.getCustomers().contains(Customer) == true) throw new AlreadyExistsCustomerInMobileException();
        Mobile.getCustomers().add(Customer);
        MobileRepository.save(Mobile);
    }

    @Transactional
    public void removeCustomerForMobile(Long Mobile_id, Long Customer_id)
            throws NoSuchMobileException, NoSuchCustomerException, MobileHasNotCustomerException {
//        Artist Artist = patientRepository.findOne(patient_id);//1.5.9
        Mobile Mobile = MobileRepository.findById(Mobile_id).get();//2.0.0.M7
        if (Mobile == null) throw new NoSuchMobileException();
//        Project Project = medicineRepository.findOne(medicine_id);//1.5.9
        Customer Customer= CustomerRepository.findById(Customer_id).get();//2.0.0.M7
        if (Customer == null) throw new NoSuchCustomerException();
        if (Mobile.getCustomers().contains(Customer) == false) throw new MobileHasNotCustomerException();
        Mobile.getCustomers().remove(Customer);
        MobileRepository.save(Mobile);
    }
}
