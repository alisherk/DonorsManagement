package com.alsoftware.model;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List <Member> people = Arrays.asList(
				
				new Member("1", "Weekly", "Bob", "Dylan"), 
				new Member("2", "Daily", "Mary", "Popin"), 
				new Member("3", "Yearly", "Jack", "Murphy")
				
				); 
		
		people.forEach(m-> System.out.println(m));
				
			
		
		
		
		
         Thread t = new Thread(Main::printMessage);
		 t.start();
		
	}
		
	

       
       public static void printMessage() {
    	   
    	   System.out.println("Hello");
       }
	
}
