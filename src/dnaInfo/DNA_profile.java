package dnaInfo;

public class DNA_profile {
	private String dnaString;
	
        public DNA_profile(String dnaString){
        	this.dnaString= dnaString.toUpperCase();
        }
        
        //a simple function to calculate the GC content of the DNA string
        public int calculateGC(){
        	int count =0;
        	if(dnaString.length() == 0) return 0;
        	for(int i=0; i< dnaString.length(); i++){
        		if (dnaString.charAt(i) == 'G'|| dnaString.charAt(i) == 'C')
        			count++;
        	}
  
       }
}
