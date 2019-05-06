import java.util.Scanner;

class Watch {												//class 1
    String curTime;
    String alarmedTime;
    boolean bell = false;

    public Watch(){                                      //������1
	this("13:40:06");
    }

    public Watch(String curTime){                        //������2
	this.curTime = curTime;
    }

    public Watch(String curTime,String alarmed){         //������3
	this.alarmedTime = curTime + alarmed; //ex)alarmed �ð�(��,��,��) �� �˶�����;
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

    public BusDriver(){                                   //������1
	this.bus = new Bus();
	this.myWatch = new Watch();
    }

    public BusDriver(String name){                         //������2
	this(name,this.age);
    }
    
    public BusDriver(String name, int age){                //������3
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
	    System.out.println("���Ƚ��ϴ�.");
	}else {
	    System.out.println("�����ּ���.");
	}
		
    }

    public void closeDoor(){
	if(bus.status.equals("Stopped")){
	    bus.door = false;
	    System.out.println("�������ϴ�.");
	}else {
	    System.out.println("�����ּ���.");
	}
    }

    public void lookWatch(){
	if(bus.status.equals("Stopped")){
	    System.out.println("���� �ð��� : "+myWatch.getTime());
	    System.out.println("������ �����մϴ�.");

	}else {
	    System.out.println("���� �� �ð踦 �� �� �����ϴ�.");
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

    public Bus(){                                             //������1
	status = "Stopped";
	velocity = 0;
	sheetStatus = 0;
	door = false;
    }

    public Bus(int people){                                   //������2
	this(true,people);
    }

    public Bus(boolean door, int people){                     //������3
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
		
	System.out.print("����� �̸��� �����Դϱ�? ");
	driver.name = scanner.next();
	System.out.print("����� ���̴� ��� �˴ϱ�? ");
	driver.age = scanner.nextInt();
		
	System.out.println("��� ������ ��ϵǾ����ϴ�.\n");
		
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
