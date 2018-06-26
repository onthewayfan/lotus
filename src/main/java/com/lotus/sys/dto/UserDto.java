package com.lotus.sys.dto;

import java.io.Serializable;
import java.sql.Date;

public class UserDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String loginName;
	private String loginPass;
	private String name;
	private Integer age;
	private Integer moblie;
	private Integer phone;
	private String email;
	private String address;
	private String image;
	private String loginIp;
	private Date loginDt;
	private byte loginFlag;
	private byte isValid;
	private Integer crtId;
	private Date cetDt;
	private Integer optId;
	private Date optDt;
	private String remark;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPass() {
		return loginPass;
	}
	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}
	public String getName() {
		return name;
	}
	public UserDto setName(String name) {
		this.name = name;
		return this;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getMoblie() {
		return moblie;
	}
	public void setMoblie(Integer moblie) {
		this.moblie = moblie;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public byte getLoginFlag() {
		return loginFlag;
	}
	public void setLoginFlag(byte loginFlag) {
		this.loginFlag = loginFlag;
	}
	public byte getIsValid() {
		return isValid;
	}
	public void setIsValid(byte isValid) {
		this.isValid = isValid;
	}
	public Integer getCrtId() {
		return crtId;
	}
	public void setCrtId(Integer crtId) {
		this.crtId = crtId;
	}

	public Integer getOptId() {
		return optId;
	}
	public void setOptId(Integer optId) {
		this.optId = optId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getLoginDt() {
		return loginDt;
	}
	public void setLoginDt(Date loginDt) {
		this.loginDt = loginDt;
	}
	public Date getCetDt() {
		return cetDt;
	}
	public void setCetDt(Date cetDt) {
		this.cetDt = cetDt;
	}
	public Date getOptDt() {
		return optDt;
	}
	public void setOptDt(Date optDt) {
		this.optDt = optDt;
	}
	
	
	
	

}
