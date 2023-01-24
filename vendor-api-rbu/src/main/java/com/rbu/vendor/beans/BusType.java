package com.rbu.vendor.beans;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "RBU_BUSTYPE")
public class BusType {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bustypeid;

    @Column(nullable = false)
    private String bustype;

    @Column(nullable = false, name = "\"description\"")
    private String description;

    @Column
    private String isactive;

    @OneToMany(mappedBy = "bustypeid")
    private Set<Buses> bustypeidBUSESs;

    public Long getBustypeid() {
        return bustypeid;
    }

    public void setBustypeid(final Long bustypeid) {
        this.bustypeid = bustypeid;
    }

    public String getBustype() {
        return bustype;
    }

    public void setBustype(final String bustype) {
        this.bustype = bustype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getIsactive() {
        return isactive;
    }

    public void setIsactive(final String isactive) {
        this.isactive = isactive;
    }

    public Set<Buses> getBustypeidBUSESs() {
        return bustypeidBUSESs;
    }

    public void setBustypeidBUSESs(final Set<Buses> bustypeidBUSESs) {
        this.bustypeidBUSESs = bustypeidBUSESs;
    }

}
