package projekt2;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class hodina5 {
public static Scanner sc = new Scanner(System.in);
public static int ask = 0;	
public static String add="";
public static String addinfo="";
public static String namepath="";
public static String addname="";
public static String ppl="";
public static String vl="";

public static int choose=0;


	
	public static void ppl(){
		
	}
	public static void menushow(){
		
		 ppl();
		 
	     System.out.println("");
	     System.out.println("________________");
	     System.out.println("1) Add one");
	     System.out.println("2) Show all");
	     ask();
	    }
	    
	    public static void ask(){
	    ask = sc.nextInt();
	    
	    if(ask == 1){
	    add();   
	    }
	    else if(ask == 2){
	    list();    
	    }
	    else if(ask != 1 || ask != 2){
	    menushow();    
	    }

	        
	    }
	    
	    public static void add(){
	    	namepath="";
	    	addinfo="";
	        System.out.println(); 
	        System.out.println("First Name:");
	            add = sc.next();
	            if(add.matches("^\\d+(\\.\\d+)?")) {
	         System.out.println("WRONG INPUT!");
	            add();
	            }
	            addinfo = add; 
	            namepath = add;
	               
	        System.out.println("Surname:");
	            addinfo=addinfo+",";
	            add = sc.next();
	            if(add.matches("^\\d+(\\.\\d+)?")) {
	         System.out.println("WRONG INPUT!");
	            add();
	            }
	            addinfo =addinfo+ add;
	            addname = namepath + "_" + add;
	           namepath=namepath + "_" + add + ".txt"; 
	           
	            
	               
	        System.out.println("Number:");
	            addinfo=addinfo+",";
	            add = sc.next();
	            if(add.matches("^\\d+(\\.\\d+)?")) {   
	            addinfo = addinfo+ add;
	            
	            System.out.println(namepath);
	            
	            
	            // String[] AddArray = addinfo.split("-");   
	            
	            File file = new File(namepath);	            
	    		try {
	    			if (file.createNewFile()) {
	    				System.out.println("File created.");		
	    				

	    				try (BufferedWriter bw = new BufferedWriter(new FileWriter(namepath, true))) {
	    					

	    					bw.write(addinfo);
	    					bw.newLine();				
	    					bw.flush();
	    					bw.close();
	    			} catch (Exception e) {
	    				e.printStackTrace();
	    			}
	    				
	    				try (BufferedWriter bw = new BufferedWriter(new FileWriter("people.txt",true))) {
	    					

	    					bw.write(addname + "_");
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
	    		
	    		
	            
	            menushow();
	            
	            
	            
	            }
	            else {
	                System.out.println("WRONG INPUT!");
	                add();
	                 }
	            }
	    


	        	
	    	
	    	
	    
	   
	    
	    public static void list(){
	    	System.out.println("");
	    	
	     	try {
	    		String thisLine = "";
	    		BufferedReader br = new BufferedReader(new FileReader("people.txt"));
	    		while ((thisLine = br.readLine()) != null) {
	    		ppl = ppl + thisLine;
	    		}
	    		br.close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	     	
	     	String[] AddArray = ppl.split("_"); 
	     	int i=0;
	     	int num=1;
	     	while(i != AddArray.length){
	     	System.out.println(num +") " +AddArray[i] +" " + AddArray[i+1]);
	     	num++;
	     	i++;
	     	i++;
	     	}
	     	
	     	System.out.println("Choose:");

	     	choose=sc.nextInt();
	     	
	     	if(choose >= num){
	     		System.out.println("Wrong number");
	     		menushow();
	     		
	     	}
	     	int first=0;
	     	if(choose==1){
	     	first=0;	
	     	}
	     	if(choose==2){
		     	first=2;	
	     	}
	     	else if(choose != 1 || choose !=2){
	     		first=(choose-1)*2;
	     	}
	     	
	     
	     	String newpath =AddArray[first] + "_" +AddArray[first+1] +".txt";
	     	try {
	     		
	    		String thisLine = "";
	    		BufferedReader br = new BufferedReader(new FileReader(newpath));
	    		while ((thisLine = br.readLine()) != null) {
	    		vl = vl + thisLine;
	    		}
	    		br.close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}

	     	String[] AddArray2 = vl.split(",");
	     	
	     	String splito =AddArray2[2];
	     	

	     	
	     	String gender="";
	     	String[] AddArray3 = splito.split(""); 
	     	if(AddArray[2].equals("5")){
	     		gender = "Female";
	     		
	     	}
	     	else{
	     		gender = "Male";
	     	}
	     	
	     	
	     	
	     	
	     	
	     	vl=vl.replace(",", " ");
	     	System.out.println(" ");
	     	System.out.println(vl + " " +gender);
	     	
	     	
	     	
	    	
	    }
	    
	
	public static void main(String[] args) {
	
		menushow();
		
		

	}

}
