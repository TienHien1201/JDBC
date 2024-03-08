	package Controller;
	
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import model.ChuyenNganh;
import model.DiaChi;
import model.DiemThi;
import model.DienThoai;
import model.GiangVien;
import model.Khoa;
import model.Lop;
import model.MonThi;
import model.SinhVien;
import model.Thi;
	
	public class Sukien {
	public Connection c;
	  
		public Sukien() {
			 try {
				DriverManager.registerDriver( new com.mysql.cj.jdbc.Driver());
				
				String url = "jdbc:mySQL://localhost:3306/quanlythongtinsinhvien?useSSL=false";
				String user ="root";
				String passWord = "30102004";
				c = DriverManager.getConnection(url, user, passWord);
				if (c != null) {
					System.out.println("kết nối thành công");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 }
		public ArrayList<SinhVien> getListSV(){
			ArrayList<SinhVien> list = new ArrayList<SinhVien>();
			String sql = "SELECT * FROM quanlythongtinsinhvien.sinhvien";
			try {
				PreparedStatement ps = c.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					SinhVien sv = new SinhVien();
					sv.setMaSV(rs.getString("MASV"));
					sv.setHoTen(rs.getString("HOTEN"));
					sv.setNgSinh(rs.getDate("NGSINH"));
					sv.setGioiTinh(rs.getString("PHAI"));
					sv.setMaLop(rs.getString("MAL"));
					list.add(sv);
			      
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
					
		}
		
	
		
		public ArrayList<String> getListMASV(){
			ArrayList<String> list = new ArrayList<String>();
			String sql = "SELECT MASV FROM quanlythongtinsinhvien.sinhvien";
			try {
				PreparedStatement ps = c.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					
					String maSV = rs.getString("MASV");					
					list.add(maSV);
			      
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
					
		}
		public ArrayList<String> getListMAL(){
			ArrayList<String> list = new ArrayList<String>();
			String sql = "SELECT MAL FROM quanlythongtinsinhvien.lop";
			try {
				PreparedStatement ps = c.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					
					String maSV = rs.getString("MAL");					
					list.add(maSV);
			      
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
					
		}
		public ArrayList<String> getListMAKHOA(){
			ArrayList<String> list = new ArrayList<String>();
			String sql = "SELECT MAKHOA FROM quanlythongtinsinhvien.khoa";
			try {
				PreparedStatement ps = c.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					
					String maSV = rs.getString("MAKHOA");					
					list.add(maSV);
			      
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
					
		}
		
		public ArrayList<String> getListMACN(){
			ArrayList<String> list = new ArrayList<String>();
			String sql = "SELECT MACN FROM quanlythongtinsinhvien.chuyennganh";
			try {
				PreparedStatement ps = c.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					
					String maSV = rs.getString("MACN");					
					list.add(maSV);
			      
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
					
		}
		public void Insert(SinhVien t) {		
			
			try {
				String sql = "INSERT INTO SINHVIEN (MASV, HOTEN, NGSINH, PHAI, MAL )" 
						+ " VALUES (?,?,?,?,?)";
				PreparedStatement sinhvien =  c.prepareStatement(sql);
				sinhvien.setString(1,t.getMaSV());
				sinhvien.setString(2,t.getHoTen());				
				sinhvien.setDate(3,t.getNgSinh());
				sinhvien.setString(4,t.getGioiTinh());
				sinhvien.setString(5,t.getMaLop());	
				
				sinhvien.executeUpdate();
				
			} catch (Exception e) {				
				e.printStackTrace();
			}
			
			
		}
		public void Delete(SinhVien t) {
			
			try {
			
			   String sql = "DELETE from SinhVien " 
						   + "WHERE MASV =?";
				PreparedStatement sinhvien =  c.prepareStatement(sql);
				sinhvien.setString(1, t.getMaSV());		
				sinhvien.execute();
			} catch (Exception e) {				
				e.printStackTrace();
			}
			
		}
		public void Uppdate(SinhVien t) {
		
			try {
			
				String sql = "UPDATE SinhVien SET HOTEN =?,NGSINH =?,PHAI =?,MAL =? WHERE MASV = ?";
				PreparedStatement sinhvien =  c.prepareStatement(sql);
			
				sinhvien.setString(1,t.getHoTen());
				sinhvien.setDate(2,t.getNgSinh());
				sinhvien.setString(3,t.getGioiTinh());
				sinhvien.setString(4,t.getMaLop());
			    sinhvien.setString(5, t.getMaSV());
				
				
				sinhvien.executeUpdate();
				
				
			} catch (Exception e) {				
				e.printStackTrace();
			}
		}
		// Diem THI
		
		public ArrayList<DiemThi> getListDiem(){
			ArrayList<DiemThi> list = new ArrayList<DiemThi>();
			String sql = "SELECT * FROM quanlythongtinsinhvien.diemthi";
			try {
				PreparedStatement ps = c.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					DiemThi diem = new DiemThi();
					diem.setMaSV(rs.getString("MASV"));
					diem.setMaMT(rs.getString("MAMT"));
					diem.setDiem(rs.getBigDecimal("DIEM").floatValue());
					diem.setGhiChu(rs.getString("GHICHU"));
					list.add(diem);
			
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
					
		}
		public void Insert(DiemThi t) {		
			
			try {
				String sql = "INSERT INTO DiemThi (MASV, MAMT, DIEM, GHICHU )" 
					       + " VALUES (?,?,?,?)";
				 PreparedStatement diemthi =  c.prepareStatement(sql);
					diemthi.setString(1,t.getMaSV());
					diemthi.setString(2,t.getMaMT());
					BigDecimal diem = BigDecimal.valueOf(t.getDiem());
			        diemthi.setBigDecimal(3, diem);
					diemthi.setString(4,t.getGhiChu());
								
					diemthi.executeUpdate();
				
			} catch (Exception e) {				
				e.printStackTrace();
			}
			
			
		}
		public void Delete(DiemThi t) {
			
			try {
			
				String sql = "DELETE from DiemThi " 
						   + "WHERE MASV = ? and MAMT = ?";
			    PreparedStatement diemthi =  c.prepareStatement(sql);
				diemthi.setString(1,t.getMaSV());
				diemthi.setString(2, t.getMaMT());
			    
				diemthi.executeUpdate();
			} catch (Exception e) {				
				e.printStackTrace();
			}
			
		}
		public void Uppdate(DiemThi t) {
		
			try {
			
				String sql = "UPDATE DiemThi " 
				           + " SET " 				    
				           + "DIEM =?,"
				           + "GHICHU =?"
				           + "WHERE MASV = ? and MAMT = ?";
				PreparedStatement diemthi =  c.prepareStatement(sql);
				BigDecimal diem = BigDecimal.valueOf(t.getDiem());
		        diemthi.setBigDecimal(1, diem);
				diemthi.setString(2,t.getGhiChu());
				diemthi.setString(3,t.getMaSV());
				diemthi.setString(4,t.getMaMT());
								
				diemthi.executeUpdate();
				
				
			} catch (Exception e) {				
				e.printStackTrace();
			}
		}
		//Thi 
		public ArrayList<Thi> selecALL() {
			ArrayList<Thi> ketqua = new ArrayList<Thi>();
			try {
		         String sql = "SELECT * FROM Thi " ;
				PreparedStatement thi =  c.prepareStatement(sql);
				
				System.out.println(sql);
				ResultSet rs = thi.executeQuery();
				while (rs.next()) {
					Thi t= new Thi();
					t.setMaMT(rs.getString("MaMT"));
					t.setMaCN(rs.getString("MaCN"));						
				
					ketqua.add(t);
				}						
			} catch (Exception e) {				
				e.printStackTrace();
			}
			return ketqua;
		}
		
		public void Insert(Thi t) {
			try {					
				String sql = "INSERT INTO Thi (MAMT, MACN )" 
					       + " VALUES (?,?)";
				PreparedStatement thi =  c.prepareStatement(sql);
				thi.setString(1,t.getMaMT());
				thi.setString(2, t.getMaCN());			
                thi.executeUpdate();											
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		public void Delete(Thi t) {
			
			try {		
				String sql = "DELETE from Thi " 
						   + "WHERE MAMT = ?";
				PreparedStatement thi =  c.prepareStatement(sql);
				thi.setString(1,t.getMaMT());				
			   thi.executeUpdate();
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		// MÔn Thi
		public ArrayList<MonThi> selecALLMonThi() {
			ArrayList<MonThi> ketqua = new ArrayList<MonThi>();
			try {			
				String sql = "SELECT * FROM MonThi " ;
				PreparedStatement monthi =  c.prepareStatement(sql);
				System.out.println(sql);
				ResultSet rs = monthi.executeQuery();
				 
				while (rs.next()) {
				
					String MaMT = rs.getString("MaMT");
					String TENMT = rs.getString("TENMT");
								
					MonThi monThi = new MonThi(MaMT, TENMT);
					ketqua.add(monThi);
					
				}					
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return ketqua;
		}
		public void Uppdate(Thi t) {
			
			try {
			
				String sql = "UPDATE Thi " 
				           + " SET MACN =? " 				    			         
				           + "WHERE MAMT = ?";
				PreparedStatement diemthi =  c.prepareStatement(sql);
			
		        diemthi.setString(1, t.getMaCN());
				diemthi.setString(2,t.getMaMT());
			
								
				diemthi.executeUpdate();
				
				
			} catch (Exception e) {				
				e.printStackTrace();
			}
		}
		public ArrayList<String> selecALLMAMonThi() {
			ArrayList<String> ketqua = new ArrayList<String>();
			try {			
				String sql = "SELECT MAMT FROM MonThi;" ;
				PreparedStatement monthi =  c.prepareStatement(sql);
				System.out.println(sql);
				ResultSet rs = monthi.executeQuery();
				 
				while (rs.next()) {
				
					String MaMT = rs.getString("MaMT");	
					ketqua.add(MaMT);
					
				}					
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return ketqua;
		}
		public void Insert(MonThi t) {
			try {
				String sql = "INSERT INTO MonThi (MAMT, TENMT )" 
					       + " VALUES (?,?)";
				PreparedStatement monthi =  c.prepareStatement(sql);
				monthi.setString(1,t.getMaMT());
				monthi.setString(2, t.getTenMT());			
			    monthi.executeUpdate();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
		
		public void Delete(MonThi t) {
			
			try {		
				String sql = "DELETE from MonThi " 
						   + "WHERE MAMT = ?" ;
				PreparedStatement monthi =  c.prepareStatement(sql);
				monthi.setString(1, t.getMaMT());
                 monthi.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}
			

		}
		public void Uppdate(MonThi t) {
		
			try {				
				String sql = "UPDATE MonThi " 
				           + " SET "
				           + "TENMT = ? "
				           + "WHERE MAMT = ?";
				PreparedStatement monthi =  c.prepareStatement(sql);
				monthi.setString(1, t.getTenMT());
				monthi.setString(2,t.getMaMT());
				
			monthi.executeUpdate();
			
			} catch (Exception e) {
			
				e.printStackTrace();
				}
			
		}
		//Lớp 
		
		public ArrayList<Lop> selecALLLop() {
			ArrayList<Lop> ketqua = new ArrayList<Lop>();
			try {
				String sql = "SELECT * FROM Lop " ;
				PreparedStatement lop =  c.prepareStatement(sql);
				
				System.out.println(sql);
				ResultSet rs = lop.executeQuery();
				while (rs.next()) {
					String MAL = rs.getString("MAL");
					byte SISO = rs.getByte("SISO");
					String MACn = rs.getString("MACN");				
					Lop Lop = new Lop(MAL, SISO, MACn);
					ketqua.add(Lop);
				}
			
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return ketqua;
		}
		public void Delete(Lop t) {
			
			try {

				String sql = "DELETE from Lop " 
						   + "WHERE MAL =? ";
				PreparedStatement lop =  c.prepareStatement(sql);
				lop.setString(1, t.getMaL());
			    lop.executeUpdate();
								
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		}

		public void Insert(Lop t) {
			

			try {
				
				
				String sql = "INSERT INTO Lop (MAL, SISO, MACN)" 
					       + " VALUES (?,?,?)";
				PreparedStatement lop =  c.prepareStatement(sql);
				lop.setString(1, t.getMaL());
				lop.setByte(2, t.getSiSo());
				lop.setString(3, t.getMaCN());
			    lop.executeUpdate();

				
				
			} catch (Exception e) {
	
				e.printStackTrace();
			}
		}


		public void Uppdate(Lop t) {
		
			try {
	
				
				String sql = "UPDATE Lop " 
					       + " SET " 
						   + "SISO =?,"
						   + "MACN =? "
						   + "WHERE MAL = ?";
				PreparedStatement lop =  c.prepareStatement(sql);
				lop.setByte(1, t.getSiSo());
				lop.setString(2, t.getMaCN());
				lop.setString(3, t.getMaL());
			
			lop.executeUpdate();
		
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		//khoa 
		
		
		public ArrayList<Khoa> selecALLKhoa() {
			ArrayList<Khoa> ketqua = new ArrayList<Khoa>();
			try {


				String sql = "SELECT * FROM Khoa " ;
				PreparedStatement Khoa =  c.prepareStatement(sql);
				
				System.out.println(sql);
				ResultSet rs = Khoa.executeQuery(sql);
				while (rs.next()) {
					String MAKHOA = rs.getString("MAKHOA");
					String TENKHOA = rs.getString("TENKHOA");
					Date NAMTL = rs.getDate("NAMTL");
					String PHONGLV = rs.getString("PHONGLV");
					String TEL = rs.getString("TEL");
					String MATRGKHOA = rs.getString("MATRGKHOA");
				
					Khoa khoa = new Khoa(MAKHOA, TENKHOA, NAMTL, PHONGLV, TEL, MATRGKHOA);
					ketqua.add(khoa);				
				}
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return ketqua;
		}
		public void Insert(Khoa t) {
		
			try {
			
				
				String sql = "INSERT INTO Khoa (MAKHOA, TENKHOA, NAMTL, PHONGLV, TEL, MATRGKHOA)" 
					       + " VALUES (?,?,?,?,?,?)";
				
				PreparedStatement Khoa =  c.prepareStatement(sql);
				Khoa.setString(1, t.getMaKhoa());
				Khoa.setString(2, t.getTenKhoa());
				Khoa.setDate(3, t.getNamTL());
				Khoa.setString(4, t.getPhongLV());
				Khoa.setString(5, t.getTel());
				Khoa.setString(6, t.getMaTrgKhoal());				
			    Khoa.executeUpdate();
				 

				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	
		public void Uppdate(Khoa t) {
		
			try {
	
				String sql = "UPDATE Khoa " 
					       + " SET " 
						   + "TENKHOA =?," 
						   + "NAMTL =?," 
						   + "PHONGLV =?,"
						   + "TEL =?,"
						   + "MATRGKHOA =?"
						   + "WHERE MAKHOA = ?";
				PreparedStatement Khoa =  c.prepareStatement(sql);
				 Khoa.setString(1, t.getTenKhoa());
				 Khoa.setDate(2, t.getNamTL());
				 Khoa.setString(3, t.getPhongLV());
				 Khoa.setString(4, t.getTel());
				 Khoa.setString(5, t.getMaTrgKhoal());
				 Khoa.setString(6, t.getMaKhoa());
				
				 Khoa.executeUpdate();
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}


		public void Delete(Khoa t) {
			
			try {

			
				String sql = "DELETE from Khoa " 
						   + "WHERE MAKHOA =?";
				PreparedStatement Khoa =  c.prepareStatement(sql);
				Khoa.setString(1, t.getMaKhoa());
			    Khoa.executeUpdate();
	
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
		// Giang vien
		public ArrayList<String> selecMAGV() {
			ArrayList<String> ketqua = new ArrayList<String>();
			try {
		
				String sql = "SELECT MAGV FROM GiangVien " ;
				PreparedStatement GiangVien =  c.prepareStatement(sql);
				
	            System.out.println(sql);
				ResultSet rs = GiangVien.executeQuery();
				while (rs.next()) {
					
					String MAGV = rs.getString("MAGV");
					
					ketqua.add(MAGV);
				}
										
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return ketqua;
			
		}
		
		public ArrayList<GiangVien> selecALLGV() {
			ArrayList<GiangVien> ketqua = new ArrayList<GiangVien>();
			try {
		
				String sql = "SELECT * FROM GiangVien " ;
				PreparedStatement GiangVien =  c.prepareStatement(sql);
				
	            System.out.println(sql);
				ResultSet rs = GiangVien.executeQuery();
				while (rs.next()) {
					String MAGV = rs.getString("MAGV");
					String TENGV = rs.getString("TENGV");
					String SODT = rs.getString("SODT");
					String MAKHOA = rs.getString("MAKHOA");
				
					GiangVien giangvien = new GiangVien(MAGV, TENGV, SODT, MAKHOA);
					ketqua.add(giangvien);
				}
										
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return ketqua;
			
		}
		public void Delete(GiangVien t) {
		
			try {
		
		
				String sql = "DELETE from GiangVien " 
						   + "WHERE MAGV = ?";	
			   	PreparedStatement giangvien =  c.prepareStatement(sql);
				giangvien.setString(1, t.getMaGV());
				giangvien.executeUpdate();
			
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	
		public void Insert(GiangVien t) {
		
			try {
		
				
				String sql = "INSERT INTO GiangVien (MAGV, TENGV, SODT, MAKHOA)" 
					       + " VALUES (?,?,?,?)";
				PreparedStatement giangvien =  c.prepareStatement(sql);
				giangvien.setString(1, t.getMaGV());
				giangvien.setString(2, t.getTenGV());
				giangvien.setString(3, t.getSoDT());
				giangvien.setString(4, t.getMaKhoa());
				
			   giangvien.executeUpdate();
		
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		
		public void Uppdate(GiangVien t) {
			try {
		
				String sql = "UPDATE GiangVien " 
					       + " SET "
						   + "TENGV =?,"
						   + "SODT =?,"
						   + "MAKHOA =?"
						   + "WHERE MAGV = ?";
				PreparedStatement giangvien =  c.prepareStatement(sql);
				
				giangvien.setString(1, t.getTenGV());
				giangvien.setString(2, t.getSoDT());
				giangvien.setString(3, t.getMaKhoa());
				giangvien.setString(4, t.getMaGV());
			 giangvien.executeUpdate();			
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
// dien thoai
		
		public ArrayList<DienThoai> selecALLDT() {
			ArrayList<DienThoai> ketqua = new ArrayList<DienThoai>();
			try {
		
			
				
				String sql = "SELECT * FROM DienThoai " ;
				PreparedStatement dienthoai =  c.prepareStatement(sql);
			
				System.out.println(sql);
				ResultSet rs = dienthoai.executeQuery();
				while (rs.next()) {
					String MASV = rs.getString("MASV");
					String SODT = rs.getString("SODT");
					
				
					DienThoai dienThoai = new DienThoai(MASV, SODT);
					ketqua.add(dienThoai); 
					
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ketqua;
		}
		public void Delete(DienThoai t) {
		
			try {			
			
				String sql = "DELETE from DienThoai " 
						   + "WHERE MASV = ?";
				PreparedStatement dienthoai = c.prepareStatement(sql);
				dienthoai.setString(1,t.getMaSV());
		
			
			   dienthoai.executeUpdate(); 

				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void Insert(DienThoai t) {
			

			try {
				
				String sql = "INSERT INTO DienThoai (MASV, SODT )" 
					       + " VALUES(? ,?)";
		       PreparedStatement dienthoai =  c.prepareStatement(sql);
				dienthoai.setString(1,t.getMaSV());
				dienthoai.setString(2,t.getSoDT());
				
			dienthoai.executeUpdate();
				
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	
		}

	
		public void Uppdate(DienThoai t) {
		
			try {

				
				String sql = "UPDATE DienThoai " 
				           + " SET " 
				      
				           + "SODT =?"
				           + "WHERE MASV = ?";
				PreparedStatement dienthoai =  c.prepareStatement(sql);
			
				dienthoai.setString(1,t.getSoDT());
				dienthoai.setString(2,t.getMaSV());
				
			  dienthoai.executeUpdate();
				
		
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Dia chi
		
		public ArrayList<DiaChi> selecALLDC() {
			ArrayList<DiaChi> ketqua = new ArrayList<DiaChi>();
			try {
		
			
				String sql = "SELECT * FROM DiaChi " ;
				PreparedStatement diachi =  c.prepareStatement(sql);
				
				System.out.println(sql);
				ResultSet rs = diachi.executeQuery();
				while (rs.next()) {
					String MASV = rs.getString("MASV");
					String SONhA = rs.getString("SONhA");
					String DUONG = rs.getString("DUONG");
					String QUAN = rs.getString("QUAN");
				    String THANHPHO = rs.getString("THANHPHO");
				
					DiaChi diaChi = new DiaChi(MASV, SONhA, DUONG, QUAN, THANHPHO);
					ketqua.add(diaChi);
					
				}
				
			} catch (Exception e) {
			
			}
			return ketqua;
		}
		public void Delete(DiaChi t) {
			
			try {
			
				
				String sql = "DELETE from DiaChi " 
						   + "WHERE MASV = ?";
				PreparedStatement diachi =  c.prepareStatement(sql);
				diachi.setString(1, t.getMaSV());
				
			diachi.executeUpdate();
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		}

		
		public void Insert(DiaChi t) {
			

			try {
		
				
				String sql = "INSERT INTO DiaChi (MASV, SONhA, DUONG, QUAN, THANHPHO )" 
					       + " VALUES (?,?,?,?,?)";
		        PreparedStatement diachi =  c.prepareStatement(sql);
		        diachi.setString(1,t.getMaSV());
		        diachi.setString(2,t.getSoNha());
		        diachi.setString(3,t.getDuong());
		        diachi.setString(4,t.getQuan());
		        diachi.setString(5,t.getThanhPho());
		        
		       
			 diachi.executeUpdate();
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			
		}

		
		public void Uppdate(DiaChi t) {
		
			try {
		
				
			
			
				String sql = "UPDATE DiaChi " 
				           + " SET " 
				           + "SONhA =?,"
				           + "DUONG =?,"
				           + "QUAN =?,"
				           + "THANHPHO =?"
				           + "WHERE MASV =?";
			    PreparedStatement diachi =  c.prepareStatement(sql);
;
		        diachi.setString(1,t.getSoNha());
		        diachi.setString(2,t.getDuong());
		        diachi.setString(3,t.getQuan());
		        diachi.setString(4,t.getThanhPho());
		        diachi.setString(5,t.getMaSV());
				
				diachi.executeUpdate(); 
				
			} catch (Exception e) {
			e.printStackTrace();
			}
			
		
		}
// chuyen nganh
		
		public ArrayList<ChuyenNganh> selecALLCN() {
			ArrayList<ChuyenNganh> ketqua = new ArrayList<ChuyenNganh>();
			try {

				
				String sql = "SELECT * FROM ChuyenNganh " ;
				PreparedStatement chuyenNghah =  c.prepareStatement(sql);
				
				System.out.println(sql);
				ResultSet rs = chuyenNghah.executeQuery();
				while (rs.next()) {
					String MACN = rs.getString("MACN");
					String TENCN = rs.getString("TENCN");
					String MAGVQL = rs.getString("MAGVQL");
					String MAKHOA = rs.getString("MAKHOA");
				
					ChuyenNganh chuyeNganh = new ChuyenNganh(MACN, TENCN, MAGVQL, MAKHOA);//Tạo ra 1 đối tượng khoa
					ketqua.add(chuyeNganh);
				}
				
				
		
				
			} catch (Exception e) {
		
				e.printStackTrace();
			}
			return ketqua;
		}
		public void Delete(ChuyenNganh t) {
		
			try {
		
				String sql = "DELETE from ChuyenNganh " 
						   + "WHERE MACN =?" ;
				PreparedStatement chuyennganh =  c.prepareStatement(sql);
				chuyennganh.setString(1, t.getMaCN());
				
		        chuyennganh.executeUpdate();
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void Insert(ChuyenNganh t) {
	
			try {
			
	
				String sql = "INSERT INTO ChuyenNganh (MACN, TENCN, MAGVQL, MAKHOA)" 
					       + " VALUES (? ,? ,? , ?)";
				PreparedStatement chuyennghanh =  c.prepareStatement(sql);
				chuyennghanh.setString(1, t.getMaCN());
				chuyennghanh.setString(2, t.getTenCN());
				chuyennghanh.setString(3, t.getMaGVCN());
				chuyennghanh.setString(4, t.getMaKhoa());
				  
			chuyennghanh.executeUpdate();
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			

		}

		public void Uppdate(ChuyenNganh t) {
		
			try {
		
			
				String sql = "UPDATE ChuyenNganh " 
					       + " SET " 
				
						   + "TENCN = ?,"
						   + "MAGVQL = ?,"
						   + "MAKHOA = ?"
						   + "WHERE MACN = ?";
				PreparedStatement chuyennghanh =  c.prepareStatement(sql);
				
				chuyennghanh.setString(1, t.getTenCN());
				chuyennghanh.setString(2, t.getMaGVCN());
				chuyennghanh.setString(3, t.getMaKhoa());
				chuyennghanh.setString(4, t.getMaCN());
			
				chuyennghanh.executeUpdate();
				
			
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
// câu 1
		public ArrayList<Object[]> getDiemAndHoTen() {
		    ArrayList<Object[]> resultList = new ArrayList<>();

		    String sql = "select sinhvien.HOTEN,mamt,diemthi.DIEM from diemthi join sinhvien using (MASV) where sinhvien.MASV = 15001;";

		    try (PreparedStatement ps = c.prepareStatement(sql)) {
		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		            BigDecimal diem = rs.getBigDecimal("DIEM");
		            String hoTena = rs.getString("MAMT");
		            String hoTen = rs.getString("HOTEN");
		            Object[] resultRow = {diem, hoTena,hoTen};
		            resultList.add(resultRow);
		            System.out.println(Arrays.toString(resultRow));
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return resultList;
		}
		public ArrayList<Object[]> getKhoaorChuyenNganh() {
		    ArrayList<Object[]> resultList = new ArrayList<>();

		    String sql = "SELECT khoa.MATRGKHOA FROM khoa " +
		                 "JOIN giangvien USING (MAKHOA) " +
		                 "GROUP BY khoa.MATRGKHOA " +
		                 "UNION " +
		                 "SELECT chuyennganh.MAGVQL FROM chuyennganh " +
		                 "JOIN giangvien ON chuyennganh.MAGVQL = giangvien.MAGV " +
		                 "GROUP BY chuyennganh.MAGVQL";

		    try (PreparedStatement ps = c.prepareStatement(sql)) {
		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		            String matrgkhoa = rs.getString("MATRGKHOA");
		            Object[] resultRow = {matrgkhoa};
		            resultList.add(resultRow);
		            System.out.println(Arrays.toString(resultRow));
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return resultList;
		}
		
		public ArrayList<Object[]> getSinhVienByLop() {
		    ArrayList<Object[]> resultList = new ArrayList<>();

		    String sql = "select* from sinhvien"
		    		+" join lop using (MAL)"
		    		+" where lop.MAL = 'KTPM01'";;

		    try (PreparedStatement ps = c.prepareStatement(sql)) {
		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		        	String maL = rs.getString("MAL");
		            String maSV = rs.getString("MASV");
		            String hoTen = rs.getString("HOTEN");
		            String NgSinh = rs.getString("NGSINH");
		            String Phai = rs.getString("PHAI");
		            String ss = rs.getString("SISO");
		            String MaCN = rs.getString("MACN");

		            Object[] resultRow = {maL,maSV, hoTen,NgSinh,Phai,ss,MaCN};
		            resultList.add(resultRow);
		          
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return resultList;
		}
		public ArrayList<Object[]> getSiSoLop() {
		    ArrayList<Object[]> resultList = new ArrayList<>();

		    String sql = "select distinct LOP.SISO,LOP.MAL from LOP  join SINHVIEN using (MAL) where LOP.SISO >= 45;";

		    try (PreparedStatement ps = c.prepareStatement(sql)) {
		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		        	String maL = rs.getString("MAL");
		            String ss = rs.getString("SISO");
		            Object[] resultRow = {ss,maL};
		            resultList.add(resultRow);
		          
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return resultList;
		}	
		public ArrayList<Object[]> getMalSiSo() {
		    ArrayList<Object[]> resultList = new ArrayList<>();

		    String sql = "select lop.MAL,lop.SISO from lop order by LOP.SISO desc;";

		    try (PreparedStatement ps = c.prepareStatement(sql)) {
		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		        	String maL = rs.getString("MAL");
		            String ss = rs.getString("SISO");
		            Object[] resultRow = {maL,ss};
		            resultList.add(resultRow);
		          
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return resultList;
		}	
		public ArrayList<Object[]> getSiSoTBKhoa() {
		    ArrayList<Object[]> resultList = new ArrayList<>();

		    String sql = "select  chuyennganh.MAKHOA, sum(siso)as vn from lop , chuyennganh where chuyennganh.macn=lop.macn group by makhoa having vn =( select max(tong) as tong1 from( select chuyennganh.MAKHOA, sum(siso) as tong from lop join chuyennganh using(MACN) group by makhoa) as a);";

		    try (PreparedStatement ps = c.prepareStatement(sql)) {
		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		        	String maL = rs.getString("MAKHOA");
		            String ss = rs.getString("vn");
		            Object[] resultRow = {maL,ss};
		            resultList.add(resultRow);
		          
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return resultList;
		}	
		public ArrayList<Object[]> getKhoaTL() {
		    ArrayList<Object[]> resultList = new ArrayList<>();

		    String sql = "select khoa.MAKHOA, tenkhoa  as 'những khoa thành lập từ năm 2015-2018'  from khoa  where year(namtl)between 2015 and 2018;";

		    try (PreparedStatement ps = c.prepareStatement(sql)) {
		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		        	String maL = rs.getString("MAKHOA");
		            String ss = rs.getString("những khoa thành lập từ năm 2015-2018");
		          
		            Object[] resultRow = {maL,ss};
		            resultList.add(resultRow);
		          
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return resultList;
		}	
		public ArrayList<Object[]> getDTBSV() {
		    ArrayList<Object[]> resultList = new ArrayList<>();

		    String sql = "select sinhvien.HOTEN,sinhvien.MASV ,avg(diem) as 'DIEMTB' from diemthi join sinhvien using (MASV) group by sinhvien.HOTEN,sinhvien.MASV;";

		    try (PreparedStatement ps = c.prepareStatement(sql)) {
		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		        	String maL = rs.getString("HOTEN");
		            String ss = rs.getString("MASV");
		            String diem = rs.getString("DIEMTB");
		            Object[] resultRow = {maL,ss,diem};
		            resultList.add(resultRow);
		          
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return resultList;
		}
		public ArrayList<Object[]> TenMTHoTenDiem(){
		    ArrayList<Object[]> resultList = new ArrayList<>();

		    String sql = "select monthi.TENMT,sinhvien.HOTEN,diemthi.DIEM from diemthi join sinhvien using (MASV) join monthi using (MAMT) where diemthi.DIEM <5;";

		    try (PreparedStatement ps = c.prepareStatement(sql)) {
		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		        	String maL = rs.getString("TENMT");
		            String ss = rs.getString("HOTEN");
		            String diem = rs.getString("DIEM");
		            Object[] resultRow = {maL,ss,diem};
		            resultList.add(resultRow);
		          
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return resultList;
		}
		public ArrayList<Object[]> getDemMaKhoa() {
		    ArrayList<Object[]> resultList = new ArrayList<>();

		    String sql = "select chuyennganh.makhoa,tenkhoa from chuyennganh join khoa using (makhoa) group by makhoa having count( makhoa)>3;";

		    try (PreparedStatement ps = c.prepareStatement(sql)) {
		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		        	String maL = rs.getString("makhoa");
		            String ss = rs.getString("tenkhoa");
		          
		            Object[] resultRow = {maL,ss};
		            resultList.add(resultRow);
		          
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return resultList;
		}
		public ArrayList<Object[]> getSVCSDL() {
		    ArrayList<Object[]> resultList = new ArrayList<>();

		    String sql = "select sinhvien.HOTEN,sinhvien.MASV,diem from diemthi join sinhvien using (MASV) where mamt = 'csdl';";

		    try (PreparedStatement ps = c.prepareStatement(sql)) {
		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		        	String maL = rs.getString("HOTEN");
		            String ss = rs.getString("MASV");
		            String sss = rs.getString("diem");
		            Object[] resultRow = {maL,ss,sss};
		            resultList.add(resultRow);
		          
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return resultList;
		}
		public ArrayList<Object[]> getSVDiemThi() {
		    ArrayList<Object[]> resultList = new ArrayList<>();

		    String sql = "select sinhvien.HOTEN,sinhvien.MASV,diem,ghichu,mamt,sinhvien.mal from diemthi join sinhvien using (MASV) where mamt = 'csdl'and (mal='KTPM02' or mal='KTPM01' or mal='KTPM03' or mal='KTPM04')";

		    try (PreparedStatement ps = c.prepareStatement(sql)) {
		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		        	String maL = rs.getString("HOTEN");
		            String ss = rs.getString("MASV");
		            String sss = rs.getString("diem");
		            String sss1 = rs.getString("ghichu");
		            String sss2 = rs.getString("mamt");
		            String sss3 = rs.getString("mal");
		            Object[] resultRow = {maL,ss,sss,sss1,sss2,sss3};
		            resultList.add(resultRow);
		          
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return resultList;
		}
		public ArrayList<Object[]> getSVVT() {
		    ArrayList<Object[]> resultList = new ArrayList<>();

		    String sql = "select sinhvien.mal from sinhvien join diemthi using (masv) where ghichu = 'vắng thi' group by mal;";

		    try (PreparedStatement ps = c.prepareStatement(sql)) {
		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		        	String maL = rs.getString("mal");
		            
		            Object[] resultRow = {maL};
		            resultList.add(resultRow);
		          
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return resultList;
		}
		public ArrayList<Object[]> getMACNSISO() {
		    ArrayList<Object[]> resultList = new ArrayList<>();

		    String sql = "select macn ,siso from lop;";

		    try (PreparedStatement ps = c.prepareStatement(sql)) {
		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		        	String maL = rs.getString("macn");
		        	String ma = rs.getString("siso");
		            
		            Object[] resultRow = {maL,ma};
		            resultList.add(resultRow);
		          
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return resultList;
		}
		public ArrayList<Object[]> getMaSVHoTen() {
		    ArrayList<Object[]> resultList = new ArrayList<>();

		    String sql = "select masv,hoten  from sinhvien join lop using(mal)  join diemthi using (masv) where macn='kpdl' and diem >=8   group by masv having count(masv)=5;";

		    try (PreparedStatement ps = c.prepareStatement(sql)) {
		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		        	String maL = rs.getString("masv");
		        	String ma = rs.getString("hoten");
		            
		            Object[] resultRow = {maL,ma};
		            resultList.add(resultRow);
		          
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return resultList;
		}
	
	public static void main(String[] args) {
		Sukien sk = new Sukien();
		sk.getListMAL();
		
	}
		}
		
	
	
