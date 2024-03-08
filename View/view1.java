package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;
import javax.swing.table.DefaultTableModel;

import Controller.Sukien;
import model.SinhVien;
import model.Thi;
import model.Admin;
import model.ChuyenNganh;
import model.DiaChi;
import model.DiemThi;
import model.DienThoai;
import model.GiangVien;
import model.Khoa;
import model.Lop;
import model.MonThi;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;

import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;

public class view1 extends JFrame {

	private JPanel contentPane;
	private JPanel panelSV;

	private JTextField textField;
	private JPasswordField passwordField;
	private JCheckBox CheckBox;
	private Admin modelAticon;
	private JLabel labelTB;
	private JButton btnNewButton;
	private JTable table_1;
	private JButton buttonThem;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnTruyVan;
	private JTextField textNhap;

	private JTextField FieldMa;
	private JTextField Field_HoTen;
	private JTextField textFieldNgSinh;
	private JTextField textField_MaL;
	private JRadioButton RadioButtonNam;
	private JRadioButton radioNu;

	private JTextField textField_MT;
	private JTextField textField_maCN;

	private JTextField textField_MAMT;
	private JTextField textField_teMT;

	private JTextField textField_MaLop;
	private JTextField textField_SiSo;
	private JTextField textField_MaCN;

	private JTextField textField_Makhoa;
	private JTextField textField_tenKhoa;
	private JTextField textField_namTL;
	private JTextField textField_phongLv;
	private JTextField textField_Tel;
	private JTextField textField_MatrgKhoa;

	private JTextField textField_maGV;
	private JTextField textField_tenGv;
	private JTextField textField_soDT;
	private JTextField textField_Makhoagv;

	private JTextField textField_MASVdt;
	private JTextField textField_soDt;

	private JTextField textField_maSVdiem;
	private JTextField textField_maMTdiem;
	private JTextField textField_Diem;
	private JTextField textField_ghichu;

	private JTextField textField_maSVdc;
	private JTextField textField_soNha;
	private JTextField textField_Duong;
	private JTextField textField_Quan;
	private JTextField textField_Thanhpho;

	private JTextField textField_maCNchuyennganh;
	private JTextField textField_TenCn;
	private JTextField textField_maGVQl;
	private JTextField textField_Makhoacn;

	private List<SinhVien> sinhVien;
	private List<DiemThi> diemThi;
	private List<Thi> thi;
	private List<MonThi> monThi;
	private List<Khoa> khoa;
	private List<ChuyenNganh> chuyenNganh;
	private List<Lop> lop;
	private List<GiangVien> giangVien;
	private List<DienThoai> dienThoai;
	private List<DiaChi> diachi;
	private List<Object[]> maSV15001;

	private DefaultTableModel modelt;
	private JPanel panelthi;
	private JPanel panelmonthi;
	private JPanel panellop;
	private JPanel panelkhoa;
	private JPanel paneldiachi;
	private JPanel panelchuyennganh;
	private JPanel paneldienthoai;
	private JPanel panelgiangvien;
	private JPanel paneldiemthi;

	public view1(Admin modelAticon) {
		this.modelAticon = modelAticon;
		init();
		this.setVisible(true);
	}

