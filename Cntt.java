package quanlysinhvien;

public class Cntt extends SinhVien implements Interface{
	
	public Cntt() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cntt(int mssv, int nk, int tctl, double gpa, String name, String chng,String xl) {
		super(mssv, nk, tctl, gpa, name, chng,xl);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setXl() {
		if(gpa>=8.5 && tctl>110) {
			xl= "giỏi";
		}
		else if(gpa>=7 && tctl>100) {
			xl= "khá";
		}
		xl= "TB";
	}

	@Override
	public void setMssv(int i) {
		int t=nk%100;
		mssv=1000000;
		mssv=mssv*t+100000;
		mssv=mssv+(i%(i-100000))%100000+1;
		if(i==0) {
			mssv=1000000;
			int temp=nk%100;
			mssv=mssv*temp+100000;
		}
		
	}
	@Override
	public boolean xethb(double x) {
		if(x>9) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		Cntt cntt=new Cntt();
		return super.toString()+cntt.xethb(gpa);
	}
	
	
}
