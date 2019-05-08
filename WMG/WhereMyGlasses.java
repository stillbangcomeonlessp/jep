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
       
	stackCal(gamer,this.level);
	move(gamer,house);
    }
    
    public int setLevel(int n){
	return (n<<1)+1;
    }
    

    public void stackCal(Seeker gamer,int n){
	Scanner scanner = new Scanner(System.in);
	int[] stackBox = new int[setLevel(n)];
	int result;

	n = (int)(Math.pow(setLevel(n),2));
	
	System.out.println("\n+---+");
	for(int i=stackBox.length-1; i>=0; i--) {
	    if(oddp(i)){
		stackBox[i] = (int)(Math.random()*4)+1;
		stackBox[i] = operatorInsert(stackBox[i]);
		System.out.printf("l%2c l",stackBox[i]);
		System.out.println("");
		System.out.println("+---+");
	    }else {
		stackBox[i] = (int)(Math.random()*n)+1;
		System.out.printf("l%2d l",stackBox[i]);
		System.out.println("");
		System.out.println("+---+");
	    }
	}
	result = calStack(stackBox);

	System.out.print("\nInput!: ");
	if (result == (gamer.answer = scanner.nextInt())) {
	    System.out.println("Success!");
	}else{
	    System.out.println("Failed!");
	}
    }

    public boolean oddp(int val){
	if (val%2 != 0) {
	    return true;
	}else{
	    return false;
	}
    }

    public int operatorInsert (int val) {
	switch(val){
	case 1:
	    return 43;
	case 2:
	    return 45;
	case 3:
	    return 42;
	default:
	    return 47;
	}
    }
    public int calStack(int[] stackBox) {
	int result = stackBox[stackBox.length-1];

	for (int i=stackBox.length-2;i>=1; i=i-2) {
	    switch(stackBox[i]){
	    case 43:
		result += stackBox[i-1];
		break;
	    case 45:
		result -= stackBox[i-1];
		break;
	    case 42:
		result *= stackBox[i-1];
		break;
	    case 47:
		result /= stackBox[i-1];
		break;
	    default:
		System.out.println("NO ACTION");
	    }
	}
	return result;
    }

    public void move (Seeker gamer,Rooms house) {
	int x=gamer.roomIndex[0],y=gamer.roomIndex[1];
	int[][] sel = new int[2][2];
	int[] ud = new int[2];
	int[] lr = new int[2];
	int seq = 1;
	ud[0] = x-1;
	ud[1] = x+1;
	lr[0] = y-1;
	lr[1] = y+1;

	for (int i = 0; i<ud.length; i++) {
	    if (ud[i]<0||ud[i]>=house.room[0].length) {
		continue;
	    }
	    sel[i][]
	    System.out.println(seq++ +") "+house.room[ud[i]][y]);
	}

	for (int j = 0; j<lr.length; j++) {
	    if (lr[j]<0||lr[j]>=house.room[0].length) {
		continue;
	    }
	    System.out.println(seq+++") "+house.room[x][lr[j]]);
	}
    }
}


class Seeker {
    String name;
    int level;
    int roomNum;
    int[] roomIndex = new int[2];
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
		    gamer.roomIndex[0] = i;
		    gamer.roomIndex[1] = j;
		    room[i][j] = 42-84;
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
		if (room[i][j] == -42) {
		    System.out.printf("l%4c l",room[i][j]+84);
		}else
		    System.out.printf("l%4d l", room[i][j]);
	    }
	    System.out.println("");
	    for(int j=0;j<room[0].length;j++){
		System.out.print("+-----+");
	    }
	    System.out.print("\n");
	}
	System.out.println("Check where you at! You are in '*'");
    }
}

public class WhereMyGlasses {
    public static void main(String[] args){
	Moderator md = new Moderator();
	md.newGame();
    }
}
