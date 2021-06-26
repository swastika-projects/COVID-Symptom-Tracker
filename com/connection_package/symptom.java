package com.connection_package;

public class symptom {
	private int sid;
	private String sname;
	private String effect;
	private String medication;
	
	public symptom(int sid) {
		super();
		this.sid = sid;
	}

	public symptom(int sid, String sname, String effect) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.effect = effect;
	}

	
	public symptom(String sname, String effect, String medication) {
		super();
		this.sname = sname;
		this.effect = effect;
		this.medication = medication;
	}

	public symptom(int sid, String sname, String effect, String medication) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.effect = effect;
		this.medication = medication;
	}

	public symptom() {
		super();
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getMedication() {
		return medication;
	}

	public void setMedication(String medication) {
		this.medication = medication;
	}

	@Override
	public String toString() {
		return "symptom [sid=" + sid + ", sname=" + sname + ", effect=" + effect + ", medication=" + medication + "]";
	}
	
	
	
}
