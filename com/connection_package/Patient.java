package com.connection_package;

public class Patient {
	private int pid;
	private String pname;
	private String blood_group;
	private String phone;
	private String date;

	public Patient(int a, String b, String c, String d, String e){
	super();
	pid=a;
	pname=b;
	blood_group=c;
	phone=d;
	date=e;
	} 

	public Patient(String b, String c, String d, String e){
	super();
	pname=b;
	blood_group=c;
	phone=d;
	date=e;
	} 
    
	public Patient(int a) {
	super();
	pid=a;
	}
	
	public Patient(){
	super();
	} 

	public int getpid(){return pid;}
	public String getpname(){return pname;}
	public String getblood_group(){return blood_group;}
	public String getphone(){return phone;}
	public String getdate(){return date;}

	public void setpid(int a){pid=a;}
	public void setpname(String b){pname=b;}
	public void setblood_group(String c){blood_group=c;}
	public void setphone(String d){phone=d;}
	public void setdate(String e){date=e;}
	
	@Override
	public String toString() {
		return "Patient [Patient ID =" + pid + ", pname=" + pname + ", blood_group=" + blood_group + ", phone=" + phone
				+ ", date=" + date + "]";
	}
}
