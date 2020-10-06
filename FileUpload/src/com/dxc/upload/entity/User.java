package com.dxc.upload.entity;

public class User {
String name;
String loginid;
String pwd;
String email;
String address;
String phno;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLoginid() {
	return loginid;
}
public void setLoginid(String loginid) {
	this.loginid = loginid;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
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
public String getPhno() {
	return phno;
}
public void setPhno(String phno) {
	this.phno = phno;
}
public User(String name, String loginid, String pwd, String email, String address, String phno) {
	super();
	this.name = name;
	this.loginid = loginid;
	this.pwd = pwd;
	this.email = email;
	this.address = address;
	this.phno = phno;
}
@Override
public String toString() {
	return "User [name=" + name + ", loginid=" + loginid + ", pwd=" + pwd + ", email=" + email + ", address=" + address
			+ ", phno=" + phno + "]";
}

}
