package model;

public class DiemThi {
 private String maSV;
 private String maMT;
 private Float diem;
 private String ghiChu;
public DiemThi(String maSV, String maMT, Float diem, String ghiChu) {

	this.maSV = maSV;
	this.maMT = maMT;
	this.diem = diem;
	this.ghiChu = ghiChu;
}


public DiemThi() {

}
public String getMaSV() {
	return maSV;
}
public void setMaSV(String maSV) {
	this.maSV = maSV;
}
public String getMaMT() {
	return maMT;
}
public void setMaMT(String maMT) {
	this.maMT = maMT;
}
public Float getDiem() {
	return diem;
}
public void setDiem(Float diem) {
	this.diem = diem;
}
public String getGhiChu() {
	return ghiChu;
}
public void setGhiChu(String ghiChu) {
	this.ghiChu = ghiChu;
}

 
}
