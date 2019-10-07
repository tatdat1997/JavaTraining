package pkg_Info;

import java.util.Date;

public class HumanInfo {
	private Integer info_id;
	private String address;
	private Date day_of_birth;
	public int get_Info_Id() {
		return info_id;
	}
	public void setInfo_Id(Integer info_id) {
		this.info_id = info_id;
	}
	public String get_Address() {
		return address;
	}
	public void set_Address(String address) {
		this.address = address;
	}
	public Date get_Day_of_birth() {
		return day_of_birth;
	}
	public void set_Day_of_birth(Date day_of_birth) {
		this.day_of_birth = day_of_birth;
	}
}
