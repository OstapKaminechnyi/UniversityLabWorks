package com.scrubele.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.scrubele.DTO.EntityInterface;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "mobile", schema = "mobilestore")
public class Mobile implements EntityInterface {
    private Long id;
    private String catery;
    private String mark;
    private String colour;
    private String v_number;
    private String specifics;
    private String image;
    private Cpu cpuByCpu;
    Set<Customer> customers = new HashSet<>();


    public Mobile(String catery, String mark, String colour, String v_number, String specifics, String image,
                        Cpu cpuByCpu) {

        this.catery = catery;
        this.mark = mark;
        this.colour = colour;
        this.v_number = v_number;
        this.specifics = specifics;
        this.image = image;
        this.cpuByCpu = cpuByCpu;
    }

    public Mobile(Long id, String catery, String mark, String colour, String v_number, String specifics,
                        String image) {
        this.id = id;
        this.catery = catery;
        this.mark = mark;
        this.colour = colour;
        this.v_number = v_number;
        this.specifics = specifics;
        this.image = image;
    }

    public Mobile() {
    }


    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "catery", nullable = true, length = 50)
    public String getCatery() {
        return catery;
    }

    public void setCatery(String catery) {
        this.catery = catery;
    }

    @Basic
    @Column(name = "mark", nullable = true, length = 50)
    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Basic
    @Column(name = "colour", nullable = true, length = 50)
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
    @Basic
    @Column(name = "v_number", nullable = true, length = 50)
    public String getV_number() {
        return v_number;
    }

    public void setV_number(String v_number) {
        this.v_number = v_number;
    }
    @Basic
    @Column(name = "specifics", nullable = true, length = 50)
    public String getSpecifics() {
        return specifics;
    }

    public void setSpecifics(String position) {
        this.specifics = specifics;
    }
    @Basic
    @Column(name = "image", nullable = true, length = 5000)
    public String getImage() {
        return image;
    }

    public void setImage(String position) {
        this.image = image;
    }

    @ManyToOne
    @JoinColumn(name = "cpu_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    public Cpu getCpuByCpu() {
        return cpuByCpu;
    }

    public void setCpuByCpu(Cpu cpuByCpu) {
        this.cpuByCpu = cpuByCpu;
    }


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "ownership",
            joinColumns = { @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false) },
            inverseJoinColumns = { @JoinColumn(name = "mobile_id", referencedColumnName = "id", nullable = false), }
    )
    @JsonIgnore
    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public void addOwnership(Customer customerEntity){
        if(!getCustomers().contains(customerEntity)){
            getCustomers().add(customerEntity);
        }
        if(!customerEntity.getMobileSet().contains(this)){
            customerEntity.getMobileSet().add(this);
        }
    }

    public void deleteCustomerEntity(Customer customer){
        if(getCustomers().contains(customer)){
            getCustomers().remove(customer);
        }
        if(customer.getMobileSet().contains(this)){
            customer.getMobileSet().remove(this);
        }
    }



    @Override
    public String toString() {
        return "MobileEntity{" +
                "id=" + id +
                ", category='" + catery + '\'' +
                ", mark='" + mark + '\'' +
                ", colour='" + colour + '\'' +
                ", v_number='" + v_number + '\'' +
                ", specifics='" + specifics + '\'' +
                ", image='" + image + '\'' +
                ", cpuByCpu=" + cpuByCpu.getProd_year() +
                ", customers=" + customers +
                '}';
    }

    public String toStringJoinTable(){
        return "MobileEntity{" +
                "id=" + id +
                " customers=" + customers +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mobile that = (Mobile) o;
        return id == that.id &&
                Objects.equals(catery, that.catery) &&
                Objects.equals(mark, that.mark) &&
                Objects.equals(colour, that.colour) &&
                Objects.equals(v_number, that.v_number) &&
                Objects.equals(specifics, that.specifics) &&
                Objects.equals(image, that.image);}


    @Override
    public int hashCode() {
        return Objects.hash(id, catery, mark, colour,v_number,specifics,image);
    }



}
