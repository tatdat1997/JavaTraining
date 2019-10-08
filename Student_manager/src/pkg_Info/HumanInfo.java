package pkg_Info;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HumanInfo {
	Integer infoId;
	String address;
	Date dayOfBirth;
	public HumanInfo() {
		super();
	}
	public HumanInfo(Integer infoId, String address, Date dayOfBirth) {
		super();
		this.infoId = infoId;
		this.address = address;
		this.dayOfBirth = dayOfBirth;
	}
	public int getInfoId() {
		return infoId;
	}
	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDayOfBirth() {
		return dayOfBirth;
	}
	public void setDayOfBirth(Date day_of_birth) {
		this.dayOfBirth = day_of_birth;
	}
	public void editInfoId(int infoId_new) {
		this.infoId = infoId_new;
	}
	public void editAddress(String address_new) {
		this.address = address_new;
	}
	public void editBirth(Date birth_new) {
		this.dayOfBirth = birth_new;
	}
	public String printInfo() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String info = this.infoId+","+this.address+","+format.format(this.dayOfBirth);
		return info;
	}
	public void printInfoPretty() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String info = "infoId: "+this.infoId+", Address: "+this.address
				+ ",Day of birth: "+format.format(this.dayOfBirth);
		System.out.println(info);
	}
}
