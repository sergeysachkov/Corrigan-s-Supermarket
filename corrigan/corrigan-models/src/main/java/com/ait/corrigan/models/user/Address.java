package com.ait.corrigan.models.user;

public class Address {

    private long adressId;
    private String adressLine1;
    private String adressLine2;
    private String town;
    private String county;
    private String eircode;
    private long customerId;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getAdressId() {
        return adressId;
    }

    public void setAdressId(long adressId) {
        this.adressId = adressId;
    }

    public String getAdressLine1() {
        return adressLine1;
    }

    public void setAdressLine1(String adressLine1) {
        this.adressLine1 = adressLine1;
    }

    public String getAdressLine2() {
        return adressLine2;
    }

    public void setAdressLine2(String adressLine2) {
        this.adressLine2 = adressLine2;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getEircode() {
        return eircode;
    }

    public void setEircode(String eircode) {
        this.eircode = eircode;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (adressId != address.adressId) return false;
        if (customerId != address.customerId) return false;
        if (adressLine1 != null ? !adressLine1.equals(address.adressLine1) : address.adressLine1 != null) return false;
        if (adressLine2 != null ? !adressLine2.equals(address.adressLine2) : address.adressLine2 != null) return false;
        if (town != null ? !town.equals(address.town) : address.town != null) return false;
        if (county != null ? !county.equals(address.county) : address.county != null) return false;
        return eircode != null ? eircode.equals(address.eircode) : address.eircode == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (adressId ^ (adressId >>> 32));
        result = 31 * result + (adressLine1 != null ? adressLine1.hashCode() : 0);
        result = 31 * result + (adressLine2 != null ? adressLine2.hashCode() : 0);
        result = 31 * result + (town != null ? town.hashCode() : 0);
        result = 31 * result + (county != null ? county.hashCode() : 0);
        result = 31 * result + (eircode != null ? eircode.hashCode() : 0);
        result = 31 * result + (int) (customerId ^ (customerId >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "adressId=" + adressId +
                ", adressLine1='" + adressLine1 + '\'' +
                ", adressLine2='" + adressLine2 + '\'' +
                ", town='" + town + '\'' +
                ", county='" + county + '\'' +
                ", eircode='" + eircode + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
