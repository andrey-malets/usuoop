package general;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */  
  
	public static void main(String[] args) {
	  String re;	  
	  if (args.length > 0) {
	    re = args[0];
	  } else {      
      re = "[a-zA-Z]";
      System.err.println("Using default [a-zA-Z] patter");    
    }
	  Scanner scanner = new Scanner(System.in);	  	  
	  HashMap<String, Integer> map = new HashMap<String, Integer>();
	  String matched = scanner.findInLine(re);
	  while (matched != null) {	    
	    if(!map.containsKey(matched)) {
	      map.put(matched, 1);
	    } else {
	      int previos = map.get(matched);
	      map.put(matched, previos+1);
      } 	      
	    matched = scanner.findInLine(re);
	  }	  
	  for (String string : map.keySet()) {
	    System.out.println(string + " - " +map.get(string));
    }
	}
}
