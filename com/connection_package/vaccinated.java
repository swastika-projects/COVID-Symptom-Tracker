package com.connection_package;

public class vaccinated {
	private int vid;
	private String date;
	private String vname;
	private String blood_group;
	private String phone;
    private String vaccine_name;
    
    
	public vaccinated(String date, String vname, String blood_group, String phone, String vaccine_name) {
		super();
		this.date = date;
		this.vname = vname;
		this.blood_group = blood_group;
		this.phone = phone;
		this.vaccine_name = vaccine_name;
	}


	public vaccinated(int vid) {
		super();
		this.vid = vid;
	}


	public vaccinated(int vid, String date, String vname, String blood_group, String phone, String vaccine_name) {
		super();
		this.vid = vid;
		this.date = date;
		this.vname = vname;
		this.blood_group = blood_group;
		this.phone = phone;
		this.vaccine_name = vaccine_name;
	}

	
	

	public vaccinated(int vid, String vname, String phone) {
		super();
		this.vid = vid;
		this.vname = vname;
		this.phone = phone;
	}


	public int getVid() {
		return vid;
	}


	public void setVid(int vid) {
		this.vid = vid;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getVname() {
		return vname;
	}


	public void setVname(String vname) {
		this.vname = vname;
	}


	public String getBlood_group() {
		return blood_group;
	}


	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getVaccine_name() {
		return vaccine_name;
	}


	public void setVaccine_name(String vaccine_name) {
		this.vaccine_name = vaccine_name;
	}


	@Override
	public String toString() {
		return "vaccinated [vid=" + vid + ", date=" + date + ", vname=" + vname + ", blood_group=" + blood_group
				+ ", phone=" + phone + ", vaccine_name=" + vaccine_name + "]";
	}
    
    
	
	
}
