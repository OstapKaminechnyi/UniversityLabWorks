package com.scrubele;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "customer", schema = "mobilestore")
public class CustomerEntity {
    private int id;
    private String SNM;
    private Date birth_day;
    private String adress;
    private String number;
    private Set<MobileEntity> mobileEntitySet = new HashSet<>();

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "SNM", nullable = false, length = 50)
    public String getSNM() {
        return SNM;
    }

    public void setSNM(String SNM) {
        this.SNM = SNM;
    }

    @Basic
    @Column(name = "birth_day", nullable = true)
    public Date getBirth_day() {
        return birth_day;
    }

    public void setBirth_day(Date dateStart) {
        this.birth_day = birth_day;
    }

    @Basic
    @Column(name = "adress", nullable = true, length = 50)
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Basic
    @Column(name = "number", nullable = true, length = 50)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @ManyToMany(targetEntity = MobileEntity.class, mappedBy="customers")
    public Set<MobileEntity> getMobileEntitySet() {
        return mobileEntitySet;
    }

    public void setMobileEntitySet(Set<MobileEntity> mobileEntitySet) {
        this.mobileEntitySet = mobileEntitySet;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return id == that.id &&
                Objects.equals(SNM, that.SNM) &&
                Objects.equals(birth_day, that.birth_day) &&
                Objects.equals(adress, that.adress) &&
                Objects.equals(number,that.number)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, SNM, birth_day, adress,number);
    }
    @Override
    public String toString(){
        return "Id= " + id + ", SNM= " + SNM + ", birth_day= " + birth_day
                + ", adress= " + adress + ", number= " + number ;
    }
}
