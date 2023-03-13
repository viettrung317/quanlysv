package quanlysinhvien;

public class Dtvt extends SinhVien implements Interface{
	public Dtvt() {
		
	}
	

	public Dtvt(int mssv, int nk, int tctl, double gpa, String name, String chng,String xl) {
		super(mssv, nk, tctl, gpa, name, chng,xl);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setMssv(int i) {
		int t=nk%100;
		int ms=1000000*t+200000;
		//i=i+1;
		mssv=ms+i%1000+1;
		if(i==0) {
			mssv=1000000;
			int temp=nk%100;
			mssv=mssv*temp+200000;
		}
		
	}


	@Override
	public void setXl() {
		if(gpa>=8.0 && tctl>100) {
			xl="giỏi";
		}
		else if(gpa>=6.5 && tctl>100) {
			xl="khá";
		}else {
			xl="TB";
		}
		
	}


	@Override
	public boolean xethb(double x) {
		if(x>8.5) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		Dtvt dtvt=new Dtvt();
		return super.toString()+dtvt.xethb(gpa);
	}



}
