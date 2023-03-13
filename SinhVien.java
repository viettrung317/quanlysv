package quanlysinhvien;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;
public abstract class SinhVien implements Serializable{
	protected int mssv,nk,tctl;
	protected double gpa;
	protected String name,chng,xl;
	public SinhVien() {
		
	}
	public SinhVien(int mssv,int nk,int tctl,double gpa,String name,String chng,String xl) {
		this.mssv=mssv;
		this.nk=nk;
		this.tctl=tctl;
		this.gpa=gpa;
		this.name=name;
		this.chng=chng;
		this.xl=xl;

	}
	public abstract void setXl();
	public String getXL() {
		return xl;
	}
	public int getMssv() {
		return mssv;
	}
	public abstract void setMssv(int i) ;
	public int getNk() {
		return nk;
	}
	public void setNk(int nk) {
		this.nk = nk;
	}
	public int getTctl() {
		return tctl;
	}
	public void setTctl(int tctl) {
		this.tctl = tctl;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChng() {
		return chng;
	}
	public void setChng(String chng) {
		this.chng = chng;
	}
	public void nhap() {
		Scanner sc=new Scanner(System.in);
		boolean done=false;
		while(!done) {
			try {
				System.out.print("Nhập họ tên sinh viên :");
				name=sc.nextLine();
				if(name.length()<7|| name.length()>15) {
					throw new Exception("Tên phải nằm trong khoảng 7-17 ký tự !!!\n");
				}
				done=true;
			}
			catch(Exception e) {
				System.out.print(e);
			}
		}
		done=false;
		while(!done) {
			try {
				System.out.print("Nhập niên khóa :");
				this.nk=sc.nextInt();
				if(nk<2017||nk>2022) {
					throw new Exception("Niên khóa không hợp lý !!!\n");
				}
				done=true;
			}
			catch(InputMismatchException e1) {
				System.out.print("Niên khóa phải là số nguyên !!!\n");
				nk=sc.nextInt();
				
			}
			catch(Exception e) {
				System.out.print(e);
			}
		}
		done=false;
		while(!done) {
			try {
				System.out.print("Nhập gpa :");
				gpa=sc.nextDouble();
				if(gpa<=0||gpa>10)  {
					throw new Exception("gpa ko hợp lý !!!\n");
				}
				done=true;
			}
			catch(InputMismatchException e1) {
				gpa=sc.nextDouble();
				System.out.print("gpa phải là số !!!\n");
			}
			catch(Exception e) {
				System.out.print(e);
			}
		}
		done=false;
		while(!done) {
			try {
				System.out.print("Nhập số tín chỉ :");
				tctl=sc.nextInt();
				if(tctl<=0||tctl>140) {
					throw new Exception("Tín chỉ ko hợp lý !!!\n");
				}
				done=true;
			}
			catch(InputMismatchException e1) {
				tctl=sc.nextInt();
				System.out.print("Tín chỉ phải là số nguyên !!!\n");
			}
			catch(Exception e) {
				System.out.print(e);
			}
		}
		done=false;
		
		
	}
	@Override
	public String toString() {
		return "SinhVien [mssv=" + mssv + ", nk=" + nk + ", tctl=" + tctl + ", gpa=" + gpa + ", name=" + name
				+ ", chng=" + chng + ", xl=" + xl + "]";
	}
	
	

}
