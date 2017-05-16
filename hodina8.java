package projekt2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class hodina8{
	public static Scanner sc = new Scanner(System.in);
	public static String path="appointments.txt";
	public static File file = new File(path);
	public static String info;
	public static String text;
	
	public static void currentInfo(){
	       Date currentDate = new Date();
	       DateFormat time = new SimpleDateFormat("HH:mm");
	       DateFormat date = new SimpleDateFormat("E, MMM dd yyyy");
	       try
	       {
	   			System.out.println("********************");
	           String datex = date.format(currentDate);
	           System.out.println("" + datex);
	           String timex = time.format(currentDate);
	           System.out.println("Time: "  + timex);

	       }
	       catch (Exception ex ){
	          System.out.println(ex);
	       }
	}
	public static void menu(){
			currentInfo();
	System.out.println("");
	System.out.println("1)Create Appointment");
	System.out.println("2)Delete Appointment");
	System.out.println("3)Show Appointments");
	
	int mc = sc.nextInt();
	if(mc == 1){create();}
	if(mc == 2){delete();}
	if(mc == 3){list(path);}
	if(mc != 1 || mc != 2 || mc != 3 ){menu();}
	
	}
	public static void create(){
m();
		String ask;
	System.out.println("");
	System.out.println("**********CREATE APPOINTMENT*********");
	System.out.println("Name:");
	ask=sc.nextLine();
	ask=sc.nextLine();
	info="," +ask;
	
	System.out.println("Day:");
	ask=sc.nextLine();
	info=info +"," +ask;
	
	System.out.println("Month:");
	ask=sc.nextLine();
	info=info +"," +ask;
	
	System.out.println("Year:");
	ask=sc.nextLine();
	info=info +"," +ask;
	
	System.out.println("(XX:YY)Time:");
	ask=sc.nextLine();
	info=info +"," +ask +",@";
	
	
	writer();


	}
	public static void delete(){
	list(path);
	System.out.println();
	System.out.println("Enter Name to Delete:");
	String x =sc.nextLine();
	reader();
	String[] textSplit = text.split(","); 
	
	int a=0;
	int b=1;
	while (a==0){
		if(b>=textSplit.length){
			System.out.println("Error!");
			menu();
		}
		if(textSplit[b].equals(x)){
			a++;
		}
		b=b+6;
	}
	
	
	}
	public static void reader(){
		text="";
		try {
			String thisLine = "";
			BufferedReader br = new BufferedReader(new FileReader(path));
			while ((thisLine = br.readLine()) != null) {
			text=text + thisLine;
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void list(String path) {
		reader();
	 	String[] textSplit = text.split(","); 
	 	int x=0;
	 	int a=1;
	 	int y=1;
	 	m();
	 	System.out.println("**********APPOINTMENTS**********");
	 	while(x==0){
	 		System.out.println(a +") " +textSplit[y] +" | " +textSplit[y+1] +"/" +textSplit[y+2] +"/" +textSplit[y+3] +" | " +textSplit[y+4]);
	 		y=y+6;
	 	if(y==textSplit.length){
	 		x++;
	 	}
	 	a++;
	 	}
	 	System.out.println("********************************");
	 	System.out.println();
	 	menu();
	 	
		
	}
	public static void check(){
		try {
			if (file.createNewFile()) {
				System.out.println();		
				file.createNewFile();
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
					

					bw.write("@");
					bw.newLine();


					
				bw.flush();
				bw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
				
				
				
				
				
			} else {
				System.out.println("");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		
		
	}
	public static void writer(){

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
			

			bw.write(info);
			bw.newLine();
			bw.flush();
			bw.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		//information --------------------------------------
		System.out.println("Appointment Created!");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		m();
		menu();
	}
	public static void m(){
		int x=0;
		while(x<50){
			System.out.println();
			x++;
		}
		
	}
	public static void main(String args[])
   {
		m();
		check();
		menu();
       
       
       
       
    }
}
