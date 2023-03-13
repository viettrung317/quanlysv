package quanlysinhvien;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
public class Quanlysv implements Interfaceqlsv{
	private String path;
	private List<SinhVien> lsv;
	private List<Dtvt> ldt;
	private List<Cntt> lcn;
	
	public Quanlysv() {
		super();
		lsv=new ArrayList<SinhVien>();
		ldt=new ArrayList<Dtvt>();
		lcn=new ArrayList<Cntt>();
	}

	public Quanlysv(List<SinhVien> lsv, List<Dtvt> ldt, List<Cntt> lcn,String path) {
		super();
		this.lsv = lsv;
		this.ldt = ldt;
		this.lcn = lcn;
		this.path=path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public void add() {
		String cn1="Điện Tử Viễn Thông";
		String cn2="Công nghệ thông tin";
		getList(cn1,cn2);
		if(lsv.size()<5) {
			System.out.print("1. Điện Tử Viễn Thông\n");
			System.out.print("2. Công nghệ thông tin\n");
			Scanner sc=new Scanner(System.in) ;
			int temp=sc.nextInt();
			if(temp==1) {
				SinhVien sv=new Dtvt();
				sv.nhap();
				sv.setChng(cn1);
				sv.setXl();
				int i=0;
				if(ldt.size()!=0) {
					i=ldt.get(ldt.size()-1).getMssv();
					sv.setMssv(i);
				}else {
					sv.setMssv(i);
				}
				lsv.add(sv);
				Quanlysv.LuuFile(path, lsv);
			}
			else if(temp==2) {
				SinhVien sv=new Cntt();
				sv.nhap();
				sv.setChng(cn2);
				sv.setXl();
				int i=0;
				if(lcn.size()!=0) {
					i=lcn.get(lcn.size()-1).getMssv();
					sv.setMssv(i);
				}else {
					sv.setMssv(i);
				}
				lsv.add(sv);
				Quanlysv.LuuFile(path, lsv);
			}
			else {
				System.out.print("Bạn nhập sai!!!");
			}
		} else System.out.print("Quá giới hạn!!!");
	
		
	}

	@Override
	public void edit() {
		String cn1="Điện Tử Viễn Thông";
		String cn2="Công nghệ thông tin";
		Scanner sc =new Scanner(System.in);
		System.out.print("Nhập mã số sv cần chỉnh sửa :");
		String temp=sc.nextLine();
		int ms=Integer.parseInt(temp);
		int t=0;
		getList(cn1,cn2);
		if(lsv.size()!=0) {
			for(SinhVien sv:lsv) {
				if(sv.getMssv()==ms) {
					System.out.print("1. Điện Tử Viễn Thông\n");
					System.out.print("2. Công nghệ thông tin\n");
					int cn=sc.nextInt();
					if(cn==1) {
						SinhVien sv1=new Dtvt();
						sv1.nhap();
						sv1.setChng(cn1);
						int i=0;
						if(sv.getChng().equals(cn1)) {
							i=sv.getMssv()-1;
							sv1.setMssv(i);
							//lsv.set(lsv.indexOf(sv), sv1);
						}
						else {
							if(ldt.size()!=0) {
								sv1.setChng(cn1);
								i=ldt.size()-1;
								sv1.setMssv(i);
							}
							else {
								sv1.setMssv(i);
							}
						}
						lsv.set(lsv.indexOf(sv), sv1);
						LuuFile(path, lsv);
					}
					else if(cn==2) {
						SinhVien sv2=new Cntt();
						sv2.nhap();
						sv2.setChng(cn2);
						int i=0;
						if(sv.getChng().equals(cn2)) {
							sv2.setMssv(sv.getMssv()-1);
						}
						else {
							if(lcn.size()!=0) {
								sv2.setMssv(lcn.get(lcn.size()-1).getMssv());
							}
							else {
								sv2.setMssv(i);
							}
						}
						lsv.set(lsv.indexOf(sv), sv2);
					}else{
						System.out.print("Bạn nhập sai !!!");
						}
					t=1;
					break;
				}
			}
			if(t==0) {
				System.out.print("Mã sinh viên ko có trong danh sách !!!");
			}
			LuuFile(path, lsv);
			display();
		}
		
		
	}

	@Override
	public void remove() {
		Scanner sc=new Scanner(System.in);
		int temp=0;
		lsv=Quanlysv.DocFile(path);
		if(lsv.size()!=0) {
			System.out.print("Nhập mã số sv xóa :");
			int msv=sc.nextInt();
			for(SinhVien sv:lsv) {
				if(sv.getMssv()==msv) {
					lsv.remove(sv);
					System.out.print("Đã xóa thành công sinh viên có mã số : "+msv+"\n");
					temp=1;
					break;
				}
			}
			if(temp==0) {
				System.out.print("Danh sách ko có sinh viên có mã số : "+msv);
			}
			//display();
			Quanlysv.LuuFile(path, lsv);
		}else {
			System.out.print("Danh sách rỗng");
		}
	}
	public void swap(int i,int j) {
		SinhVien sv=lsv.get(i);
		lsv.set(i, lsv.get(j));
		lsv.set(j, sv);
	}
	@Override
	public void sort() {
		lsv=DocFile(path);
		if(lsv.size()!=0) {
			for(int i=0;i<lsv.size()+1;i++) {
				for(int j=i+1;j<lsv.size();j++) {
					if(lsv.get(j).getMssv()<lsv.get(i).getMssv()) {
						swap(i,j);
					}
				}
				
			}
			LuuFile(path,lsv);
		}
		else{
			System.out.print("Danh sách rỗng");
		}
		
	}

	@Override
	public void display() {
		lsv=DocFile(path);
		if(lsv.size()!=0) {
			for(SinhVien sv: lsv) {
				System.out.print(sv+"\n");
			}
		}
	}
	public static boolean LuuFile(String path,List<SinhVien> sv) {
		try {
			FileOutputStream fos=new FileOutputStream(path);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(sv);
			oos.close();
			fos.close();
			return true;
		}
		catch(FileNotFoundException e1) {
			System.out.print("FIle not found!!!");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	public static List<SinhVien> DocFile(String path){
		List<SinhVien> list=new ArrayList<SinhVien>();
		try {
			FileInputStream fis=new FileInputStream(path);
			ObjectInputStream ois=new ObjectInputStream(fis);
			Object data=ois.readObject();
			list=(List<SinhVien>)data;
			ois.close();
			fis.close();
		}
		catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		catch(IOException e) {
			
		}
		return list;
	}

	@Override
	public void getList(String cn1,String cn2) {
		lsv=DocFile(path);
		if(lsv.size()!=0) {
			for(SinhVien sv:lsv) {
				if(sv.getChng().equals(cn1)) {
					ldt.add((Dtvt)sv);
				}
				else lcn.add((Cntt) sv);
			}
		}
		
	}


	
}
