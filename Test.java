package quanlysinhvien;
import java.util.Scanner;


public class Test {
	public static void main(String[] args) {
		Quanlysv ql=new Quanlysv();
		ql.setPath("E:\\sourcejava\\quanlysinhvien\\src\\quanlysinhvien\\text.txt");
		int lc;
		while(true) {
			int exit=1;
			System.out.print("\n______________MENU__________\n");
			System.out.print("1. Thêm 1 sinh viên\n");
			System.out.print("2. xóa sinh viên theo mã số\n");
			System.out.print("3. Chỉnh sửa sinh viên theo mã số\n");
			System.out.print("4. Sắp xếp sinh viên\n");
			System.out.print("5. Xuất tất cả sinh viên\n");
			System.out.print("0. Thoát\n");
			Scanner sc=new Scanner(System.in);
			lc=sc.nextInt();
			switch(lc){
			case(1):
				ql.add();
			break;
			case(2):
				ql.remove();
			break;
			case(3):
				ql.edit();
			break;
			case(4):
				ql.sort();
			break;
			case(5):
				ql.display();
			break;
			case(0):
				exit=0;
				break;
			default:
				System.out.print("Bạn nhập sai!!\n");
			}
			if(exit==0) {
				System.out.print("Tạm biệt!!");
				break;
			}
			
		}
	}

}
