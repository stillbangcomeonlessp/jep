import java.util.Scanner;

class Moderator {
    int level;
    
    public Moderator(){
	level = 0;
    }

    public void newGame(){
	Scanner scanner = new Scanner(System.in);
	Rooms grand;
	Seeker gamer = new Seeker();
	RunAway raway = new RunAway();

	System.out.print("What your name?: ");
	gamer.name = scanner.next();
	System.out.print("Hi, "+gamer.name+". I hid my glasses in a room somewhere with \"RunAway!\"\n You can \'Find the Glasses!.\' What you want level? : ");
	this.level = scanner.nextInt();
	grand = new Rooms(setLevel(this.level));
	System.out.println("Level "+this.level+" has been set! Go to there~\n");
		
	grand.printRooms();
	question(gamer,setLevel(this.level));

	scanner.close();
    }
    
    public int setLevel(int n){
	return (n<<1)+1;
    }

    public void question(Seeker refGamer,int n){
	Scanner scanner = new Scanner(System.in);
	n = (int)(Math.random()*n+2);
	int[] operator = new int[n];
	char[] charOp = new char[n];
	int[] operand = new int[n];

	int result;

	for (int i = 0; i<operand.length; i++) {
	    operand[i] = (int)(Math.random()*n+1);
	}
	result = operand[0];
	
	for (int j = 0; j<operator.length-1; j++) {
	   
	    operator[j] = (int)(Math.random()*4+1);
	    switch(operator[j]){
	    case 1:
		charOp[j] = '+';
		result += operand[j+1];
		break;
	    case 2: 
		charOp[j] = '-';
		result -= operand[j+1];
		break;
	    case 3:
		charOp[j] = '*';
		result *= operand[j+1];
		break;
	    case 4:
		charOp[j] = '/';
		result = (int)(result/operand[j+1]);
		break;
	    }
	}
	for (int k=0; k<operand.length; k++) {
	    if(k==operand.length-1){
		System.out.print(operand[k]+" = ?: ");
		if(result == (refGamer.answer = scanner.nextInt()))
		    System.out.println("Success!");
		else
		    System.out.println("Failed");
	    }else
		System.out.print(operand[k]+" "+charOp[k]+" ");
	}
    }
}

class Seeker {
    String name;
    int roomNum;
    int answer;
}

class RunAway {

}

class Rooms {
    int level;
    int[][] room;
    public Rooms(int n){
	this.room = new int[n][n];
	int temp = 1;

	for(int i=0;i<n;i++){
	    for (int j = 0; j <n; j++) {
	 	room[i][j] = temp++;
	    }
	}
	this.level = (n>>1)+1;
    }

    public void printRooms(){
	for(int i=0;i<room[0].length;i++){
	    for(int j=0;j<room[0].length;j++){
		System.out.print("+-----+");
	    }
	    System.out.println("");
	    for (int j=0; j<room[0].length; j++) {
		System.out.printf("l%4d l", room[i][j]);
	    }
	    System.out.println("");
	    for(int j=0;j<room[0].length;j++){
		System.out.print("+-----+");
	    }
	    System.out.print("\n");
	}
    }
}

public class WhereMyGlasses {
    public static void main(String[] args){
	Moderator md = new Moderator();
	md.newGame();
    }
}
