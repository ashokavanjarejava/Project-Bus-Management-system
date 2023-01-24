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
@Table(name = "RBU_BUSVENDOR")
public class BusVendor {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vendorid;

    @Column(nullable = false)
    private String vendorname;

    @Column(nullable = false, name = "\"description\"")
    private String description;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String citi;

    @Column(nullable = false)
    private String pan;

    @Column(nullable = false)
    private String gst;

    @Column(nullable = false)
    private String businessname;

    @OneToMany(mappedBy = "vendoridfk")
    private Set<Buses> vendoridfkBUSESs;

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

    public Set<Buses> getVendoridfkBUSESs() {
        return vendoridfkBUSESs;
    }

    public void setVendoridfkBUSESs(final Set<Buses> vendoridfkBUSESs) {
        this.vendoridfkBUSESs = vendoridfkBUSESs;
    }

}
