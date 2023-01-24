package com.rbu.vendor.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class BusesDto {

    private Long busid;

    @NotNull
    @Size(max = 255)
    private String busname;

    @NotNull
    private Integer seatcapacity;

    private Integer sleeperud;

    private Integer sleeperld;

    @Size(max = 255)
    private String busdescription;

    private Long bustypeid;

    private Long vendoridfk;

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

    public Long getBustypeid() {
        return bustypeid;
    }

    public void setBustypeid(final Long bustypeid) {
        this.bustypeid = bustypeid;
    }

    public Long getVendoridfk() {
        return vendoridfk;
    }

    public void setVendoridfk(final Long vendoridfk) {
        this.vendoridfk = vendoridfk;
    }

}
