import java.util.Scanner;

class Phone_1 {
    String name,tel;

    public Phone_1(String name,String tel){
	this.name = name;
	this.tel = tel;
    }

    public String getTel(){
	return tel;
    }
}

public class ExPhoneManager {
    public static void main(String[] args){
	Scanner scanner = new Scanner(System.in);
	int peoples;
	String[] name,tel;
	String search;

	name = new String[2];
	tel = new String[2];
	
	System.out.print("인원수>>");
	peoples = scanner.nextInt();

	System.out.print("이름과 전화번호(번호는 연속적으로 입력)>>");
	name[0] = scanner.next();
	tel[0] = scanner.next();
	Phone_1 kim = new Phone_1(name[0],tel[0]);
	
	System.out.print("이름과 전화번호(번호는 연속적으로 입력)>>");
	name[0] = scanner.next();
	tel[1] = scanner.next();
	Phone_1 joe = new Phone_1(name[1],tel[1]);

	System.out.println("저장되었습니다...");


	while(true){
	    System.out.print("검색할 이름>>");
	    search = scanner.next();
	    if (search.equals("김인수")) {
		System.out.println(search+"의 번호는 "+kim.getTel());
	    }else if (search.equals("조수미")) {
		System.out.println(search+"의 번호는 "+joe.getTel());
	    }else if (search.equals("exit")) {
		System.out.println("프로그램을 종료합니다.");
		break;
	    }else{
		System.out.println(search+" 없습니다.");
	    }
	}
    }
}
