package com.ait.corrigan.models.user;

import java.util.Date;
import java.util.Set;

public class Customer {
  private long customerId;
  private String customerName;
  private String customerSurname;
  private String customerLogin;
  private String password;
  private String phoneNumber;
  private String email;
  private Date customerDateOfBirth;
  private long addressId;
  private Set<PaymentDetails> paymentDetailsSet;

  public Customer(long customerId,String customerName,String customerSurname,String password, String phoneNumber,String email,Date customerDateOfBirth,long addressId){
	    this.customerId = customerId;
	    this.customerName = customerName;
	    this.customerSurname = customerSurname;
	    this.password=password;
	    this.phoneNumber= phoneNumber;
	    this.email = email;
	    this.customerDateOfBirth=customerDateOfBirth;
	    this.addressId= addressId;
	  
	 
	  
     }
  
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getCustomerLogin() {
        return customerLogin;
    }

    public void setCustomerLogin(String customerLogin) {
        this.customerLogin = customerLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCustomerDateOfBirth() {
        return customerDateOfBirth;
    }

    public void setCustomerDateOfBirth(Date customerDateOfBirth) {
        this.customerDateOfBirth = customerDateOfBirth;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAdressId(long addressId) {
        this.addressId = addressId;
    }

    public Set<PaymentDetails> getPaymentDetailsSet() {
        return paymentDetailsSet;
    }

    public void setPaymentDetailsSet(Set<PaymentDetails> paymentDetailsSet) {
        this.paymentDetailsSet = paymentDetailsSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (customerId != customer.customerId) return false;
        if (addressId != customer.addressId) return false;
        if (customerName != null ? !customerName.equals(customer.customerName) : customer.customerName != null)
            return false;
        if (customerSurname != null ? !customerSurname.equals(customer.customerSurname) : customer.customerSurname != null)
            return false;
        if (customerLogin != null ? !customerLogin.equals(customer.customerLogin) : customer.customerLogin != null)
            return false;
        if (password != null ? !password.equals(customer.password) : customer.password != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(customer.phoneNumber) : customer.phoneNumber != null)
            return false;
        if (email != null ? !email.equals(customer.email) : customer.email != null) return false;
        if (customerDateOfBirth != null ? !customerDateOfBirth.equals(customer.customerDateOfBirth) : customer.customerDateOfBirth != null)
            return false;
        return paymentDetailsSet != null ? paymentDetailsSet.equals(customer.paymentDetailsSet) : customer.paymentDetailsSet == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (customerId ^ (customerId >>> 32));
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + (customerSurname != null ? customerSurname.hashCode() : 0);
        result = 31 * result + (customerLogin != null ? customerLogin.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (customerDateOfBirth != null ? customerDateOfBirth.hashCode() : 0);
        result = 31 * result + (int) (addressId ^ (addressId >>> 32));
        result = 31 * result + (paymentDetailsSet != null ? paymentDetailsSet.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerSurname='" + customerSurname + '\'' +
                ", customerLogin='" + customerLogin + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", customerDateOfBirth=" + customerDateOfBirth +
                ", adressId=" + addressId +
                    '}'
  private long adressId;
  private Set<PaymentDetails> paymentDetailsSet;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getCustomerLogin() {
        return customerLogin;
    }

    public void setCustomerLogin(String customerLogin) {
        this.customerLogin = customerLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCustomerDateOfBirth() {
        return customerDateOfBirth;
    }

    public void setCustomerDateOfBirth(Date customerDateOfBirth) {
        this.customerDateOfBirth = customerDateOfBirth;
    }

    public long getAdressId() {
        return adressId;
    }

    public void setAdressId(long adressId) {
        this.adressId = adressId;
    }

    public Set<PaymentDetails> getPaymentDetailsSet() {
        return paymentDetailsSet;
    }

    public void setPaymentDetailsSet(Set<PaymentDetails> paymentDetailsSet) {
        this.paymentDetailsSet = paymentDetailsSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (customerId != customer.customerId) return false;
        if (adressId != customer.adressId) return false;
        if (customerName != null ? !customerName.equals(customer.customerName) : customer.customerName != null)
            return false;
        if (customerSurname != null ? !customerSurname.equals(customer.customerSurname) : customer.customerSurname != null)
            return false;
        if (customerLogin != null ? !customerLogin.equals(customer.customerLogin) : customer.customerLogin != null)
            return false;
        if (password != null ? !password.equals(customer.password) : customer.password != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(customer.phoneNumber) : customer.phoneNumber != null)
            return false;
        if (email != null ? !email.equals(customer.email) : customer.email != null) return false;
        if (customerDateOfBirth != null ? !customerDateOfBirth.equals(customer.customerDateOfBirth) : customer.customerDateOfBirth != null)
            return false;
        return paymentDetailsSet != null ? paymentDetailsSet.equals(customer.paymentDetailsSet) : customer.paymentDetailsSet == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (customerId ^ (customerId >>> 32));
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + (customerSurname != null ? customerSurname.hashCode() : 0);
        result = 31 * result + (customerLogin != null ? customerLogin.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (customerDateOfBirth != null ? customerDateOfBirth.hashCode() : 0);
        result = 31 * result + (int) (adressId ^ (adressId >>> 32));
        result = 31 * result + (paymentDetailsSet != null ? paymentDetailsSet.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerSurname='" + customerSurname + '\'' +
                ", customerLogin='" + customerLogin + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", customerDateOfBirth=" + customerDateOfBirth +
                ", adressId=" + adressId +
                ", paymentDetailsSet=" + paymentDetailsSet +
                '}';
    }
}
