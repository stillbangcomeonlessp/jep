import java.util.Scanner;

class Moderator {
    int level;
    
    public Moderator(){
	level = 0;
    }

    public void newGame(){
	Scanner scanner = new Scanner(System.in);
	Rooms house;
	Seeker gamer = new Seeker();
	RunAway raway = new RunAway();

	System.out.print("What your name?: ");
	gamer.name = scanner.next();
	System.out.print("Hi, "+gamer.name+". I hid my glasses in a room somewhere with \"RunAway!\"\n You can \'Find the Glasses!.\' What you want level? : ");
	this.level = scanner.nextInt();
	house = new Rooms(setLevel(this.level));
	System.out.println("Level "+this.level+" has been set! Go to there~\n");

	mainGame(gamer,raway,house);

	scanner.close();
    }

    public void mainGame(Seeker gamer, RunAway raway,Rooms house){
	gamer.setRoom(this.level);
	raway.setRoom(this.level);

	house.cmpRoom(gamer,raway);

	house.printRooms();
	while(true){
	    question(gamer,this.level);
	}
    }
    
    public int setLevel(int n){
	return (n<<1)+1;
    }
    

    public void question(Seeker refGamer,int n)
}

class Seeker {
    String name;
    int level;
    int roomNum;
    int answer;

    public void setRoom(int n){
        this.level = n;
	n = (int)Math.pow(((n<<1)+1),2);
	this.roomNum = (int)(Math.random()*n)+1;
    }
}

class RunAway {
    int level;
    int roomNum;

    public void setRoom(int n){
	this.level = n;
	n = (n<<1)+1;
	this.roomNum = (int)(Math.random()*n+1);
    }
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

    public void cmpRoom(Seeker gamer, RunAway raway){
	int temp;

	while(gamer.roomNum == raway.roomNum){
	    gamer.setRoom(gamer.level);
	}
	
	for (int i=0; i<room[0].length; i++) {
	    for (int j=0; j<room[i].length; j++) {
		if(gamer.roomNum == room[i][j]){
		    temp = gamer.roomNum;
		    room[i][j] = 42;
		    break;
		}
	    }
	}
	
	System.out.println("Generated!");
	return;
    }

    public void printRooms(){
	for(int i=0;i<room[0].length;i++){
	    for(int j=0;j<room[0].length;j++){
		System.out.print("+-----+");
	    }
	    System.out.println("");
	    for (int j=0; j<room[0].length; j++) {
		if (room[i][j] == 42) {
		    System.out.printf("l%4c l",room[i][j]);
		}else
		    System.out.printf("l%4d l", room[i][j]);
	    }
	    System.out.println("");
	    for(int j=0;j<room[0].length;j++){
		System.out.print("+-----+");
	    }
	    System.out.print("\n");
	}
	System.out.println("Check where you at! ");
    }
}

public class WhereMyGlasses {
    public static void main(String[] args){
	Moderator md = new Moderator();
	md.newGame();
    }
}
