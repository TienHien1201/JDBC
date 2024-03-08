package model;

public class ChuyenNganh {
 private String maCN;
 private String tenCN;
 private String maGVCN;
 private String maKhoa;
public ChuyenNganh(String maCN, String tenCN, String maGVCN, String maKhoa) {
	
	this.maCN = maCN;
	this.tenCN = tenCN;
	this.maGVCN = maGVCN;
	this.maKhoa = maKhoa;
}

public ChuyenNganh() {
	
}

public String getMaCN() {
	return maCN;
}
public void setMaCN(String maCN) {
	this.maCN = maCN;
}
public String getTenCN() {
	return tenCN;
}
public void setTenCN(String tenCN) {
	this.tenCN = tenCN;
}
public String getMaGVCN() {
	return maGVCN;
}
public void setMaGVCN(String maGVCN) {
	this.maGVCN = maGVCN;
}
public String getMaKhoa() {
	return maKhoa;
}
public void setMaKhoa(String maKhoa) {
	this.maKhoa = maKhoa;
}

 
}