	public void init() {
		setFont(new Font("Arial", Font.PLAIN, 14));
		setTitle("Quản Lý Sinh Viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1016, 496);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelImg = new JLabel("");
		labelImg.setBackground(Color.WHITE);
		labelImg.setIcon(new ImageIcon(
				"C:\\Users\\DAO TUAN AN\\Downloads\\pngtree-user-login-or-authenticate-icon-on-gray-background-flat-icon-ve-png-image_1742031.jpg"));
		labelImg.setBounds(0, 0, 652, 459);
		contentPane.add(labelImg);

		btnNewButton = new JButton("ĐĂNG NHẬP");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionUser();

			}
		});

		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(728, 277, 236, 45);
		contentPane.add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(728, 156, 236, 31);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(728, 219, 236, 31);
		contentPane.add(passwordField);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(656, 157, 70, 31);
		contentPane.add(lblNewLabel);

		labelTB = new JLabel("Vui lòng nhập thông tin đăng nhập!");
		labelTB.setBackground(new Color(255, 0, 0));
		labelTB.setFont(new Font("Arial", Font.BOLD, 13));
		labelTB.setBounds(728, 81, 236, 38);
		contentPane.add(labelTB);

		CheckBox = new JCheckBox("Check Password");
		CheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkBox();
			}
		});

		CheckBox.setFont(new Font("Arial", Font.PLAIN, 12));
		CheckBox.setBackground(Color.CYAN);
		CheckBox.setBounds(847, 338, 117, 31);
		contentPane.add(CheckBox);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPassword.setBounds(659, 218, 70, 31);
		contentPane.add(lblPassword);

	}

	public String getUserName() {
		String name = textField.getText();
		return name;
	}

	public String getPassWord() {
		String pass = new String(passwordField.getPassword());
		return pass;
	}

	public void clearFieal() {
		textField.setText("");
		passwordField.setText("");
	}

	public void clearFiealTruyVan() {
		textNhap.setText("");
	}

	public void showErrorMessage() {
		JOptionPane.showMessageDialog(contentPane, "Đăng nhập sai, Vui lòng thử lại.", "Thông báo",
				JOptionPane.ERROR_MESSAGE);
	}

	public void showYesMessage() {
		JOptionPane.showMessageDialog(contentPane, "Đăng nhập đúng.", "Thông báo", JOptionPane.PLAIN_MESSAGE);
	}

	public void showMessage() {
		JOptionPane.showMessageDialog(contentPane, "Không được bỏ trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
	}

	public void checkBox() {
		char echoChar = (CheckBox.isSelected()) ? 0 : '\u2022';
		passwordField.setEchoChar(echoChar);
	}

	public void actionUser() {
		modelAticon.setUsername(getUserName());
		modelAticon.setPassword(getPassWord());
		if (modelAticon.isAcount()) {
			clearFieal();
			showYesMessage();
			dangNhap();

		} else if (getUserName().length() == 0 || getPassWord().length() == 0) {
			showMessage();
		} else {
			showErrorMessage();
		}
	}

	public void showTextFieldThi() {

		textField_MT = new JTextField();
		textField_MT.setBounds(10, 10, 104, 19);
		panelthi.add(textField_MT);
		textField_MT.setColumns(10);

		JLabel LabelMA = new JLabel("MA MT");
		LabelMA.setFont(new Font("Arial", Font.PLAIN, 13));
		LabelMA.setBounds(124, 13, 48, 19);
		panelthi.add(LabelMA);

		JLabel lblHoTen = new JLabel("MA CN");
		lblHoTen.setFont(new Font("Arial", Font.PLAIN, 13));
		lblHoTen.setBounds(124, 58, 48, 19);
		panelthi.add(lblHoTen);

		textField_maCN = new JTextField();
		textField_maCN.setColumns(10);
		textField_maCN.setBounds(10, 55, 104, 19);
		panelthi.add(textField_maCN);

	}

	public void showTextFieldMonThi() {

		textField_MAMT = new JTextField();
		textField_MAMT.setBounds(10, 10, 104, 19);
		panelmonthi.add(textField_MAMT);
		textField_MAMT.setColumns(10);

		JLabel LabelMA = new JLabel("MA MT");
		LabelMA.setFont(new Font("Arial", Font.PLAIN, 13));
		LabelMA.setBounds(124, 13, 48, 19);
		panelmonthi.add(LabelMA);

		JLabel lblHoTen = new JLabel("TEN MT");
		lblHoTen.setFont(new Font("Arial", Font.PLAIN, 13));
		lblHoTen.setBounds(124, 58, 48, 19);
		panelmonthi.add(lblHoTen);

		textField_teMT = new JTextField();
		textField_teMT.setColumns(10);
		textField_teMT.setBounds(10, 55, 104, 19);
		textField_teMT.setHorizontalAlignment(SwingConstants.LEFT);
		panelmonthi.add(textField_teMT);

	}

	public void showTextFieldLop() {

		textField_MaLop = new JTextField();
		textField_MaLop.setBounds(10, 10, 104, 19);
		panellop.add(textField_MaLop);
		textField_MaLop.setColumns(10);

		JLabel LabelMA = new JLabel("MA LOP");
		LabelMA.setFont(new Font("Arial", Font.PLAIN, 13));
		LabelMA.setBounds(124, 13, 48, 19);
		panellop.add(LabelMA);

		JLabel lblHoTen = new JLabel("SI SO");
		lblHoTen.setFont(new Font("Arial", Font.PLAIN, 13));
		lblHoTen.setBounds(124, 58, 48, 19);
		panellop.add(lblHoTen);

		textField_SiSo = new JTextField();
		textField_SiSo.setColumns(10);
		textField_SiSo.setBounds(10, 55, 104, 19);
		panellop.add(textField_SiSo);

		textField_MaCN = new JTextField();
		textField_MaCN.setColumns(10);
		textField_MaCN.setBounds(10, 101, 104, 19);
		panellop.add(textField_MaCN);

		JLabel lblNgS = new JLabel("MACN");
		lblNgS.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNgS.setBounds(124, 104, 67, 19);
		panellop.add(lblNgS);

	}

	public void showTextFieldGV() {

		textField_maGV = new JTextField();
		textField_maGV.setBounds(10, 10, 104, 19);
		panelgiangvien.add(textField_maGV);
		textField_maGV.setColumns(10);

		JLabel LabelMA = new JLabel("MA GV");
		LabelMA.setFont(new Font("Arial", Font.PLAIN, 13));
		LabelMA.setBounds(124, 13, 48, 19);
		panelgiangvien.add(LabelMA);

		JLabel lblHoTen = new JLabel("TEN GV");
		lblHoTen.setFont(new Font("Arial", Font.PLAIN, 13));
		lblHoTen.setBounds(124, 58, 48, 19);
		panelgiangvien.add(lblHoTen);

		textField_tenGv = new JTextField();
		textField_tenGv.setColumns(10);
		textField_tenGv.setBounds(10, 55, 104, 19);
		panelgiangvien.add(textField_tenGv);
		textField_tenGv.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblNgS = new JLabel("SODT");
		lblNgS.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNgS.setBounds(124, 104, 67, 19);
		panelgiangvien.add(lblNgS);

		textField_soDT = new JTextField();
		textField_soDT.setColumns(10);
		textField_soDT.setBounds(10, 101, 104, 19);
		panelgiangvien.add(textField_soDT);

		JLabel lblMaL = new JLabel("MA KHOA");
		lblMaL.setFont(new Font("Arial", Font.PLAIN, 13));
		lblMaL.setBounds(124, 147, 60, 19);
		panelgiangvien.add(lblMaL);

		textField_Makhoagv = new JTextField();
		textField_Makhoagv.setColumns(10);
		textField_Makhoagv.setBounds(10, 144, 104, 19);
		panelgiangvien.add(textField_Makhoagv);

	}

	public void showTextFieldDT() {

		textField_MASVdt = new JTextField();
		textField_MASVdt.setBounds(10, 10, 104, 19);
		paneldienthoai.add(textField_MASVdt);
		textField_MASVdt.setColumns(10);

		JLabel LabelMA = new JLabel("MA SV");
		LabelMA.setFont(new Font("Arial", Font.PLAIN, 13));
		LabelMA.setBounds(124, 13, 48, 19);
		paneldienthoai.add(LabelMA);

		JLabel lblHoTen = new JLabel("SO DT");
		lblHoTen.setFont(new Font("Arial", Font.PLAIN, 13));
		lblHoTen.setBounds(124, 58, 48, 19);
		paneldienthoai.add(lblHoTen);

		textField_soDt = new JTextField();
		textField_soDt.setColumns(10);
		textField_soDt.setBounds(10, 55, 104, 19);
		paneldienthoai.add(textField_soDt);

	}

	public void showTextFieldDiemThi() {

		textField_maSVdiem = new JTextField();
		textField_maSVdiem.setBounds(10, 10, 104, 19);
		paneldiemthi.add(textField_maSVdiem);
		textField_maSVdiem.setColumns(10);

		JLabel LabelMA = new JLabel("MA SV");
		LabelMA.setFont(new Font("Arial", Font.PLAIN, 13));
		LabelMA.setBounds(124, 13, 48, 19);
		paneldiemthi.add(LabelMA);

		JLabel lblHoTen = new JLabel("MAMT");
		lblHoTen.setFont(new Font("Arial", Font.PLAIN, 13));
		lblHoTen.setBounds(124, 58, 48, 19);
		paneldiemthi.add(lblHoTen);

		textField_maMTdiem = new JTextField();
		textField_maMTdiem.setColumns(10);
		textField_maMTdiem.setBounds(10, 55, 104, 19);
		paneldiemthi.add(textField_maMTdiem);

		JLabel lblNgS = new JLabel("DIEM");
		lblNgS.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNgS.setBounds(124, 104, 67, 19);
		paneldiemthi.add(lblNgS);

		textField_Diem = new JTextField();
		textField_Diem.setColumns(10);
		textField_Diem.setBounds(10, 101, 104, 19);
		paneldiemthi.add(textField_Diem);

		JLabel lblMaL = new JLabel("GHICHU");
		lblMaL.setFont(new Font("Arial", Font.PLAIN, 13));
		lblMaL.setBounds(124, 147, 48, 19);
		paneldiemthi.add(lblMaL);

		textField_ghichu = new JTextField();
		textField_ghichu.setColumns(10);
		textField_ghichu.setBounds(10, 144, 104, 19);
		paneldiemthi.add(textField_ghichu);

	}

	public void showTextFieldCN() {

		textField_maCNchuyennganh = new JTextField();
		textField_maCNchuyennganh.setBounds(10, 10, 104, 19);
		panelchuyennganh.add(textField_maCNchuyennganh);
		textField_maCNchuyennganh.setColumns(10);

		JLabel LabelMA = new JLabel("MA CN");
		LabelMA.setFont(new Font("Arial", Font.PLAIN, 13));
		LabelMA.setBounds(124, 13, 48, 19);
		panelchuyennganh.add(LabelMA);

		JLabel lblHoTen = new JLabel("TEN CN");
		lblHoTen.setFont(new Font("Arial", Font.PLAIN, 13));
		lblHoTen.setBounds(124, 58, 48, 19);
		panelchuyennganh.add(lblHoTen);

		textField_TenCn = new JTextField();
		textField_TenCn.setColumns(10);
		textField_TenCn.setBounds(10, 55, 104, 19);
		panelchuyennganh.add(textField_TenCn);
		textField_TenCn.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblNgS = new JLabel("MA GVQL");
		lblNgS.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNgS.setBounds(124, 104, 75, 19);
		panelchuyennganh.add(lblNgS);

		textField_maGVQl = new JTextField();
		textField_maGVQl.setColumns(10);
		textField_maGVQl.setBounds(10, 101, 104, 19);
		panelchuyennganh.add(textField_maGVQl);

		JLabel lblMaL = new JLabel("MA KHOA");
		lblMaL.setFont(new Font("Arial", Font.PLAIN, 13));
		lblMaL.setBounds(124, 147, 65, 19);
		panelchuyennganh.add(lblMaL);

		textField_Makhoacn = new JTextField();
		textField_Makhoacn.setColumns(10);
		textField_Makhoacn.setBounds(10, 144, 104, 19);
		panelchuyennganh.add(textField_Makhoacn);

	}

	public void showTextFieldDC() {

		textField_maSVdc = new JTextField();
		textField_maSVdc.setBounds(10, 10, 104, 19);
		paneldiachi.add(textField_maSVdc);
		textField_maSVdc.setColumns(10);

		JLabel LabelMA = new JLabel("MA SV");
		LabelMA.setFont(new Font("Arial", Font.PLAIN, 13));
		LabelMA.setBounds(124, 13, 48, 19);
		paneldiachi.add(LabelMA);

		JLabel lblHoTen = new JLabel("SO NHA");
		lblHoTen.setFont(new Font("Arial", Font.PLAIN, 13));
		lblHoTen.setBounds(124, 58, 48, 19);
		paneldiachi.add(lblHoTen);

		textField_soNha = new JTextField();
		textField_soNha.setColumns(10);
		textField_soNha.setBounds(10, 55, 104, 19);
		paneldiachi.add(textField_soNha);

		JLabel lblNgS = new JLabel("DUONG");
		lblNgS.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNgS.setBounds(124, 104, 67, 19);
		paneldiachi.add(lblNgS);

		textField_Duong = new JTextField();
		textField_Duong.setColumns(10);
		textField_Duong.setBounds(10, 101, 104, 19);
		paneldiachi.add(textField_Duong);
		textField_Duong.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblMaL = new JLabel("QUAN");
		lblMaL.setFont(new Font("Arial", Font.PLAIN, 13));
		lblMaL.setBounds(124, 147, 48, 19);
		paneldiachi.add(lblMaL);

		textField_Quan = new JTextField();
		textField_Quan.setColumns(10);
		textField_Quan.setBounds(10, 144, 104, 19);
		paneldiachi.add(textField_Quan);

		JLabel lblNgS_1 = new JLabel("THANH PHO");
		lblNgS_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNgS_1.setBounds(124, 196, 75, 19);
		paneldiachi.add(lblNgS_1);

		textField_Thanhpho = new JTextField();
		textField_Thanhpho.setColumns(10);
		textField_Thanhpho.setBounds(10, 191, 104, 19);
		paneldiachi.add(textField_Thanhpho);

	}

	public void showTextFieldKhoa() {

		textField_Makhoa = new JTextField();
		textField_Makhoa.setBounds(10, 10, 104, 19);
		panelkhoa.add(textField_Makhoa);
		textField_Makhoa.setColumns(10);

		JLabel LabelMA = new JLabel("MA KHOA");
		LabelMA.setFont(new Font("Arial", Font.PLAIN, 13));
		LabelMA.setBounds(124, 13, 60, 19);
		panelkhoa.add(LabelMA);

		JLabel lblHoTen = new JLabel("TEN KHOA");
		lblHoTen.setFont(new Font("Arial", Font.PLAIN, 13));
		lblHoTen.setBounds(124, 58, 75, 19);
		panelkhoa.add(lblHoTen);

		textField_tenKhoa = new JTextField();
		textField_tenKhoa.setColumns(10);
		textField_tenKhoa.setBounds(10, 55, 104, 19);
		panelkhoa.add(textField_tenKhoa);
		textField_tenKhoa.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblNgS = new JLabel("NAMTL");
		lblNgS.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNgS.setBounds(124, 104, 67, 19);
		panelkhoa.add(lblNgS);

		textField_namTL = new JTextField();
		textField_namTL.setColumns(10);
		textField_namTL.setBounds(10, 101, 104, 19);
		panelkhoa.add(textField_namTL);

		JLabel lblMaL = new JLabel("PHONG LV");
		lblMaL.setFont(new Font("Arial", Font.PLAIN, 13));
		lblMaL.setBounds(124, 147, 75, 19);
		panelkhoa.add(lblMaL);

		textField_phongLv = new JTextField();
		textField_phongLv.setColumns(10);
		textField_phongLv.setBounds(10, 144, 104, 19);
		panelkhoa.add(textField_phongLv);

		JLabel lblNgS_1 = new JLabel("TEL");
		lblNgS_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNgS_1.setBounds(124, 196, 48, 19);
		panelkhoa.add(lblNgS_1);

		textField_Tel = new JTextField();
		textField_Tel.setColumns(10);
		textField_Tel.setBounds(10, 191, 104, 19);
		panelkhoa.add(textField_Tel);

		textField_MatrgKhoa = new JTextField();
		textField_MatrgKhoa.setColumns(10);
		textField_MatrgKhoa.setBounds(203, 11, 104, 19);
		panelkhoa.add(textField_MatrgKhoa);

		JLabel lblNgS_2 = new JLabel("MA TRGKHOA");
		lblNgS_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNgS_2.setBounds(317, 14, 100, 19);
		panelkhoa.add(lblNgS_2);

	}

	public void showTextFieldSinhVien() {

		FieldMa = new JTextField();
		FieldMa.setBounds(10, 10, 104, 19);
		panelSV.add(FieldMa);
		FieldMa.setColumns(10);

		JLabel LabelMA = new JLabel("MA SV");
		LabelMA.setFont(new Font("Arial", Font.PLAIN, 13));
		LabelMA.setBounds(124, 13, 48, 19);
		panelSV.add(LabelMA);

		JLabel lblHoTen = new JLabel("Ho Ten");
		lblHoTen.setFont(new Font("Arial", Font.PLAIN, 13));
		lblHoTen.setBounds(124, 58, 48, 19);
		panelSV.add(lblHoTen);

		Field_HoTen = new JTextField();
		Field_HoTen.setColumns(10);
		Field_HoTen.setBounds(10, 55, 104, 19);
		panelSV.add(Field_HoTen);
		Field_HoTen.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblNgS = new JLabel("Ngày Sinh");
		lblNgS.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNgS.setBounds(124, 104, 67, 19);
		panelSV.add(lblNgS);

		textFieldNgSinh = new JTextField();
		textFieldNgSinh.setColumns(10);
		textFieldNgSinh.setBounds(10, 101, 104, 19);
		panelSV.add(textFieldNgSinh);

		JLabel lblMaL = new JLabel("Mã Lớp");
		lblMaL.setFont(new Font("Arial", Font.PLAIN, 13));
		lblMaL.setBounds(124, 194, 48, 19);
		panelSV.add(lblMaL);

		textField_MaL = new JTextField();
		textField_MaL.setColumns(10);
		textField_MaL.setBounds(10, 191, 104, 19);
		panelSV.add(textField_MaL);

		RadioButtonNam = new JRadioButton("Nam");
		RadioButtonNam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		RadioButtonNam.setBounds(6, 145, 51, 21);
		panelSV.add(RadioButtonNam);

		radioNu = new JRadioButton("Nữ");
		radioNu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioNu.setBounds(73, 146, 51, 21);
		panelSV.add(radioNu);

		RadioButtonNam.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {

					radioNu.setSelected(false);
				}
			}
		});

		radioNu.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {

					RadioButtonNam.setSelected(false);
				}
			}
		});

	}

    
    private static boolean containsLetter(String str) {
        return Pattern.compile("[a-zA-Z]").matcher(str).find();
    }

	public void dangNhap() {

		contentPane.removeAll();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1122, 523);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 162, 1088, 22);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 384, 1088, 22);
		contentPane.add(separator_1);

		buttonThem = new JButton("Insert");
		buttonThem.setBounds(20, 416, 106, 41);
		buttonThem.setFont(new Font("Arial Black", Font.BOLD, 14));
		 buttonThem.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            String text = textNhap.getText();
		            if (text.equalsIgnoreCase("select * from sinhvien")
		                    || text.equals("SELECT * FROM quanlythongtinsinhvien.sinhvien;")) {	
		            	
		                    ArrayList<String> svss = new Sukien().getListMAL();
		                    String textxx = FieldMa.getText();
			                String textx = textField_MaL.getText();			                			                
			                int row = table_1.getRowCount();
			                
			                ArrayList<String> listmacn = new ArrayList<String>();     
			                for (int i = 0; i < row; i++) {
			                    String masv = table_1.getValueAt(i, 0).toString();
			                    listmacn.add(masv);
			                }
			              
			                if (svss.contains(textx)) {	                   
			                    if (listmacn.contains(textxx)) {
			                        JOptionPane.showMessageDialog(contentPane, "MaSV đã tồn tại!", "Thông Báo!",
			                        JOptionPane.ERROR_MESSAGE);
			                        table_1.clearSelection();

			                    } else {
			                    	 SinhVien sv = new SinhVien();
					                    sv.setMaSV(FieldMa.getText());
					                    sv.setHoTen(Field_HoTen.getText().toUpperCase());
					                    String ngaySinhText = textFieldNgSinh.getText();
					                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					                    try {
					                        java.util.Date parsedDate = dateFormat.parse(ngaySinhText);
					                        Date ngaySinhAsDate = new Date(parsedDate.getTime());
					                        sv.setNgSinh(ngaySinhAsDate);
					                    } catch (ParseException e1) {
					                        JOptionPane.showMessageDialog(contentPane, "Ngày Sinh không hợp lệ: yyyy-MM-dd", "Thông Báo!",
					                        JOptionPane.ERROR_MESSAGE);
					                    }
					                    String gioiTinh = "";
					                    if (RadioButtonNam.isSelected()) {
					                        gioiTinh = RadioButtonNam.getText().toUpperCase();
					                    } else if (radioNu.isSelected()) {
					                        gioiTinh = radioNu.getText().toUpperCase();
					                    }
					                    String mal = textField_MaL.getText().toUpperCase();
					                    
					                    sv.setGioiTinh(gioiTinh);
					                    sv.setMaLop(mal);
					                    new Sukien().Insert(sv);
					                    showSV();			            
					                
			                    }
			                } else {
			                    JOptionPane.showMessageDialog(contentPane, "MaL chưa tồn tại bên bảng LOP!", "Thông Báo!",
			                            JOptionPane.ERROR_MESSAGE);
			                    table_1.clearSelection();

			                }		            	          	
		                

		            } else if (text.equalsIgnoreCase("select * from diemthi")
		                    || text.equalsIgnoreCase("SELECT * FROM quanlythongtinsinhvien.diemthi;")) {

		            	    ArrayList<String> svss = new Sukien().getListMASV();
			                String textx = textField_maSVdiem.getText();
			                String textxx = textField_maMTdiem.getText();
			                
			                int row = table_1.getRowCount();
			                ArrayList<String> listmacn = new Sukien().selecALLMAMonThi();     		               
			                ArrayList<String> listmasv = new ArrayList<String>();	
			                ArrayList<String> listmasv1 = new ArrayList<String>();	
			                
			                for (int i = 0; i < row; i++) {
			                    String masvs = table_1.getValueAt(i, 0).toString();
			                    listmasv.add(masvs);
			                }
			                for (int i = 0; i < row; i++) {
			                    String masv = table_1.getValueAt(i, 1).toString();
			                    listmasv1.add(masv);
			                }
			                
			                if (svss.contains(textx)) {	                   
			                    if (listmacn.contains(textxx)) {	
			                    	boolean exists = false;
			                    	for (int i = 0; i < listmasv.size(); i++) {
			                    	    if (listmasv.get(i).equals(textx) && listmasv1.get(i).equals(textxx)) {
			                    	        exists = true;
			                    	        break;
			                    	    }
			                    	}
			                    	if (exists) {
			                        	
			                        	JOptionPane.showMessageDialog(contentPane, "MaMT đã tồn tại!", "Thông Báo!",
				                                JOptionPane.ERROR_MESSAGE);
				                               table_1.clearSelection();
			                        }else {
			                        	DiemThi d = new DiemThi();
				                        d.setMaSV(textField_maSVdiem.getText());
				                        d.setMaMT(textField_maMTdiem.getText());
				                        String DiemText = textField_Diem.getText();
				                        Float diemFloat = Float.parseFloat(DiemText);
				                        d.setDiem(diemFloat.floatValue());
				                        String ghiChu = textField_ghichu.getText().toUpperCase();
				                        d.setGhiChu(ghiChu);
				                        new Sukien().Insert(d);
				                        showDiemThi();
			                        }

			                    } else {
			                    	JOptionPane.showMessageDialog(contentPane, "MaMT chưa tồn tại bên bảng MONTHI!", "Thông Báo!",
			                                JOptionPane.ERROR_MESSAGE);
			                               table_1.clearSelection();
			                    }
			                }
			                 else {
			                    JOptionPane.showMessageDialog(contentPane, "MaSV chưa tồn tại bên bảng SinhVien!", "Thông Báo!",
			                            JOptionPane.ERROR_MESSAGE);
			                    table_1.clearSelection();

			                }		            	          		              		       		    

		            } else if (text.equalsIgnoreCase("select * from thi")
		                    || text.equalsIgnoreCase("SELECT * FROM quanlythongtinsinhvien.thi;")) {

		                ArrayList<String> svs = new Sukien().selecALLMAMonThi();
		                ArrayList<String> svss = new Sukien().getListMACN();
		                String textx = textField_MT.getText();
		                String textxx = textField_maCN.getText();
		                
		                int row = table_1.getRowCount();
		                ArrayList<String> listmacn = new ArrayList<String>();     
		                for (int i = 0; i < row; i++) {
		                    String masv = table_1.getValueAt(i, 1).toString();
		                    listmacn.add(masv);
		                }
		                ArrayList<String> listmasv = new ArrayList<String>();
		              
		                for (int i = 0; i < row; i++) {
		                    String masv = table_1.getValueAt(i, 0).toString();
		                    listmasv.add(masv);
		                }
		                if (svs.contains(textx) && svss.contains(textxx)) {	                   
		                    if (listmacn.contains(textxx) && listmasv.contains(textx)) {
		                        JOptionPane.showMessageDialog(contentPane, "MaMT đã tồn tại!", "Thông Báo!",
		                                JOptionPane.ERROR_MESSAGE);
		                               table_1.clearSelection();

		                    } else {
		                       
		                        Thi d = new Thi();
		                        d.setMaMT(textField_MT.getText().toUpperCase());
		                        d.setMaCN(textField_maCN.getText().toUpperCase());
		                        new Sukien().Insert(d);
		                        showThi();
		                    }
		                } else {
		                    JOptionPane.showMessageDialog(contentPane, "MaMT chưa tồn tại bên bảng MonThi! hoặc MACN không tồn tại ở bảng CHUYENNGANH", "Thông Báo!",
		                            JOptionPane.ERROR_MESSAGE);
		                    table_1.clearSelection();

		                }

		            }

		            else if (text.equalsIgnoreCase("select * from monthi")
		                    || text.equalsIgnoreCase("SELECT * FROM quanlythongtinsinhvien.monthi;")) {

		                ArrayList<String> listmasvs = new ArrayList<String>();
		                int rowa = table_1.getRowCount();
		                for (int i = 0; i < rowa; i++) {
		                    String masva = table_1.getValueAt(i, 0).toString();
		                    listmasvs.add(masva);
		                }
		            
		                if (listmasvs.contains(textField_MAMT.getText())) {
		                    JOptionPane.showMessageDialog(contentPane, "MaMT đã tồn tại!", "Thông Báo!",
		                            JOptionPane.ERROR_MESSAGE);
		                    table_1.clearSelection();

		                } else {

		                    MonThi d = new MonThi();
		                    d.setMaMT(textField_MAMT.getText().toUpperCase());
		                    d.setTenMT(textField_teMT.getText().toUpperCase());
		                    new Sukien().Insert(d);
		                    showMonThi();
		                }

		            } else if (text.equalsIgnoreCase("select * from lop")
		                    || text.equalsIgnoreCase("SELECT * FROM quanlythongtinsinhvien.lop;")) {
		            	 ArrayList<String> listmasv = new ArrayList<String>();
		            	 ArrayList<String> listmacn = new Sukien().getListMACN();
		            	 
			                int row = table_1.getRowCount();
			                for (int i = 0; i < row; i++) {
			                    String masv = table_1.getValueAt(i, 0).toString();
			                    listmasv.add(masv);
			                }

			                if(listmacn.contains(textField_MaCN.getText())) {
			                	String input = textField_SiSo.getText();
			                	if(!containsLetter(input)) {
			                		if (listmasv.contains(textField_MaLop.getText())) {
			                			JOptionPane.showMessageDialog(contentPane, "MaL đã tồn tại!", "Thông Báo!",
					                            JOptionPane.ERROR_MESSAGE);
					                    table_1.clearSelection();}
			                		else {
			              
			                	
		                     Lop d = new Lop();
		                   d.setMaL(textField_MaLop.getText().toUpperCase());
		                   String siso = textField_SiSo.getText();
		                  byte ss = Byte.parseByte(siso);
		                   d.setSiSo(ss);
		                    d.setMaCN(textField_MaCN.getText().toUpperCase());
		                   new Sukien().Insert(d);
		                   showLop();   
			                }
			                	}else {
			                		JOptionPane.showMessageDialog(contentPane, "SiSO không đúng, phải là số!", "Thông Báo!",
				                            JOptionPane.ERROR_MESSAGE);
				                    table_1.clearSelection();}
			                	
			                	}else {
			                	JOptionPane.showMessageDialog(contentPane, "MaCN chưa tồn tại ở bảng CHUYENNGANH!", "Thông Báo!",
			                            JOptionPane.ERROR_MESSAGE);
			                    table_1.clearSelection();
			                }

		            } else if (text.equalsIgnoreCase("select * from khoa")
		                    || text.equalsIgnoreCase("SELECT * FROM quanlythongtinsinhvien.khoa;")) {

		            	ArrayList<String> listmasv = new ArrayList<String>();
		                int row = table_1.getRowCount();
		                for (int i = 0; i < row; i++) {
		                    String masv = table_1.getValueAt(i, 0).toString();
		                    listmasv.add(masv);
		                }

		                if (listmasv.contains(textField_Makhoa.getText())) {
		                    JOptionPane.showMessageDialog(contentPane, "MaKhoa đã tồn tại!", "Thông Báo!",
		                            JOptionPane.ERROR_MESSAGE);
		                } else {
		                Khoa d = new Khoa();
		                d.setMaKhoa(textField_Makhoa.getText().toUpperCase());
		                d.setTenKhoa(textField_tenKhoa.getText().toUpperCase());
		                String ngaySinhText = textField_namTL.getText();
		                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		                try {
		                    java.util.Date parsedDate = dateFormat.parse(ngaySinhText);
		                    Date ngaySinhAsDate = new Date(parsedDate.getTime());
		                    d.setNamTL(ngaySinhAsDate);
		                } catch (ParseException e1) {
		                    JOptionPane.showMessageDialog(contentPane, "Ngày Sinh không hợp lệ: yyyy-MM-dd", "Thông Báo!",
		                            JOptionPane.ERROR_MESSAGE);
		                }
		                d.setPhongLV(textField_phongLv.getText().toUpperCase());
		                d.setTel(textField_Tel.getText());
		                d.setMaTrgKhoal(textField_MatrgKhoa.getText().toUpperCase());
		                new Sukien().Insert(d);
		                showKhoa();
		                }
		            } else if (text.equalsIgnoreCase("select * from giangvien")
		                    || text.equalsIgnoreCase("SELECT * FROM quanlythongtinsinhvien.giangvien;")) {
		            	ArrayList<String> listmasv = new ArrayList<String>();
		                int row = table_1.getRowCount();
		                for (int i = 0; i < row; i++) {
		                    String masv = table_1.getValueAt(i, 0).toString();
		                    listmasv.add(masv);
		                }		                
		                    ArrayList<String> svss = new Sukien().getListMAKHOA();
			                String textx = textField_Makhoagv.getText();
			               
			                			               
			                
			                if (svss.contains(textx)){	                   	                    
			                    	String input = textField_soDt.getText();
				                	if(!containsLetter(input)) {
				                		if(listmasv.contains(textField_maGV.getText())) {
						                	JOptionPane.showMessageDialog(contentPane, "MAGV đã tồn tại!", "Thông Báo!",
						                            JOptionPane.ERROR_MESSAGE);}
				                		else {
				                			  GiangVien d = new GiangVien();
				      		                d.setMaGV(textField_maGV.getText().toUpperCase());
				      		                d.setTenGV(textField_tenGv.getText().toUpperCase());
				      		                d.setSoDT(textField_soDT.getText());
				      		                d.setMaKhoa(textField_Makhoagv.getText().toUpperCase());
				      		               new Sukien().Insert(d);
				      		                    showGV();
				      		                    
				                		
				                	}
				                	}else{
				                		JOptionPane.showMessageDialog(contentPane, "SODT không đúng, phải là số!", "Thông Báo!",
					                            JOptionPane.ERROR_MESSAGE);
				                	}
			                    }else {
			                    	JOptionPane.showMessageDialog(contentPane, "MAKHOA không tồn tại trong bảng KHOA!", "Thông Báo!",
				                            JOptionPane.ERROR_MESSAGE);
			                    }
		                
		                

		            } else if (text.equalsIgnoreCase("select * from dienthoai")
		                    || text.equalsIgnoreCase("SELECT * FROM quanlythongtinsinhvien.dienthoai;")) {
		            	
		            	    ArrayList<String> svss = new Sukien().getListMASV();
			                String textx = textField_MASVdt.getText();
			                String textxx = textField_soDt.getText();
			             
			                
			                int row = table_1.getRowCount();			                
			                ArrayList<String> listmacn = new ArrayList<String>();   			                 			                
			                for (int i = 0; i < row; i++) {
			                    String masv = table_1.getValueAt(i, 1).toString();
			                    listmacn.add(masv);
			                }
			                
			                if (svss.contains(textx)){	                   	                    
			                    	String input = textField_soDt.getText();
				                	if(!containsLetter(input)) {
				                		if(listmacn.contains(textxx)) {
						                	JOptionPane.showMessageDialog(contentPane, "SODT đã tồn tại!", "Thông Báo!",
						                            JOptionPane.ERROR_MESSAGE);}
				                		else {
				                		DienThoai d = new DienThoai();		            
				                		d.setMaSV(textField_MASVdt.getText());
				                		d.setSoDT(textField_soDt.getText());
				                		new Sukien().Insert(d);
				                		showDT();}
				                		
				                	}else{
				                		JOptionPane.showMessageDialog(contentPane, "SODT không đúng, phải là số!", "Thông Báo!",
					                            JOptionPane.ERROR_MESSAGE);
				                	}
			                    }else {
			                    	JOptionPane.showMessageDialog(contentPane, "MASV không tồn tại trong bảng SINHVIEN!", "Thông Báo!",
				                            JOptionPane.ERROR_MESSAGE);
			                    }
		                
		                
		            } else if (text.equalsIgnoreCase("select * from diachi")
		                    || text.equalsIgnoreCase("SELECT * FROM quanlythongtinsinhvien.diachi;")) {
		            	    ArrayList<String> svss = new Sukien().getListMASV();
			                String textx = textField_maSVdc.getText();
			                
			                ArrayList<String> listmasv = new ArrayList<String>();         
			                int row = table_1.getRowCount();
			                for (int i = 0; i < row; i++) {
			                    String masv = table_1.getValueAt(i, 0).toString();
			                    listmasv.add(masv);
			                }
			                                  			              
			                if (svss.contains(textx)) {	 
			                	if (listmasv.contains(textx)){
			                        JOptionPane.showMessageDialog(contentPane, "MaSV đã tồn tại!", "Thông Báo!",
			                                JOptionPane.ERROR_MESSAGE);
			                        table_1.clearSelection();}
			                	else {
			                   DiaChi d = new DiaChi();
			                  d.setMaSV(textField_maSVdc.getText());
			                  d.setSoNha(textField_soNha.getText().toUpperCase());
			                  d.setDuong(textField_Duong.getText().toUpperCase());
			                  d.setQuan(textField_Quan.getText().toUpperCase());
			                  d.setThanhPho(textField_Thanhpho.getText().toUpperCase());			                       				          				                
			                    new Sukien().Insert(d);
			                    showDC();			                       				                		                
			                   table_1.clearSelection();
			                        }
			                    
			                } else {
			                    JOptionPane.showMessageDialog(contentPane, "MaSV chưa tồn tại bên bảng SinhVien!", "Thông Báo!",
			                            JOptionPane.ERROR_MESSAGE);
			                    table_1.clearSelection();

			                }	
		        
		        
		            
		                
		                

		            } else if (text.equalsIgnoreCase("select * from chuyennganh")
		                    || text.equalsIgnoreCase("SELECT * FROM quanlythongtinsinhvien.chuyennganh;")) {
		            	ArrayList<String> listmasv = new ArrayList<String>();
		            	
		                int row = table_1.getRowCount();
		                for (int i = 0; i < row; i++) {
		                    String masv = table_1.getValueAt(i, 0).toString();
		                    listmasv.add(masv);
		                }	               
		                    ArrayList<String> svss = new Sukien().getListMAKHOA();
			                String textx = textField_Makhoacn.getText();
			               		              
			                
			                                  			              
			                if (svss.contains(textx)) {	 
			                	 if (listmasv.contains(textField_maCNchuyennganh.getText())) {
					                    JOptionPane.showMessageDialog(contentPane, "MACN đã tồn tại!", "Thông Báo!",
					                            JOptionPane.ERROR_MESSAGE);
					                    table_1.clearSelection();

					                } 
			                	else {
			                		ChuyenNganh d = new ChuyenNganh();
					                d.setMaCN(textField_maCNchuyennganh.getText().toUpperCase());
					                d.setTenCN(textField_TenCn.getText().toUpperCase());

					                d.setMaGVCN(textField_maGVQl.getText().toUpperCase());

					                d.setMaKhoa(textField_Makhoacn.getText().toUpperCase());
					              
					               
					                    new Sukien().Insert(d);
					                    showCN();
					                    table_1.clearSelection();
			                        }
			                    
			                } else {
			                    JOptionPane.showMessageDialog(contentPane, "MAKHOA chưa tồn tại bên bảng KHOA!", "Thông Báo!",
			                            JOptionPane.ERROR_MESSAGE);
			                    table_1.clearSelection();

			                }
		        
		        
		                
		            }else {
		            	JOptionPane.showMessageDialog(contentPane, "Chưa Có đối tượng để thêm!", "Thông Báo!",
	                            JOptionPane.ERROR_MESSAGE);
		            }
		            resetTextFields();
		      
		        }
		    });contentPane.add(buttonThem);

	textNhap=new JTextField();textNhap.setBounds(725,416,248,41);contentPane.add(textNhap);

	btnUpdate=new JButton("Update");btnUpdate.setBounds(163,416,106,41);btnUpdate.setFont(new Font("Arial Black",Font.BOLD,14));contentPane.add(btnUpdate);
	btnUpdate.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			   String text = textNhap.getText();
	            if (text.equalsIgnoreCase("select * from sinhvien")
	                    || text.equals("SELECT * FROM quanlythongtinsinhvien.sinhvien;")) {	
	            	
	                    ArrayList<String> svss = new Sukien().getListMAL();	                   
		                String textx = textField_MaL.getText();			                			                		              		              		              	              
		                                  
		                	int row = table_1.getSelectedRow();							
							if (row >= 0) {		
								System.out.println("svss: " + svss);
								System.out.println("textx: " + textx);
								 if (svss.contains(textx)) {	
								String maSVs = table_1.getValueAt(row, 0).toString();
								String hoTen = Field_HoTen.getText();
								String NgSinh = textFieldNgSinh.getText();
								Date ngaySinhAsDate = null;

								SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
								try {
									java.util.Date parsedDate = dateFormat.parse(NgSinh);
									ngaySinhAsDate = new Date(parsedDate.getTime());
								} catch (ParseException e1) {
									JOptionPane.showMessageDialog(contentPane, "Ngày Sinh không hợp lệ: yyyy-MM-dd",
											"Thông Báo!", JOptionPane.ERROR_MESSAGE);
								}
								String gioiTinh = "";
								if (RadioButtonNam.isSelected()) {
									gioiTinh = RadioButtonNam.getText();
								} else if (radioNu.isSelected()) {
									gioiTinh = radioNu.getText();
								}
								String maLop = textField_MaL.getText();
								System.out.println(maLop);
								SinhVien sv = new SinhVien();
								sv.setMaSV(maSVs);
								sv.setHoTen(hoTen);
								sv.setNgSinh(ngaySinhAsDate);
								sv.setGioiTinh(gioiTinh);
								sv.setMaLop(maLop);
								new Sukien().Uppdate(sv);						
								showSV();
							}else {
			                    JOptionPane.showMessageDialog(contentPane, "MaL chưa tồn tại bên bảng LOP để update!", "Thông Báo!",
			                            JOptionPane.ERROR_MESSAGE);
			                    table_1.clearSelection();

			                }	
		                } 	            	          	
	                

	            } else if (text.equalsIgnoreCase("select * from diemthi")
	                    || text.equalsIgnoreCase("SELECT * FROM quanlythongtinsinhvien.diemthi;")) {

	            	int row = table_1.getSelectedRow();
					if (row >= 0) {
						String maSV = table_1.getValueAt(row, 0).toString();
						String mamt = table_1.getValueAt(row, 1).toString();
						String DiemText = textField_Diem.getText();
						Float diemFloat = Float.parseFloat(DiemText);

						DiemThi sv = new DiemThi();
						String ghiChu = textField_ghichu.getText();
						sv.setDiem(diemFloat);
						sv.setMaSV(maSV);
						sv.setMaMT(mamt);
						sv.setGhiChu(ghiChu);
						new Sukien().Uppdate(sv);
						showDiemThi();
		                        	          		              		       		    
					}
	            } else if (text.equalsIgnoreCase("select * from thi")
	                    || text.equalsIgnoreCase("SELECT * FROM quanlythongtinsinhvien.thi;")) {

	            	String textx = textField_MT.getText();
	            	String textxx = textField_maCN.getText();
	           
		                ArrayList<String> svss = new Sukien().getListMACN();
		            	int rowww = table_1.getSelectedRow();	
		            	
		                int row = table_1.getRowCount();
		                ArrayList<String> listmacn = new ArrayList<String>();     
		                for (int i = 0; i < row; i++) {
		                    String masv = table_1.getValueAt(i, 1).toString();
		                    listmacn.add(masv);
		                }
		                ArrayList<String> listmasv = new ArrayList<String>();
		              
		                for (int i = 0; i < row; i++) {
		                    String masv = table_1.getValueAt(i, 0).toString();
		                    listmasv.add(masv);
		                }
		                if (svss.contains(textxx)) {	   
		                	
		                    if (listmacn.contains(textxx) && listmasv.contains(textx)) {
		                        JOptionPane.showMessageDialog(contentPane, "MaMT và MACN đã tồn tại!", "Thông Báo!",
		                                JOptionPane.ERROR_MESSAGE);
		                               table_1.clearSelection();

		                    } else {
		                       
		                    	String maSV = table_1.getValueAt(rowww, 0).toString();
		                        String maSV1 = textField_maCN.getText();
		                        Thi d = new Thi();
		                        d.setMaMT(maSV);
		                        d.setMaCN(maSV1);
		                        new Sukien().Uppdate(d);
		                        showThi();
		                    }
		                } else {
		                    JOptionPane.showMessageDialog(contentPane, "MACN không tồn tại ở bảng CHUYENNGANH", "Thông Báo!",
		                            JOptionPane.ERROR_MESSAGE);
		                    table_1.clearSelection();

		                }
	                        
	                    
	               

	            }
	            

	            else if (text.equalsIgnoreCase("select * from monthi")
	                    || text.equalsIgnoreCase("SELECT * FROM quanlythongtinsinhvien.monthi;")) {

	               
	            	int row = table_1.getSelectedRow();
					if (row >= 0) {
						String maSV = table_1.getValueAt(row, 0).toString();
						String DiemText = textField_teMT.getText();

						MonThi sv = new MonThi();
						sv.setMaMT(maSV);
						sv.setTenMT(DiemText);
						new Sukien().Uppdate(sv);
						showMonThi();
					}

	            } else if (text.equalsIgnoreCase("select * from lop")
	                    || text.equalsIgnoreCase("SELECT * FROM quanlythongtinsinhvien.lop;")) {
	            	 ArrayList<String> listmasv = new ArrayList<String>();
	            	 ArrayList<String> listmacn = new Sukien().getListMACN();
	            	 
		                int row = table_1.getRowCount();
		                for (int i = 0; i < row; i++) {
		                    String masv = table_1.getValueAt(i, 0).toString();
		                    listmasv.add(masv);
		                }

		                if(listmacn.contains(textField_MaCN.getText())) {
		                	String input = textField_SiSo.getText().trim();
		                	if(!containsLetter(input)) {		               		                	
		                			int roww = table_1.getSelectedRow();
		            				if (roww >= 0) {
		            					String maSV = table_1.getValueAt(roww, 0).toString();

		            					String Text = textField_MaCN.getText();

		            					Lop sv = new Lop();
		            					sv.setMaL(maSV);
		            					String siso = textField_SiSo.getText();
		            					byte ss = Byte.parseByte(siso);
		            					sv.setSiSo(ss);
		            					sv.setMaCN(Text);

		            					new Sukien().Uppdate(sv);
		            					showLop();
		            				}
		                
		                	}else {
		                		JOptionPane.showMessageDialog(contentPane, "SiSO không đúng, phải là số!", "Thông Báo!",
			                            JOptionPane.ERROR_MESSAGE);
			                    table_1.clearSelection();}
		                	
		                	}else {
		                	JOptionPane.showMessageDialog(contentPane, "MaCN chưa tồn tại ở bảng CHUYENNGANH!", "Thông Báo!",
		                            JOptionPane.ERROR_MESSAGE);
		                    table_1.clearSelection();
		                }

	            } else if (text.equalsIgnoreCase("select * from khoa")
	                    || text.equalsIgnoreCase("SELECT * FROM quanlythongtinsinhvien.khoa;")) {

	            	ArrayList<String> listmasv = new Sukien().selecMAGV();
	               
	                if (listmasv.contains(textField_MatrgKhoa.getText())) {
	                   
	                    int roww = table_1.getSelectedRow();
	                    if (roww >= 0) {
	                    	String maSV = table_1.getValueAt(roww, 0).toString();
	                    	Khoa d = new Khoa();
	                    	d.setMaKhoa(maSV);
	                    	d.setTenKhoa(textField_tenKhoa.getText());
	                    	String ngaySinhText = textField_namTL.getText();
	                    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	                    	try {
	                    		java.util.Date parsedDate = dateFormat.parse(ngaySinhText);
	                    		Date ngaySinhAsDate = new Date(parsedDate.getTime());
	                    		d.setNamTL(ngaySinhAsDate);
	                    	} catch (ParseException e1) {
	                    		JOptionPane.showMessageDialog(contentPane, "Ngày Sinh không hợp lệ: yyyy-MM-dd", "Thông Báo!",
	                    				JOptionPane.ERROR_MESSAGE);
	                    	}
	                    	d.setPhongLV(textField_phongLv.getText());
	                    	d.setTel(textField_Tel.getText());
	                    	d.setMaTrgKhoal(textField_MatrgKhoa.getText());
	                    	new Sukien().Uppdate(d);
	                    	showKhoa();
	                }
	                }else {
	                	 JOptionPane.showMessageDialog(contentPane, "MaTrgKhoa chưa tồn tại trong bảng GIAOVIEN!", "Thông Báo!",
		                            JOptionPane.ERROR_MESSAGE);
	                
	                }
	            } else if (text.equalsIgnoreCase("select * from giangvien")
	                    || text.equalsIgnoreCase("SELECT * FROM quanlythongtinsinhvien.giangvien;")) {
	            	
	                                
	                    ArrayList<String> svss = new Sukien().getListMAKHOA();
		                String textx = textField_Makhoagv.getText();
		               
		                			               
		                
		                if (svss.contains(textx)){	                            
		                    	
			                	if(!containsLetter(textField_soDT.getText().trim())) {		                	
			                		int row = table_1.getSelectedRow();
			        				if (row >= 0) {
			        					String maSV = table_1.getValueAt(row, 0).toString();
			        					String mamt = textField_tenGv.getText();
			        					String DiemText = textField_soDT.getText();
			        					GiangVien sv = new GiangVien();
			        					String ghiChu = textField_Makhoagv.getText();
			        					sv.setMaGV(maSV);
			        					sv.setTenGV(mamt);
			        					sv.setSoDT(DiemText);
			        					sv.setMaKhoa(ghiChu);
			        					new Sukien().Uppdate(sv);
			        					showGV();		}	      		                    			                		
			                	
			                	}else{
			                		JOptionPane.showMessageDialog(contentPane, "SODT không đúng, phải là số!", "Thông Báo!",
				                            JOptionPane.ERROR_MESSAGE);
			                	}
		                    }else {
		                    	JOptionPane.showMessageDialog(contentPane, "MAKHOA không tồn tại trong bảng KHOA!", "Thông Báo!",
			                            JOptionPane.ERROR_MESSAGE);
		                    }
	                
		                

	            } else if (text.equalsIgnoreCase("select * from dienthoai")
	                    || text.equalsIgnoreCase("SELECT * FROM quanlythongtinsinhvien.dienthoai;")) {
	            	
	            	
		              ;
		                String textxx = textField_soDt.getText();
		             
		                
		                int row = table_1.getRowCount();			                
		                ArrayList<String> listmacn = new ArrayList<String>();   			                 			                
		                for (int i = 0; i < row; i++) {
		                    String masv = table_1.getValueAt(i, 1).toString();
		                    listmacn.add(masv);
		                }		                	                    
		                    	String input = textField_soDt.getText();
			                	if(!containsLetter(input)) {
			                		if(listmacn.contains(textxx)) {
					                	JOptionPane.showMessageDialog(contentPane, "SODT đã tồn tại!", "Thông Báo!",
					                            JOptionPane.ERROR_MESSAGE);}
			                		else {
			                			int roww = table_1.getSelectedRow();
			            				if (row >= 0) {
			            					String maSV = table_1.getValueAt(roww, 0).toString();
			            					String mamt = textField_soDt.getText();
			            					DienThoai sv = new DienThoai();

			            					sv.setMaSV(maSV);
			            					sv.setSoDT(mamt);

			            					new Sukien().Uppdate(sv);
			            					showDT();}
			                		}
			                		
			                	}else{
			                		JOptionPane.showMessageDialog(contentPane, "SODT không đúng, phải là số!", "Thông Báo!",
				                            JOptionPane.ERROR_MESSAGE);
			                	
		                    }
	                
	                
	            } else if (text.equalsIgnoreCase("select * from diachi")
	                    || text.equalsIgnoreCase("SELECT * FROM quanlythongtinsinhvien.diachi;")) {
	            	int row = table_1.getSelectedRow();
					if (row >= 0) {
						String maSV = table_1.getValueAt(row, 0).toString();
						DiaChi d = new DiaChi();
						d.setMaSV(maSV);
						d.setSoNha(textField_soNha.getText());
						d.setDuong(textField_Duong.getText());

						d.setQuan(textField_Quan.getText());
						d.setThanhPho(textField_Thanhpho.getText());
						new Sukien().Uppdate(d);
						showDC();}
	                
	                

	            } else if (text.equalsIgnoreCase("select * from chuyennganh")
	                    || text.equalsIgnoreCase("SELECT * FROM quanlythongtinsinhvien.chuyennganh;")) {	            		            	               
	                    ArrayList<String> svss = new Sukien().getListMAKHOA();
		                String textx = textField_Makhoacn.getText();
		               		              
		                
		                                  			              
		                if (svss.contains(textx)) {	 
		                	
		                	int row = table_1.getSelectedRow();
		    				if (row >= 0) {
		    					String maSV = table_1.getValueAt(row, 0).toString();
		    					String DiemText = textField_maGVQl.getText();

		    					String maLop = textField_TenCn.getText();
		    					ChuyenNganh sv = new ChuyenNganh();
		    					String ghiChu = textField_Makhoacn.getText();
		    					sv.setTenCN(maLop);
		    					sv.setMaCN(maSV);
		    					sv.setMaGVCN(DiemText);
		    					sv.setMaKhoa(ghiChu);
		    					new Sukien().Uppdate(sv);
		    					showCN();
		    				}
		                    
		                } 	 else {
		                    JOptionPane.showMessageDialog(contentPane, "MAKHOA chưa tồn tại bên bảng KHOA!", "Thông Báo!",
		                            JOptionPane.ERROR_MESSAGE);
		                    table_1.clearSelection();

		                }
	        
	        
	                
	            }else {
	            	JOptionPane.showMessageDialog(contentPane, "Chưa Có đối tượng để update", "Thông Báo!",
                           JOptionPane.ERROR_MESSAGE);
	            }
	            resetTextFields();
	      
	        
			
		}
	});

	btnDelete=new JButton("Delete");btnDelete.setBounds(315,416,106,41);btnDelete.setFont(new Font("Arial Black",Font.BOLD,14));contentPane.add(btnDelete);

	JScrollPane scrollPane = new JScrollPane();

	panelSV=new JPanel();panelSV.setBounds(10,162,613,212);panelSV.setLayout(null);panelSV.setBackground(Color.gray);panelSV.setVisible(false);

	panelchuyennganh=new JPanel();panelchuyennganh.setBounds(10,162,613,212);panelchuyennganh.setLayout(null);panelchuyennganh.setBackground(Color.gray);panelchuyennganh.setVisible(false);

	paneldiachi=new JPanel();paneldiachi.setBounds(10,162,613,212);paneldiachi.setLayout(null);paneldiachi.setBackground(Color.gray);paneldiachi.setVisible(false);

	paneldiemthi=new JPanel();paneldiemthi.setBounds(10,162,613,212);paneldiemthi.setLayout(null);paneldiemthi.setBackground(Color.gray);paneldiemthi.setVisible(false);

	paneldienthoai=new JPanel();paneldienthoai.setBounds(10,162,613,212);paneldienthoai.setLayout(null);paneldienthoai.setBackground(Color.gray);paneldienthoai.setVisible(false);

	panelgiangvien=new JPanel();panelgiangvien.setBounds(10,162,613,212);panelgiangvien.setLayout(null);panelgiangvien.setBackground(Color.gray);panelgiangvien.setVisible(false);

	panelkhoa=new JPanel();panelkhoa.setBounds(10,162,613,212);panelkhoa.setLayout(null);panelkhoa.setBackground(Color.gray);panelkhoa.setVisible(false);

	panellop=new JPanel();panellop.setBounds(10,162,613,212);panellop.setLayout(null);panellop.setBackground(Color.gray);panellop.setVisible(false);

	panelmonthi=new JPanel();panelmonthi.setBounds(10,162,613,212);panelmonthi.setLayout(null);panelmonthi.setBackground(Color.gray);panelmonthi.setVisible(false);

	panelthi=new JPanel();panelthi.setBounds(10,162,613,212);panelthi.setLayout(null);panelthi.setBackground(Color.gray);panelthi.setVisible(false);

	showTextFieldSinhVien();

	showTextFieldCN();

	showTextFieldDC();

	showTextFieldDiemThi();

	showTextFieldDT();

	showTextFieldGV();

	showTextFieldKhoa();

	showTextFieldLop();

	showTextFieldMonThi();

	showTextFieldThi();
	    
		contentPane.add(panelSV);
		contentPane.add(panelchuyennganh);
		contentPane.add(paneldiachi);
		contentPane.add(paneldiemthi);
		contentPane.add(paneldienthoai);
		contentPane.add(panelgiangvien);
		contentPane.add(panelkhoa);
		contentPane.add(panellop);
		contentPane.add(panelmonthi);
		contentPane.add(panelthi);
		
		
		
		scrollPane.setBounds(10, 10, 1088, 142);
		contentPane.add(scrollPane);
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		btnTruyVan = new JButton("Truy Vấn");
		btnTruyVan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String inputText = textNhap.getText();
				if (inputText.isEmpty()) {
					JOptionPane.showMessageDialog(contentPane, "Vui lòng nhập câu truy vấn!", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
				} else {
					showdata();
					
				}

			}
		});

		btnTruyVan.setFont(new Font("Arial", Font.BOLD, 12));
		btnTruyVan.setBounds(998, 416, 100, 41);
		contentPane.add(btnTruyVan);
		
		contentPane.revalidate();
		contentPane.repaint();

	}

	public void showSV15001() {

		modelt = (DefaultTableModel) table_1.getModel();
		modelt.setRowCount(0);
		String name[] = { "HOTEN","MAMT","DIEM" };
		modelt.setColumnIdentifiers(name);
		maSV15001 = new Sukien().getDiemAndHoTen();
		for (Object[] sinhVienData : maSV15001) {
			modelt.addRow(sinhVienData);
		}
	}

	public void showgetTrgKhoa() {
		modelt = (DefaultTableModel) table_1.getModel();
		modelt.setRowCount(0);
		String name[] = { "MATRGKHOA" };
		modelt.setColumnIdentifiers(name);
		ArrayList<Object[]> khoaOrChuyenNganhData = new Sukien().getKhoaorChuyenNganh();
		for (Object[] rowData : khoaOrChuyenNganhData) {
			modelt.addRow(rowData);
		}
	}

	public void showGetSinhVienByLop() {
		modelt = (DefaultTableModel) table_1.getModel();
		modelt.setRowCount(0);
		String name[] = { "MAl", "MASV", "HOTEN", "NGSINH", "PHAI", "SISO", "MACN" };
		modelt.setColumnIdentifiers(name);
		ArrayList<Object[]> khoaOrChuyenNganhData = new Sukien().getSinhVienByLop();
		for (Object[] rowData : khoaOrChuyenNganhData) {
			modelt.addRow(rowData);
		}
	}

	public void showGetSiSoMLop() {
		modelt = (DefaultTableModel) table_1.getModel();
		modelt.setRowCount(0);
		String name[] = { "SISO", "MAl" };
		modelt.setColumnIdentifiers(name);
		ArrayList<Object[]> khoaOrChuyenNganhData = new Sukien().getSiSoLop();
		for (Object[] rowData : khoaOrChuyenNganhData) {
			modelt.addRow(rowData);
		}
	}

	public void showGetSiSoLop() {
		modelt = (DefaultTableModel) table_1.getModel();
		modelt.setRowCount(0);
		String name[] = { "MAl", "SISO" };
		modelt.setColumnIdentifiers(name);
		ArrayList<Object[]> khoaOrChuyenNganhData = new Sukien().getMalSiSo();
		for (Object[] rowData : khoaOrChuyenNganhData) {
			modelt.addRow(rowData);
		}
	}

	public void showSiSOTBKhoa() {
		modelt = (DefaultTableModel) table_1.getModel();
		modelt.setRowCount(0);
		String name[] = { "MAKHOA", "SiSO TRUNG BINH" };
		modelt.setColumnIdentifiers(name);
		ArrayList<Object[]> khoaOrChuyenNganhData = new Sukien().getSiSoTBKhoa();
		for (Object[] rowData : khoaOrChuyenNganhData) {
			modelt.addRow(rowData);
		}
	}

	public void showTenMTHoTenDiem() {
		modelt = (DefaultTableModel) table_1.getModel();
		modelt.setRowCount(0);
		String name[] = { "TENMT", "HOTEN", "DIEM" };
		modelt.setColumnIdentifiers(name);
		ArrayList<Object[]> khoaOrChuyenNganhData = new Sukien().TenMTHoTenDiem();
		for (Object[] rowData : khoaOrChuyenNganhData) {
			modelt.addRow(rowData);
		}
	}

	public void showDTBSV() {
		modelt = (DefaultTableModel) table_1.getModel();
		modelt.setRowCount(0);
		String name[] = { "HOTEN", "MASV", "DIEMTB" };
		modelt.setColumnIdentifiers(name);
		ArrayList<Object[]> khoaOrChuyenNganhData = new Sukien().getDTBSV();
		for (Object[] rowData : khoaOrChuyenNganhData) {
			modelt.addRow(rowData);
		}
	}

	public void showKhoaTL() {
		modelt = (DefaultTableModel) table_1.getModel();
		modelt.setRowCount(0);
		String name[] = { "MAKHOA", "Khoa Thành Lập Từ Năm 2015-2018" };
		modelt.setColumnIdentifiers(name);
		ArrayList<Object[]> khoaOrChuyenNganhData = new Sukien().getKhoaTL();
		for (Object[] rowData : khoaOrChuyenNganhData) {
			modelt.addRow(rowData);
		}
	}

	public void showDemMaKHoa() {
		modelt = (DefaultTableModel) table_1.getModel();
		modelt.setRowCount(0);
		String name[] = { "MAKHOA", "TENKHOA" };
		modelt.setColumnIdentifiers(name);
		ArrayList<Object[]> khoaOrChuyenNganhData = new Sukien().getDemMaKhoa();
		for (Object[] rowData : khoaOrChuyenNganhData) {
			modelt.addRow(rowData);
		}
	}

	public void showSVCSDL() {
		modelt = (DefaultTableModel) table_1.getModel();
		modelt.setRowCount(0);
		String name[] = { "HOTEN", "MASV", "DIEM" };
		modelt.setColumnIdentifiers(name);
		ArrayList<Object[]> khoaOrChuyenNganhData = new Sukien().getSVCSDL();
		for (Object[] rowData : khoaOrChuyenNganhData) {
			modelt.addRow(rowData);
		}
	}

	public void showSVDiemThi() {
		modelt = (DefaultTableModel) table_1.getModel();
		modelt.setRowCount(0);
		String name[] = { "HOTEN", "MASV", "DIEM", "GHICHU", "MAMT", "MAL" };
		modelt.setColumnIdentifiers(name);
		ArrayList<Object[]> khoaOrChuyenNganhData = new Sukien().getSVDiemThi();
		for (Object[] rowData : khoaOrChuyenNganhData) {
			modelt.addRow(rowData);
		}
	}

	public void showMaSVHoTen() {
		modelt = (DefaultTableModel) table_1.getModel();
		modelt.setRowCount(0);
		String name[] = { "MASV", "HOTEN" };
		modelt.setColumnIdentifiers(name);
		ArrayList<Object[]> khoaOrChuyenNganhData = new Sukien().getMaSVHoTen();
		for (Object[] rowData : khoaOrChuyenNganhData) {
			modelt.addRow(rowData);
		}
	}

	public void showMACNSISO() {
		modelt = (DefaultTableModel) table_1.getModel();
		modelt.setRowCount(0);
		String name[] = { "MACN", "SISO" };
		modelt.setColumnIdentifiers(name);
		ArrayList<Object[]> khoaOrChuyenNganhData = new Sukien().getMACNSISO();
		for (Object[] rowData : khoaOrChuyenNganhData) {
			modelt.addRow(rowData);
		}
	}

	public void showSVVT() {
		modelt = (DefaultTableModel) table_1.getModel();
		modelt.setRowCount(0);
		String name[] = { "MAL" };
		modelt.setColumnIdentifiers(name);
		ArrayList<Object[]> khoaOrChuyenNganhData = new Sukien().getSVVT();
		for (Object[] rowData : khoaOrChuyenNganhData) {
			modelt.addRow(rowData);
		}
	}

	public void showSV() {
		modelt = (DefaultTableModel) table_1.getModel();
		modelt.setRowCount(0);
		String name[] = { "MASV", "HOTEN", "NGSINH", "PHAI", "MAL" };
		modelt.setColumnIdentifiers(name);
		sinhVien = new Sukien().getListSV();
		for (SinhVien sinhVien2 : sinhVien) {
			modelt.addRow(new Object[] { sinhVien2.getMaSV(), sinhVien2.getHoTen(), sinhVien2.getNgSinh(),
					sinhVien2.getGioiTinh(), sinhVien2.getMaLop() });
		}
	}

	public void showDiemThi() {
		modelt = (DefaultTableModel) table_1.getModel();
		modelt.setRowCount(0);
		String name[] = { "MASV", "MAMT", "DIEM", "GHICHU" };
		modelt.setColumnIdentifiers(name);
		diemThi = new Sukien().getListDiem();
		for (DiemThi diem : diemThi) {
			modelt.addRow(new Object[] { diem.getMaSV(), diem.getMaMT(), diem.getDiem(), diem.getGhiChu(),

			});
		}
	}

	public void showThi() {
		modelt = (DefaultTableModel) table_1.getModel();
		modelt.setRowCount(0);
		String name[] = { "MAMT", "MACN" };
		modelt.setColumnIdentifiers(name);
		thi = new Sukien().selecALL();

		for (Thi hi : thi) {
			modelt.addRow(new Object[] { hi.getMaMT(), hi.getMaCN(), });
		}

	}

	public void showMonThi() {
		modelt = (DefaultTableModel) table_1.getModel();
		modelt.setRowCount(0);
		String name[] = { "MAMT", "TENMT" };
		modelt.setColumnIdentifiers(name);
		monThi = new Sukien().selecALLMonThi();
		for (MonThi mThi : monThi) {
			modelt.addRow(new Object[] { mThi.getMaMT(), mThi.getTenMT(), });
		}

	}

	public void showLop() {
		modelt = (DefaultTableModel) table_1.getModel();
		modelt.setRowCount(0);
		String name[] = { "MAL", "SISO", "MACN" };
		modelt.setColumnIdentifiers(name);
		lop = new Sukien().selecALLLop();
		for (Lop l : lop) {
			modelt.addRow(new Object[] { l.getMaL(), l.getSiSo(), l.getMaCN() });
		}

	}

	public void showKhoa() {
		modelt = (DefaultTableModel) table_1.getModel();
		modelt.setRowCount(0);
		String name[] = { "MAKHOA", "TENKHOA", "NAMTL", "PHONGLV", "TEL", "MATRGKHOA" };
		modelt.setColumnIdentifiers(name);
		khoa = new Sukien().selecALLKhoa();
		for (Khoa k : khoa) {
			modelt.addRow(new Object[] { k.getMaKhoa(), k.getTenKhoa(), k.getNamTL(), k.getPhongLV(), k.getTel(),
					k.getMaTrgKhoal() });
		}

	}

	public void showGV() {
		modelt = (DefaultTableModel) table_1.getModel();
		modelt.setRowCount(0);
		String name[] = { "MAGV", "TENGV", "SODT", "MAKHOA" };
		modelt.setColumnIdentifiers(name);
		giangVien = new Sukien().selecALLGV();
		for (GiangVien gv : giangVien) {
			modelt.addRow(new Object[] { gv.getMaGV(), gv.getTenGV(), gv.getSoDT(), gv.getMaKhoa() });
		}

	}

	public void showDT() {
		modelt = (DefaultTableModel) table_1.getModel();
		modelt.setRowCount(0);
		String name[] = { "MASV", "SODT" };
		modelt.setColumnIdentifiers(name);
		dienThoai = new Sukien().selecALLDT();
		for (DienThoai dt : dienThoai) {
			modelt.addRow(new Object[] { dt.getMaSV(), dt.getSoDT() });
		}

	}

	public void showDC() {
		modelt = (DefaultTableModel) table_1.getModel();
		modelt.setRowCount(0);
		String name[] = { "MASV", "SONHA", "DUONG", "QUAN", "THANHPHO" };
		modelt.setColumnIdentifiers(name);
		diachi = new Sukien().selecALLDC();
		for (DiaChi dc : diachi) {
			modelt.addRow(new Object[] { dc.getMaSV(), dc.getSoNha(), dc.getDuong(), dc.getQuan(), dc.getThanhPho() });
		}

	}

	public void showCN() {
		modelt = (DefaultTableModel) table_1.getModel();
		modelt.setRowCount(0);
		String name[] = { "MACN", "TENCN", "MAGVQL", "MAKHOA" };
		modelt.setColumnIdentifiers(name);
		chuyenNganh = new Sukien().selecALLCN();
		for (ChuyenNganh cn : chuyenNganh) {
			modelt.addRow(new Object[] { cn.getMaCN(), cn.getTenCN(), cn.getMaGVCN(), cn.getMaKhoa() });
		}

	}

	public void clearpanel() {
		panelSV.setVisible(false);
		panelthi.setVisible(false);
		panelmonthi.setVisible(false);
		panellop.setVisible(false);
		panelkhoa.setVisible(false);
		panelgiangvien.setVisible(false);
		paneldienthoai.setVisible(false);
		paneldiemthi.setVisible(false);
		paneldiachi.setVisible(false);
		panelchuyennganh.setVisible(false);

	}

	private void resetTextFields() {
		FieldMa.setText("");
		Field_HoTen.setText("");
		textFieldNgSinh.setText("");
		textField_MaL.setText("");
		RadioButtonNam.setSelected(false);
		radioNu.setSelected(false);

		textField_MT.setText("");
		textField_maCN.setText("");

		textField_MAMT.setText("");
		textField_teMT.setText("");

		textField_MaLop.setText("");
		textField_SiSo.setText("");
		textField_MaCN.setText("");

		textField_Makhoa.setText("");
		textField_tenKhoa.setText("");
		textField_namTL.setText("");
		textField_phongLv.setText("");
		textField_Tel.setText("");
		textField_MatrgKhoa.setText("");

		textField_maGV.setText("");
		textField_tenGv.setText("");
		textField_soDT.setText("");
		textField_Makhoagv.setText("");

		textField_MASVdt.setText("");
		textField_soDt.setText("");

		textField_maSVdiem.setText("");
		textField_maMTdiem.setText("");
		textField_Diem.setText("");
		textField_ghichu.setText("");

		textField_maSVdc.setText("");
		textField_soNha.setText("");
		textField_Duong.setText("");
		textField_Quan.setText("");
		textField_Thanhpho.setText("");

		textField_maCNchuyennganh.setText("");
		textField_TenCn.setText("");
		textField_maGVQl.setText("");
		textField_Makhoacn.setText("");
	}

	public void showdata() {
	
          String text = textNhap.getText();
		if (text.equalsIgnoreCase("select * from sinhvien")
				|| text.equals("SELECT * FROM quanlythongtinsinhvien.sinhvien;")) {
			showSV();
			clearpanel();
			panelSV.setVisible(true);		    
			table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent e) {
					int row = table_1.getSelectedRow();
					if (row >= 0) {
						int columnCount = table_1.getColumnCount();
						if (columnCount > 4) {
							String masv = table_1.getValueAt(row, 0).toString();
							String hoten = table_1.getValueAt(row, 1).toString();
							String ngaysinh = table_1.getValueAt(row, 2).toString();
							String gioiTinh = table_1.getValueAt(row, 3).toString();
							String maLop = table_1.getValueAt(row, 4).toString();

							FieldMa.setText(masv);
							Field_HoTen.setText(hoten);
							textFieldNgSinh.setText(ngaysinh);
							textField_MaL.setText(maLop);

							if (gioiTinh.equals("Nam") || gioiTinh.equals("nam")) {
								RadioButtonNam.setSelected(true);
								radioNu.setSelected(false);
							} else {
								RadioButtonNam.setSelected(false);
								radioNu.setSelected(true);
							}
							
						}
					}
				}
			});
			table_1.clearSelection();
			
			btnDelete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int row = table_1.getSelectedRow();
					if (row >= 0) {
						String maSV = table_1.getValueAt(row, 0).toString();
						SinhVien sv = new SinhVien();
						sv.setMaSV(maSV);
						try {
							new Sukien().Delete(sv);

							showSV();
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
					resetTextFields();
				}
			});
			

		} else if (text.equalsIgnoreCase("select * from diemthi")
				|| text.equalsIgnoreCase("SELECT * FROM quanlythongtinsinhvien.diemthi;")) {
			showDiemThi();
			clearpanel();
			paneldiemthi.setVisible(true);
		  
			table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

	             @Override
				public void valueChanged(ListSelectionEvent e) {
					int row = table_1.getSelectedRow();
					if (row >= 0 && table_1.getColumnCount() > 3) {
						String masv = table_1.getValueAt(row, 0).toString();
						String mamt = table_1.getValueAt(row, 1).toString();
						String diem = table_1.getValueAt(row, 2).toString();
						String ghichu = table_1.getValueAt(row, 3).toString();

						textField_maSVdiem.setText(masv);
						textField_maMTdiem.setText(mamt);
						textField_Diem.setText(diem);
						textField_ghichu.setText(ghichu);
					}
				}
			});
			table_1.clearSelection();
			
			btnDelete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int row = table_1.getSelectedRow();
					if (row >= 0) {
						String maSV = table_1.getValueAt(row, 0).toString();
						String mamt = table_1.getValueAt(row, 1).toString();
						DiemThi sv = new DiemThi();
						sv.setMaSV(maSV);
						sv.setMaMT(mamt);
						try {
							new Sukien().Delete(sv);

							showDiemThi();
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
					resetTextFields();

				}
			});
		

		}else if(text.equalsIgnoreCase("select * from thi")||text.equalsIgnoreCase("SELECT * FROM quanlythongtinsinhvien.thi;"))

	{
		showThi();
		clearpanel();
		panelthi.setVisible(true);

		table_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table_1.getSelectedRow();
				if (row >= 0 && table_1.getColumnCount() > 1) {
					String masv = table_1.getValueAt(row, 0).toString();
					String mamt = table_1.getValueAt(row, 1).toString();

					textField_MT.setText(masv);
					textField_maCN.setText(mamt);
				}
			}
		});
		table_1.clearSelection();

		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table_1.getSelectedRow();
				if (row >= 0) {
					String maSV = table_1.getValueAt(row, 0).toString();
					Thi sv = new Thi();
					sv.setMaMT(maSV);
					try {
						new Sukien().Delete(sv);

						showThi();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});
	}

	else if(text.equalsIgnoreCase("select * from monthi")||text.equalsIgnoreCase("SELECT * FROM quanlythongtinsinhvien.monthi;"))
	{
		showMonThi();
		panelmonthi.setVisible(true);
		table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = table_1.getSelectedRow();
				if (row >= 0 && table_1.getColumnCount() > 1) {
					String masv = table_1.getValueAt(row, 0).toString();
					String mamt = table_1.getValueAt(row, 1).toString();

					textField_MAMT.setText(masv);
					textField_teMT.setText(mamt);

				}
			}
		});
		table_1.clearSelection();

		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table_1.getSelectedRow();
				if (row >= 0) {
					String maSV = table_1.getValueAt(row, 0).toString();
					String mamt = table_1.getValueAt(row, 1).toString();
					MonThi sv = new MonThi();
					sv.setMaMT(maSV);
					sv.setTenMT(mamt);
					try {
						new Sukien().Delete(sv);
						showMonThi();
						;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

			}
		});
	
	}else if(text.equalsIgnoreCase("select * from lop")||text.equalsIgnoreCase("SELECT * FROM quanlythongtinsinhvien.lop;"))
	{
		showLop();
		clearpanel();
		panellop.setVisible(true);

		table_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table_1.getSelectedRow();
				if (row >= 0 && table_1.getColumnCount() > 2) {
					String masv = table_1.getValueAt(row, 0).toString();
					String mamt = table_1.getValueAt(row, 1).toString();
					String ns = table_1.getValueAt(row, 2).toString();

					textField_MaLop.setText(masv);
					textField_SiSo.setText(mamt);
					textField_MaCN.setText(ns);

				}
			}
		});
		table_1.clearSelection();

		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table_1.getSelectedRow();
				if (row >= 0) {
					String maSV = table_1.getValueAt(row, 0).toString();

					Lop sv = new Lop();
					sv.setMaL(maSV);

					try {
						new Sukien().Delete(sv);

						showLop();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

			}
		});
	
		
	}else if(text.equalsIgnoreCase("select * from khoa")||text.equalsIgnoreCase("SELECT * FROM quanlythongtinsinhvien.khoa;"))
	{
		showKhoa();
		clearpanel();
		panelkhoa.setVisible(true);

		table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = table_1.getSelectedRow();
				if (row >= 0 && table_1.getColumnCount() > 4) {
					if (table_1.getValueAt(row, 2) == null) {
						textField_namTL.setText("");
					} else {
						String mamt1 = table_1.getValueAt(row, 2).toString();
						textField_namTL.setText("" + mamt1);
					}
					String masv = table_1.getValueAt(row, 0).toString();
					String mamt = table_1.getValueAt(row, 1).toString();
					String mamt2 = table_1.getValueAt(row, 3).toString();
					String mamt3 = table_1.getValueAt(row, 4).toString();
					String mamt4 = table_1.getValueAt(row, 5).toString();

					textField_Makhoa.setText("" + masv);
					textField_tenKhoa.setText("" + mamt);
					textField_phongLv.setText("" + mamt2);
					textField_Tel.setText("" + mamt3);
					textField_MatrgKhoa.setText("" + mamt4);

				}
			}
		});
		table_1.clearSelection();

		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table_1.getSelectedRow();
				if (row >= 0) {
					String maSV = table_1.getValueAt(row, 0).toString();

					Khoa sv = new Khoa();
					sv.setMaKhoa(maSV);

					try {
						new Sukien().Delete(sv);

						showKhoa();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});
	

	}else if(text.equalsIgnoreCase("select * from giangvien")||text.equalsIgnoreCase("SELECT * FROM quanlythongtinsinhvien.giangvien;"))
	{
		showGV();
		clearpanel();
		panelgiangvien.setVisible(true);

		table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = table_1.getSelectedRow();
				if (row >= 0 && table_1.getColumnCount() > 3) {
					String masv = table_1.getValueAt(row, 0).toString();
					String mamt = table_1.getValueAt(row, 1).toString();
					String mamt1 = table_1.getValueAt(row, 2).toString();
					String mamt2 = table_1.getValueAt(row, 3).toString();

					textField_maGV.setText(masv);
					textField_tenGv.setText(mamt);
					textField_soDT.setText(mamt1);
					textField_Makhoagv.setText(mamt2);

				}
			}
		});

		table_1.clearSelection();

		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table_1.getSelectedRow();
				if (row >= 0) {
					String maSV = table_1.getValueAt(row, 0).toString();

					GiangVien sv = new GiangVien();
					sv.setMaGV(maSV);

					try {
						new Sukien().Delete(sv);

						showGV();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

			}
		});
		
	}else if(text.equalsIgnoreCase("select * from dienthoai")||text.equalsIgnoreCase("SELECT * FROM quanlythongtinsinhvien.dienthoai;"))
	{
		showDT();
		clearpanel();
		paneldienthoai.setVisible(true);

		table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = table_1.getSelectedRow();
				if (row >= 0 && table_1.getColumnCount() > 1) {
					String masv = table_1.getValueAt(row, 0).toString();
					String mamt = table_1.getValueAt(row, 1).toString();

					textField_MASVdt.setText(masv);
					textField_soDt.setText(mamt);

				}
			}
		});

		table_1.clearSelection();

		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table_1.getSelectedRow();
				if (row >= 0) {
					String maSV = table_1.getValueAt(row, 0).toString();
					DienThoai sv = new DienThoai();
					sv.setMaSV(maSV);

					try {
						new Sukien().Delete(sv);

						showDT();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		
	}else if(text.equalsIgnoreCase("select * from diachi")||text.equalsIgnoreCase("SELECT * FROM quanlythongtinsinhvien.diachi;"))
	{
		showDC();
		clearpanel();
		paneldiachi.setVisible(true);

		table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = table_1.getSelectedRow();
				if (row >= 0 && table_1.getColumnCount() > 4) {
					String masv = table_1.getValueAt(row, 0).toString();
					String mamt = table_1.getValueAt(row, 1).toString();
					String mamt1 = table_1.getValueAt(row, 2).toString();
					String mamt2 = table_1.getValueAt(row, 3).toString();
					String mamt3 = table_1.getValueAt(row, 4).toString();

					textField_maSVdc.setText(masv);
					textField_soNha.setText(mamt);
					textField_Duong.setText(mamt1);
					textField_Quan.setText(mamt2);
					textField_Thanhpho.setText(mamt3);

				}
			}
		});
		table_1.clearSelection();

		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table_1.getSelectedRow();
				if (row >= 0) {
					String maSV = table_1.getValueAt(row, 0).toString();

					DiaChi sv = new DiaChi();
					sv.setMaSV(maSV);

					try {
						new Sukien().Delete(sv);

						showDC();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});
	
	}else if(text.equalsIgnoreCase("select * from chuyennganh")||text.equalsIgnoreCase("SELECT * FROM quanlythongtinsinhvien.chuyennganh;"))
	{
		showCN();
		clearpanel();
		panelchuyennganh.setVisible(true);

		table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = table_1.getSelectedRow();
				if (row >= 0 && table_1.getColumnCount() > 3) {
					String masv = table_1.getValueAt(row, 0).toString();
					String mamt = table_1.getValueAt(row, 1).toString();
					String diem = table_1.getValueAt(row, 2).toString();
					String ghichu = table_1.getValueAt(row, 3).toString();
					textField_maCNchuyennganh.setText(masv);
					textField_TenCn.setText(mamt);
					textField_maGVQl.setText(diem);
					textField_Makhoacn.setText(ghichu);

				}
			}
		});
		table_1.clearSelection();

		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table_1.getSelectedRow();
				if (row >= 0) {
					String maSV = table_1.getValueAt(row, 0).toString();

					ChuyenNganh sv = new ChuyenNganh();
					sv.setMaCN(maSV);

					try {
						new Sukien().Delete(sv);

						showCN();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

			}
		});
		

	}else if(text.equalsIgnoreCase("select sinhvien.HOTEN,mamt,diemthi.DIEM from diemthi join sinhvien using (MASV) where sinhvien.MASV = 15001;"))
	{
		showSV15001();
	}else if(text.equalsIgnoreCase("select khoa.MATRGKHOA from khoa  join giangvien using (MAKHOA) group by khoa.MATRGKHOA union select chuyennganh.MAGVQL from chuyennganh join giangvien  ON chuyennganh.MAGVQL = giangvien.MAGV group by chuyennganh.MAGVQL;"))
	{
		showgetTrgKhoa();
	}else if(text.equalsIgnoreCase("select* from sinhvien join lop using (MAL) where lop.MAL = 'KTPM01';"))
	{
		showGetSinhVienByLop();
	}else if(text.equalsIgnoreCase("select distinct LOP.SISO,LOP.MAL from LOP  join SINHVIEN using (MAL) where LOP.SISO >= 45;"))
	{
		showGetSiSoMLop();
	}else if(text.equalsIgnoreCase("select lop.MAL,lop.SISO from lop order by LOP.SISO desc;"))
	{
		showGetSiSoLop();
	}else if(text.equalsIgnoreCase("select  chuyennganh.MAKHOA, sum(siso)as vn from lop , chuyennganh where chuyennganh.macn=lop.macn group by makhoa having vn =( select max(tong) as tong1 from( select chuyennganh.MAKHOA, sum(siso) as tong from lop join chuyennganh using(MACN) group by makhoa) as a);"))
	{
		showSiSOTBKhoa();
	}else if(text.equalsIgnoreCase("select monthi.TENMT,sinhvien.HOTEN,diemthi.DIEM from diemthi join sinhvien using (MASV) join monthi using (MAMT) where diemthi.DIEM <5;"))
	{
		showTenMTHoTenDiem();
	}else if(text.equalsIgnoreCase("select sinhvien.HOTEN,sinhvien.MASV ,avg(diem) as 'DIEMTB' from diemthi join sinhvien using (MASV) group by sinhvien.HOTEN,sinhvien.MASV;"))
	{
		showDTBSV();
	}else if(text.equalsIgnoreCase("select khoa.MAkhoa, tenkhoa  as 'những khoa thành lập từ năm 2015-2018'  from khoa  where year(namtl)between 2015 and 2018;"))
	{
		showKhoaTL();
	}else if(text.equalsIgnoreCase("select chuyennganh.makhoa,tenkhoa from chuyennganh join khoa using (makhoa) group by makhoa having count( makhoa)>3;"))
	{
		showDemMaKHoa();
		;
	}else if(text.equalsIgnoreCase("select sinhvien.HOTEN,sinhvien.MASV,diem from diemthi join sinhvien using (MASV) where mamt = 'csdl';"))
	{
		showSVCSDL();
	}else if(text.equalsIgnoreCase("select sinhvien.HOTEN,sinhvien.MASV,diem,ghichu,mamt,sinhvien.mal from diemthi join sinhvien using (MASV) where mamt = 'csdl'and (mal='KTPM02' or mal='KTPM01' or mal='KTPM03' or mal='KTPM04');"))
	{
		showSVDiemThi();
	}else if(text.equalsIgnoreCase("select sinhvien.mal from sinhvien join diemthi using (masv) where ghichu = 'vắng thi' group by mal;"))
	{
		showSVVT();
	}else if(text.equalsIgnoreCase("select macn ,siso from lop;"))
	{
		showMACNSISO();
	}else if(text.equalsIgnoreCase("select masv,hoten  from sinhvien join lop using(mal)  join diemthi using (masv) where macn='kpdl' and diem >=8   group by masv having count(masv)=5;"))
	{
		showMaSVHoTen();
	}else
	{
		JOptionPane.showMessageDialog(contentPane, "Câu truy vấn không hợp lệ!", "Thông báo",
				JOptionPane.ERROR_MESSAGE);
	}

	resetTextFields();
}

}
