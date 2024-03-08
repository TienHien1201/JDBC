package model;

public class DienThoai {
private String maSV;
private String soDT;
public DienThoai(String maSV, String soDT) {

	this.maSV = maSV;
	this.soDT = soDT;
}

public DienThoai() {

}

public String getMaSV() {
	return maSV;
}
public void setMaSV(String maSV) {
	this.maSV = maSV;
}
public String getSoDT() {
	return soDT;
}
public void setSoDT(String soDT) {
	this.soDT = soDT;
}


}
