 
package com.sanjana.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DNA_profile {
	private String dnaString;
	
        public DNA_profile(String dnaString){
        	this.dnaString = dnaString.toUpperCase();
        	isStringValid();
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
        
        //print all the codons (triplets)
        public void printCodons(){
        	//iterate through 1/3 the length of the string and print 3 bases at a time
        	for(int i = 0; i < dnaString.length()/3; i++){
        		System.out.println("Codon "+ i + ": "+ dnaString.substring(3*i, 3*i+3) );
        	}
        }
        
        //reverse the strand
        public void reverseStrand(){
        	System.out.println(new StringBuilder(dnaString).reverse().toString());
        }
        
        //find out if DNA strand is valid 
        public boolean isStringValid(){
        	//check if string is made up of valid bases
        	 for(int i = 0; i < dnaString.length(); i++){
             	if(dnaString.matches(".*[^ATCG].*")){
        			System.out.println("The string contains incorrect bases.");
        			return false;
             	}
             	//return false if string isn't a multiple of 3
            	if(dnaString.length() % 3 != 0){
        			System.out.println("Please provide a valid string");
        			return false;
        		}
             }
        	 return true;
        }
       
        //return the frequency of a particular pattern in the DNA strand
        public int count(String pattern){
    	
    		int counter = 0;
    		Pattern p = Pattern.compile(pattern.toUpperCase());
    		Matcher m = p.matcher(dnaString);
    		
    		while(m.find()){
    			counter++;
    		}
    		
    		return counter;
    	}
        
        //return the start codon index
        public int startIndex(){
        	return dnaString.indexOf("ATG");
        }
        
        //return the stop codon index, if present
        //make sure codon index is multiple of 3 to be valid and first stop codon is returned
        public int stopIndex(){
        	int index1 = Integer.MAX_VALUE; int index2 = Integer.MAX_VALUE; int index3 =  Integer.MAX_VALUE;
        	if(dnaString.contains("TAG") && dnaString.indexOf("TAG") % 3 == 0)  index1 = dnaString.indexOf("TAG"); 
        	if(dnaString.contains("TAG") && dnaString.indexOf("TGA") % 3 == 0)  index2 = dnaString.indexOf("TGA"); 
        	if(dnaString.contains("TAG") && dnaString.indexOf("TAA") % 3 == 0)  index3 = dnaString.indexOf("TAA"); 
        	return Math.min( Math.min(index1, index2), index3);
        }
}

 