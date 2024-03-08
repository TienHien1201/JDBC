package model;

public class Lop {
private String maL;
private byte siSo;
private String maCN;
public Lop(String maL, byte siSo, String maCN) {

	this.maL = maL;
	this.siSo = siSo;
	this.maCN = maCN;
}
public Lop() {
}
public String getMaL() {
	return maL;
}
public void setMaL(String maL) {
	this.maL = maL;
}
public byte getSiSo() {
	return siSo;
}
public void setSiSo(byte siSo) {
	this.siSo = siSo;
}
public String getMaCN() {
	return maCN;
}
public void setMaCN(String maCN) {
	this.maCN = maCN;
}


}
