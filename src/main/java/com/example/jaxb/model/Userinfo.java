package com.example.jaxb.model;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "USERINFO")
public class Userinfo implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", length = 50)
    @Length(max = 50)
    private String name;

    @Column(name = "ADDRESS", length = 50)
    @Length(max = 50)
    private String address;

    @Column(name = "JOB", length = 50)
    @Length(max = 50)
    private String job;

    @XmlElementWrapper(name = "overinfos")
    @OneToMany(cascade = CascadeType.ALL)
    @XmlElements(value = {@XmlElement(name = "overinfo", type = Overinfo.class)})
    private List<Overinfo> overinfos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public List<Overinfo> getOverinfos() {
        return overinfos;
    }

    public void setOverinfos(List<Overinfo> overinfos) {
        this.overinfos = overinfos;
    }
}
