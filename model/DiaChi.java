package model;

public class DiaChi {
private String maSV;
private String soNha;
private String duong;
private String quan;
private String thanhPho;
public DiaChi(String maSV, String soNha, String duong, String quan, String thanhPho) {
	this.maSV = maSV;
	this.soNha = soNha;
	this.duong = duong;
	this.quan = quan;
	this.thanhPho = thanhPho;
}

public DiaChi() {
	
}

public String getMaSV() {
	return maSV;
}
public void setMaSV(String maSV) {
	this.maSV = maSV;
}
public String getSoNha() {
	return soNha;
}
public void setSoNha(String soNha) {
	this.soNha = soNha;
}
public String getDuong() {
	return duong;
}
public void setDuong(String duong) {
	this.duong = duong;
}
public String getQuan() {
	return quan;
}
public void setQuan(String quan) {
	this.quan = quan;
}
public String getThanhPho() {
	return thanhPho;
}
public void setThanhPho(String thanhPho) {
	this.thanhPho = thanhPho;
}

}
