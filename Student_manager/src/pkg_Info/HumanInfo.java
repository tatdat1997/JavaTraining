package pkg_Info;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Copyright (C) 2015 by GMO Runsystem Company
 *
 * Create HumanInfo class
 *
 * @version 1.0
 *
 * @author DatNT
 *
 */

public class HumanInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer infoId;
	String address;
	Date dateOfBirth;
	//Create new HumanInfo
	public HumanInfo() {
		super();
	}
	public HumanInfo(Integer infoId, String address, String dateOfBirth) {
		super();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		this.infoId = infoId;
		this.address = address;
		//Format date of birth
		try {
			java.util.Date birthDay = format.parse(dateOfBirth); 
			this.dateOfBirth = birthDay;
		}catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	public HumanInfo(Integer infoId, String address, Date dateOfBirth) {
		super();
		this.infoId = infoId;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
	}
	public int getInfoId() {						//Get info id
		return infoId;
	}
	public void setInfoId(Integer infoId) {			//Set info id
		this.infoId = infoId;
	}
	public String getAddress() {					
		return address;
	}
	public void setAddress(String address) {		
		this.address = address;
	}
	public Date getDayOfBirth() {				
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		try {
			java.util.Date birthDay = format.parse(dateOfBirth);
			this.dateOfBirth = birthDay;
		}catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	public void editInfoId(int infoIdNew) {		//Edit info id
		this.infoId = infoIdNew;
	}
	public void editAddress(String addressNew) {	
		this.address = addressNew;
	}
	public void editBirth(String birthNew) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		try {
			java.util.Date birthDay = format.parse(birthNew);
			this.dateOfBirth = birthDay;
		}catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	//Print Info of student to save in file 
	public String printInfo() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String info = this.infoId + "," + this.address + "," + format.format(this.dateOfBirth);
		return info;
	}
	//print Info of student to show.
	public void printInfoPretty() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String info = "infoId: " + this.infoId + ", Address: " + this.address
						+ ",Day of birth: " + format.format(this.dateOfBirth);
		System.out.println(info);
	}
}
