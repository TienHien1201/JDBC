package model;

public class GiangVien {
private String maGV;
private String tenGV;
private String soDT;
private String maKhoa;
public GiangVien(String maGV, String tenGV, String soDT, String maKhoa) {
	
	this.maGV = maGV;
	this.tenGV = tenGV;
	this.soDT = soDT;
	this.maKhoa = maKhoa;
}

public GiangVien() {

}

public String getMaGV() {
	return maGV;
}
public void setMaGV(String maGV) {
	this.maGV = maGV;
}
public String getTenGV() {
	return tenGV;
}
public void setTenGV(String tenGV) {
	this.tenGV = tenGV;
}
public String getSoDT() {
	return soDT;
}
public void setSoDT(String soDT) {
	this.soDT = soDT;
}
public String getMaKhoa() {
	return maKhoa;
}
public void setMaKhoa(String maKhoa) {
	this.maKhoa = maKhoa;
}

}
