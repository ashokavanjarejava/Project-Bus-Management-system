package com.rbu.vendor.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "RBU_BUSES")
public class Buses {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long busid;

    @Column(nullable = false)
    private String busname;

    @Column(nullable = false)
    private Integer seatcapacity;

    @Column
    private Integer sleeperud;

    @Column
    private Integer sleeperld;

    @Column
    private String busdescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bustypeid_id")
    private BusType bustypeid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendoridfk_id")
    private BusVendor vendoridfk;

    public Long getBusid() {
        return busid;
    }

    public void setBusid(final Long busid) {
        this.busid = busid;
    }

    public String getBusname() {
        return busname;
    }

    public void setBusname(final String busname) {
        this.busname = busname;
    }

    public Integer getSeatcapacity() {
        return seatcapacity;
    }

    public void setSeatcapacity(final Integer seatcapacity) {
        this.seatcapacity = seatcapacity;
    }

    public Integer getSleeperud() {
        return sleeperud;
    }

    public void setSleeperud(final Integer sleeperud) {
        this.sleeperud = sleeperud;
    }

    public Integer getSleeperld() {
        return sleeperld;
    }

    public void setSleeperld(final Integer sleeperld) {
        this.sleeperld = sleeperld;
    }

    public String getBusdescription() {
        return busdescription;
    }

    public void setBusdescription(final String busdescription) {
        this.busdescription = busdescription;
    }

    public BusType getBustypeid() {
        return bustypeid;
    }

    public void setBustypeid(final BusType bustypeid) {
        this.bustypeid = bustypeid;
    }

    public BusVendor getVendoridfk() {
        return vendoridfk;
    }

    public void setVendoridfk(final BusVendor vendoridfk) {
        this.vendoridfk = vendoridfk;
    }

}
