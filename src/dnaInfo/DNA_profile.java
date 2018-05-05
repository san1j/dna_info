package dnaInfo;

public class DNA_profile {
	private String dnaString;
	
        public DNA_profile(String dnaString){
        	this.dnaString = dnaString.toUpperCase();
        }
        
        //a simple function to calculate the GC content of the DNA string
        public int calculateGC(){
        	int count = 0;
        	int ratio = 0;
        	if(dnaString.length() == 0) return 0;
        	for(int i= 0; i< dnaString.length(); i++){
        		if (dnaString.charAt(i) == 'G'|| dnaString.charAt(i) == 'C')
        			count++;
        	}
        	ratio = count / dnaString.length() ;
        	return ratio;
        }
        
        //function to find the complement of the DNA string
        public String findComplement(){
        	StringBuilder complement = new StringBuilder();
        	for(int i= 0; i< dnaString.length(); i++){
        		if(dnaString.charAt(i) == 'A') complement.append("T");
        		if(dnaString.charAt(i) == 'T') complement.append("G");
        		if(dnaString.charAt(i) == 'G') complement.append("C");
        		if(dnaString.charAt(i) == 'C') complement.append("G");
        	}
        	return complement.toString();
        }
        
        
        
        
        
        
}
