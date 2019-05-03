import java.util.Scanner;

class Glasses{
    short where;
    short roomNum;
    
    public void setGlasses(int level){
	if(level%2 == 0)
	    this.roomNum = (short)(Math.random()*(level+1)+1);
    }
}

class Room{
    
}

class Theif{
    short curPos;
}

class Defender{
    String name;
    short curPos;

    public String getName(){
	return name;
    }
}

class FindStart{

    public void FindStart(){
    }
}

public class WhereMyGlasses{
    public static void main(String[] args) {
	Defender dfn = new Defender();
	Scanner scanner = new Scanner(System.in);

	char response;

	System.out.print("Input your Name: ");
	dfn.name = scanner.next();
	System.out.print("Welcome "+dfn.name+". The \"Thief\" stole my glasses. :( Can you find my glasses? [y/n] ");
	if ((response  = scanner.next().charAt(0)) == 'y') {
	    FindStart game = new FindStart();
	}else {
	    System.out.println("Sorry to say goodbye then");
	}
    }
}
