package com.ait.corrigan.models.user;

import java.sql.Date;

public class Customer {
	
		
		private int Cust_id;
		private String CustName;
		private String Password;
		private String Address;
		private Date Date_of_birth;
		private String EmailAddress;
		private String PhoneNo;
		
	   
        public Customer(int Cust_id,String CustName,String Password, String Address,Date Date_of_birth, String EmailAddress,String PhoneNO){
	    this.Cust_id = Cust_id;
	    this.Password=Password;
	    this.Address=Address;
	    this.Date_of_birth=Date_of_birth;
	    this.EmailAddress=EmailAddress;
	    this.PhoneNo=PhoneNo;
	  
	  
	  
       }

		public Customer() {
			// TODO Auto-generated constructor stub
		}


 

		public int getCust_id() {
			return Cust_id;
		}




		public void setCust_id(int cust_Id) {
			Cust_id = cust_Id;
		}




		public String getCustName() {
			return CustName;
		}




		public void setCustName(String custName) {
			CustName = custName;
		}




		public String getPassword() {
			return Password;
		}




		public void setPassword(String password) {
			Password = password;
		}




		public String getAddress() {
			return Address;
		}




		public void setAddress(String address) {
			Address = address;
		}




		public Date getDate_of_birth() {
			return Date_of_birth;
		}




		public void setDate_of_birth(Date date_of_birth) {
			Date_of_birth = date_of_birth;
		}




		public String getEmailAddress() {
			return EmailAddress;
		}




		public void setEmailAddress(String emailAddress) {
			EmailAddress = emailAddress;
		}




		public String getPhoneNo() {
			return PhoneNo;
		}



		public void setPhoneNo(String phoneNo) {
			PhoneNo = phoneNo;
		}

		

}
