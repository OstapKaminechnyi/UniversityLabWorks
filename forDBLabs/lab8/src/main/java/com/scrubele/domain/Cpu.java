package com.scrubele.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.scrubele.DTO.EntityInterface;

import javax.persistence.*;
import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.Set;
import java.util.Objects;

@Entity
@Table(name = "cpu", schema = "mobilestore")
public class Cpu implements EntityInterface {
    private Long id;
    private int volume;
    private Date prod_year;
    private float fee;

    public Cpu(Long id, int volume, Date prod_year, float fee) {
        this.id = id;
        this.volume = volume;
        this.prod_year = prod_year;
        this.fee = fee;
    }

    private Set<Mobile> mobileByCpu;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cpu(Long id) {
        this.id = id;
    }

    public Cpu() {
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

    @OneToMany(
            mappedBy = "cpuByCpu",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    public Set<Mobile> getMobile() {
        return mobileByCpu;
    }
    public void setMobile(Set<Mobile> mobileByCpu)
    {
        this.mobileByCpu = mobileByCpu;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cpu that = (Cpu) o;
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
        return "Cpu{" +
                "id=" + id +
                ", volume='" + volume + '\'' +
                ", prod_year='" + prod_year + '\'' +
                ", fee=" + fee +
                // ", artistsByOrganization=" + artistsByOrganization +
                '}';
    }

}
