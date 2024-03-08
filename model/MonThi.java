package model;

public class MonThi {
private String maMT;
private String tenMT;
public MonThi(String maMT, String tenMT) {
	
	this.maMT = maMT;
	this.tenMT = tenMT;
}

public MonThi() {
	
}

public String getMaMT() {
	return maMT;
}
public void setMaMT(String maMT) {
	this.maMT = maMT;
}
public String getTenMT() {
	return tenMT;
}
public void setTenMT(String tenMT) {
	this.tenMT = tenMT;
}

}
