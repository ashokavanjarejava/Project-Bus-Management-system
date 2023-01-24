package com.rbu.vendor.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class BusVendorDto {

    private Long vendorid;

    @NotNull
    @Size(max = 255)
    private String vendorname;

    @NotNull
    @Size(max = 255)
    private String description;

    @NotNull
    @Size(max = 255)
    private String state;

    @NotNull
    @Size(max = 255)
    private String citi;

    @NotNull
    @Size(max = 255)
    private String pan;

    @NotNull
    @Size(max = 255)
    private String gst;

    @NotNull
    @Size(max = 255)
    private String businessname;

    public Long getVendorid() {
        return vendorid;
    }

    public void setVendorid(final Long vendorid) {
        this.vendorid = vendorid;
    }

    public String getVendorname() {
        return vendorname;
    }

    public void setVendorname(final String vendorname) {
        this.vendorname = vendorname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(final String state) {
        this.state = state;
    }

    public String getCiti() {
        return citi;
    }

    public void setCiti(final String citi) {
        this.citi = citi;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(final String pan) {
        this.pan = pan;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(final String gst) {
        this.gst = gst;
    }

    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(final String businessname) {
        this.businessname = businessname;
    }

}
