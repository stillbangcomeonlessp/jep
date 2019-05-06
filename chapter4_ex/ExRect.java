import java.util.Scanner;

class Rect {
    private int width, height;
    public Rect(int width, int height){
	this.width = width;
	this.height = height;
    }

    public int getArea(){ return width*height;}
}

public class ExRect {
    public static void main(String[] args){
	Scanner scanner = new Scanner(System.in);
	int width,height;
	
	System.out.print("1 너비와 높이 >>");
	width = scanner.nextInt();
	height = scanner.nextInt();
	Rect rectA = new Rect(width,height);

	System.out.print("1 너비와 높이 >>");
	width = scanner.nextInt();
	height = scanner.nextInt();
	Rect rectB = new Rect(width,height);

	System.out.println("저장하였습니다...");
	System.out.println("사각형 전체의 합은 "+(rectA.getArea()+rectB.getArea()));
    }
}
