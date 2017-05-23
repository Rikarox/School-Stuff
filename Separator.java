package appointer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Separator {
	public static String text;
	public static String path="directory.txt";
	public static Date currentDate = new Date();
	public static String aft ="";
	public static String bf ="";
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
		
		
		
		String[] textSplit = text.split(";"); 
		
		
		int x=1;
		int a=0;
		String sepdate="";
		
		
		//System.out.println("Upcomming Appointments:");
		//System.out.println();
		while (a<textSplit.length){
	
	sepdate ="";
	sepdate = sepdate+textSplit[a];
	sepdate=sepdate.replace(" ", "/");
	sepdate=sepdate.replace(":", "/");
	String[] sepdateSplit = sepdate.split("/");
	
	int day= Integer.parseInt(sepdateSplit[0]);
	int month= Integer.parseInt(sepdateSplit[1]);
	int year= Integer.parseInt(sepdateSplit[2]);
	int hh= Integer.parseInt(sepdateSplit[3]);
	int min= Integer.parseInt(sepdateSplit[4]);
	

	
	 
	@SuppressWarnings("deprecation")
	Date testDate = new Date(year-1900,month-1,day,hh,min);
	
	if (currentDate.after(testDate)) {
			bf=bf+textSplit[a] +","  +textSplit[a+1] +",";
       } else {
    	   // System.out.println(textSplit[a] +" Name: " +textSplit[a+1]);;
    	   aft=aft+textSplit[a] +"," +textSplit[a+1] +",";
       }
	
	a=a+2;
		}
		
		vypis();
		
		
		
	}

		public static void vypis(){
		
			System.out.println("Upcomming:");
			System.out.println();
			int ax=0;
			//System.out.println(aft);
			String[] aftS = aft.split(",");  
			while(ax<aftS.length){
				System.out.println(aftS[ax] +" Name: " +aftS[ax+1]);
				ax=ax+2;
			}
			
			System.out.println("Ended:");
			System.out.println();
			ax=0;
			String[] bfS = bf.split(",");  
			while(ax<bfS.length){
				System.out.println(bfS[ax] +" Name: " +bfS[ax+1]);
				ax= ax+2;
			}
			
		}
	
	public static void main(String[] args) {
		
		reader();
		
	    
			//System.out.println(currentDate);
	       
		/*Date xd = new Date(2016-1900, 8-1, 03, 20, 15);
		
	       
	       DateFormat time = new SimpleDateFormat("dd/MM/YYYY/HH:mm");
	       
	       
           String datex = time.format(currentDate);
          
           System.out.println(xd);
           System.out.println("x");
           System.out.println(currentDate);
           
           if (currentDate.before(xd)) {
       		System.out.println("uz po");
       		
           } else {
        	   System.out.println("pred");
           }
    	
    */

           
		
		
		
		

	}

}
