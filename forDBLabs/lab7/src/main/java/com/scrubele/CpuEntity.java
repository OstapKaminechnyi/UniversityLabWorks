package com.scrubele;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "cpu", schema = "mobilestore")
public class CpuEntity {
    private int id;
    private int volume;
    private Date prod_year;
    private float fee;
    private Collection<MobileEntity> mobileByCpu;
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CpuEntity(int id) {
        this.id = id;
    }

    public CpuEntity() {
    }

    @Basic
    @Column(name = "volume", nullable = true)
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Basic
    @Column(name = "prod_year", nullable = true)
    public Date getProd_year() {
        return prod_year;
    }

    public void setProd_year(Date prod_year) {
        this.prod_year = prod_year;
    }

    @Basic
    @Column(name = "fee", nullable = true)
    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    @OneToMany(mappedBy = "cpuByCpu")
    public Collection<MobileEntity> getMobileByCpu() {
        return mobileByCpu;
    }


    public void setMobileByCpu(Collection<MobileEntity> mobileByCpu) {
        this.mobileByCpu = mobileByCpu;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CpuEntity that = (CpuEntity) o;
        return id == that.id &&
                Objects.equals(volume, that.volume) &&
                Objects.equals(prod_year, that.prod_year) &&
                Objects.equals(fee, that.fee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, volume, prod_year, fee);
    }
    @Override
    public String toString() {
        return "CpuEntity{" +
                "id=" + id +
                ", volume='" + volume + '\'' +
                ", prod_year='" + prod_year + '\'' +
                ", fee=" + fee +
                '}';
    }

}
