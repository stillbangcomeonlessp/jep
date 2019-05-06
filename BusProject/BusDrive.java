import java.util.Scanner;

class Watch {												//class 1
    String curTime;
    String alarmedTime;
    boolean bell = false;

    public Watch(){                                      //생성자1
	this("13:40:06");
    }

    public Watch(String curTime){                        //생성자2
	this.curTime = curTime;
    }

    public Watch(String curTime,String alarmed){         //생성자3
	this.alarmedTime = curTime + alarmed; //ex)alarmed 시간(초,분,시) 후 알람설정;
    }
    
    public String getTime(){
	return curTime;
    }
    
    public void setAlarm(String setTime){
	alarmedTime = setTime;	
    }
    
    public void actAlarm(){
	if(this.alarmedTime.equals(curTime)){
	    bell = true;
	}	
    }
}

// ---------------------------------------------------------------------------------

class BusDriver {											//class 2
    String name;
    int age = 18;
    
    Bus bus;
    Watch myWatch;

    public BusDriver(){                                   //생성자1
	this.bus = new Bus();
	this.myWatch = new Watch();
    }

    public BusDriver(String name){                         //생성자2
	this(name,this.age);
    }
    
    public BusDriver(String name, int age){                //생성자3
	this.bus = new Bus();
	this.myWatch = new Watch();
	this.name = name;
	this.age = age;
    }
    
    public void accel(){
	bus.velocity += 10;
	System.out.println("Velocity: "+bus.velocity);
	if(bus.velocity != 0){
	    bus.status = "Running";
	}
    }

    public void breaking(){
	bus.velocity -= 10;
	System.out.println("Velocity: "+bus.velocity);
	if(bus.velocity == 0){
	    bus.status = "Stopped";
	}
    }

    public void openDoor(){
	if(bus.status.equals("Stopped")){
	    bus.door = true;
	    System.out.println("열렸습니다.");
	}else {
	    System.out.println("멈춰주세요.");
	}
		
    }

    public void closeDoor(){
	if(bus.status.equals("Stopped")){
	    bus.door = false;
	    System.out.println("닫혔습니다.");
	}else {
	    System.out.println("멈춰주세요.");
	}
    }

    public void lookWatch(){
	if(bus.status.equals("Stopped")){
	    System.out.println("현재 시각은 : "+myWatch.getTime());
	    System.out.println("운행을 종료합니다.");

	}else {
	    System.out.println("운행 중 시계를 볼 수 없습니다.");
	}
    }
	
    public void getBusState(){
	System.out.println(bus.status);
    }
}

// ---------------------------------------------------------------------------------

class Bus{		                                 	//class 3
    String status;
    int velocity;
    int sheetStatus;
    boolean door;

    public Bus(){                                             //생성자1
	status = "Stopped";
	velocity = 0;
	sheetStatus = 0;
	door = false;
    }

    public Bus(int people){                                   //생성자2
	this(true,people);
    }

    public Bus(boolean door, int people){                     //생성자3
	this.door = door;
	this.sheetStatus = people;
    }
}

// ---------------------------------------------------------------------------------

public class BusDrive{
    public static void main(String args[]){
	Scanner scanner = new Scanner(System.in);
	BusDriver driver = new BusDriver();
	short sel = -1;
		
	System.out.print("당신의 이름은 무엇입니까? ");
	driver.name = scanner.next();
	System.out.print("당신의 나이는 어떻게 됩니까? ");
	driver.age = scanner.nextInt();
		
	System.out.println("사원 정보가 등록되었습니다.\n");
		
	while(sel != 0 ){
	    System.out.println("-------------------------------------------------------------------");
	    System.out.println("l 1. accel 2. break 3. Open/Close Door 4. Bus Status 5. Check Time");
	    System.out.print("--------------------------------------------------------------\n : ");
			
			
	    sel = scanner.nextShort();
			
	    switch(sel){
	    case 1:
		driver.accel();
		break;
	    case 2:
		driver.breaking();
		break;
	    case 3:
		if(driver.bus.door == false)
		    driver.openDoor();
		else 
		    driver.closeDoor();
		break;
	    case 4:
		driver.getBusState();
		break;
	    default:
		driver.lookWatch();
	    }
	}
	scanner.close();
    }
}
