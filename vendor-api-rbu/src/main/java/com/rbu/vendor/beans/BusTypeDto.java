package com.rbu.vendor.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class BusTypeDto {

    private Long bustypeid;

    @NotNull
    @Size(max = 255)
    private String bustype;

    @NotNull
    @Size(max = 255)
    private String description;

    @Size(max = 255)
    private String isactive;

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

}
