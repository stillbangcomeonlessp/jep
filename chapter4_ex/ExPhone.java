import java.util.Scanner;

class Phone {
    private String name, tel;
    public Phone(String name, String tel){
	this.name = name;
	this.tel = tel;
    }

    public String getName(){return this.name;}
    public String getTel(){return this.tel;}
}

public class ExPhone {
    public static void main(String[] args){
	Scanner scanner = new Scanner(System.in);
	String name,tel;

	System.out.print("이름과 전화번호 입력 >>");
	name = scanner.next();
	tel = scanner.next();

	Phone spongeBob = new Phone(name,tel);
	
	System.out.print("이름과 전화번호 입력 >>");
	name = scanner.next();
	tel = scanner.next();

	Phone squid = new Phone(name,tel);

	System.out.println("스폰지밥의 번호 "+spongeBob.getTel());
	System.out.println("징징이의 번호 "+squid.getTel());
    }
}
