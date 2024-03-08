package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Khoa {
private String maKhoa;
private String tenKhoa;
private Date namTL;
private String phongLV;
private String tel;
private String maTrgKhoal;
public Khoa(String maKhoa, String tenKhoa, Date namTL, String phongLV, String tel, String maTrgKhoal) {

	this.maKhoa = maKhoa;
	this.tenKhoa = tenKhoa;
	this.namTL = namTL;
	this.phongLV = phongLV;
	this.tel = tel;
	this.maTrgKhoal = maTrgKhoal;
}

public Khoa() {
	
}

public String getMaKhoa() {
	return maKhoa;
}
public void setMaKhoa(String maKhoa) {
	this.maKhoa = maKhoa;
}
public String getTenKhoa() {
	return tenKhoa;
}
public void setTenKhoa(String tenKhoa) {
	this.tenKhoa = tenKhoa;
}
public Date getNamTL() {
	return namTL;
}
public void setNamTL(Date namTL) {
	this.namTL = namTL;
}
public String getPhongLV() {
	return phongLV;
}
public void setPhongLV(String phongLV) {
	this.phongLV = phongLV;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public String getMaTrgKhoal() {
	return maTrgKhoal;
}
public void setMaTrgKhoal(String maTrgKhoal) {
	this.maTrgKhoal = maTrgKhoal;
}




}
