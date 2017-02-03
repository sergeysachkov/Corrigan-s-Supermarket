package com.ait.corrigan.models.user;

public class Manager {
	
	private long managerID;
	private String managerName;
	private String managerSurname;
	private String managerLogin;
	private String managerPassword;

	public long getManagerID() {
		return managerID;
	}
	public void setManagerID(long managerID) {
		this.managerID = managerID;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerSurname() {
		return managerSurname;
	}
	public void setManagerSurname(String managerSurname) {
		this.managerSurname = managerSurname;
	}
	public String getManagerLogin() {
		return managerLogin;
	}
	public void setManagerLogin(String managerLogin) {
		this.managerLogin = managerLogin;
	}
	public String getManagerPassword() {
		return managerPassword;
	}
	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}

	@Override
	public String toString() {
		return "Manager [managerID=" + managerID + ", managerName=" + managerName + ", managerSurname=" + managerSurname
				+ ", managerLogin=" + managerLogin + ", managerPassword=" + managerPassword + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (managerID ^ (managerID >>> 32));
		result = prime * result + ((managerLogin == null) ? 0 : managerLogin.hashCode());
		result = prime * result + ((managerName == null) ? 0 : managerName.hashCode());
		result = prime * result + ((managerPassword == null) ? 0 : managerPassword.hashCode());
		result = prime * result + ((managerSurname == null) ? 0 : managerSurname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		if (managerID != other.managerID)
			return false;
		if (managerLogin == null) {
			if (other.managerLogin != null)
				return false;
		} else if (!managerLogin.equals(other.managerLogin))
			return false;
		if (managerName == null) {
			if (other.managerName != null)
				return false;
		} else if (!managerName.equals(other.managerName))
			return false;
		if (managerPassword == null) {
			if (other.managerPassword != null)
				return false;
		} else if (!managerPassword.equals(other.managerPassword))
			return false;
		if (managerSurname == null) {
			if (other.managerSurname != null)
				return false;
		} else if (!managerSurname.equals(other.managerSurname))
			return false;
		return true;
	}
}
