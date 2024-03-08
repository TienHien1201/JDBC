package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class SinhVien {
	private String maSV;
	private String hoTen;
	private Date ngSinh;
	private String gioiTinh;
	private String maLop;
	
	public SinhVien(String maSV, String hoTen, Date ngSinh, String gioiTinh, String maLop) {
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.ngSinh = ngSinh;
		this.gioiTinh = gioiTinh;
		this.maLop = maLop;
	}
	public SinhVien() {
	
	}

	@Override
	public String toString() {
		return "SinhVien [maSV=" + maSV + ", hoTen=" + hoTen + ", ngSinh=" + ngSinh + ", gioiTinh=" + gioiTinh
				+ ", maLop=" + maLop + "]";
	}
	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Date getNgSinh() {
		return ngSinh;
	}

	public void setNgSinh(Date ngSinh) {
		this.ngSinh = ngSinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	
	
}