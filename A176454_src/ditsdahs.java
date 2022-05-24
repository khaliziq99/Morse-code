import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ditsdahs {
	public static void main (String [] args) throws IOException
	 {
	  //arrays for letters and Morse Code values
		Scanner sc=new Scanner(System.in);
	  String [] letter = new String [49]; 
	  String [] morseCode = new String [49];
	  char [] letter1=new char[49];
	  char symbol[] = new char[15];
	  char alphabet[] = new char[26];
	  char number[]=new char[10];
	  String morseSymbol[] = new String[15];
	  String morseAlphabet[] = new String[26];
	  String morseNumber[]=new String[10];
	  //this is the file with the letters and morse code equivalent
	  File file1 = new File ("alphabet.txt");
	  Scanner in = new Scanner(file1);  
	  int k = 0,d=0,e=0,f=0,g=0,h=0,n=0;

	  while (in.hasNext()) {
		  
		   //read in letter
		  letter[k]=in.next();
		   letter1[k]=letter[k].charAt(0);
		   if (letter1[k]=='1'||letter1[k]=='2'||letter1[k]=='3'||letter1[k]=='4'||
				   letter1[k]=='5'||letter1[k]=='6'||letter1[k]=='7'||letter1[k]=='8'||
						   letter1[k]=='9'||letter1[k]=='0') {
			   number[d]=letter1[k];
			   d++;
		   }
		   else if (letter1[k]=='A'||letter1[k]=='B'||letter1[k]=='C'||letter1[k]=='D'||letter1[k]=='E'||
				   letter1[k]=='F'||letter1[k]=='G'||letter1[k]=='H'||letter1[k]=='I'||letter1[k]=='J'||
				   letter1[k]=='K'||letter1[k]=='L'||letter1[k]=='M'||letter1[k]=='N'||letter1[k]=='O'|| 
			   		letter1[k]=='P'||letter1[k]=='Q'||letter1[k]=='R'||letter1[k]=='S'||letter1[k]=='T'||
					letter1[k]=='U'||letter1[k]=='V'||letter1[k]=='W'||letter1[k]=='X'||letter1[k]=='Y'||letter1[k]=='Z'){
			   alphabet[e]=letter1[k];
			   e++;
		   }
		   else {
			   symbol[f]=letter1[k];
			   f++;
		   }
		   //read in Morse Code  
		   morseCode[k]=in.next();
		   if (letter1[k]=='1'||letter1[k]=='2'||letter1[k]=='3'||letter1[k]=='4'||
				   letter1[k]=='5'||letter1[k]=='6'||letter1[k]=='7'||letter1[k]=='8'||
						   letter1[k]=='9'||letter1[k]=='0') {
			   morseNumber[g]=morseCode[k];
			   g++;
		   }
		   else if (letter1[k]=='A'||letter1[k]=='B'||letter1[k]=='C'||letter1[k]=='D'||letter1[k]=='E'||
				   letter1[k]=='F'||letter1[k]=='G'||letter1[k]=='H'||letter1[k]=='I'||letter1[k]=='J'||
				   letter1[k]=='K'||letter1[k]=='L'||letter1[k]=='M'||letter1[k]=='N'||letter1[k]=='O'|| 
			   		letter1[k]=='P'||letter1[k]=='Q'||letter1[k]=='R'||letter1[k]=='S'||letter1[k]=='T'||
					letter1[k]=='U'||letter1[k]=='V'||letter1[k]=='W'||letter1[k]=='X'||letter1[k]=='Y'||letter1[k]=='Z'){
			   morseAlphabet[h]=morseCode[k];
			   h++;
		   }
		   else {
			   morseSymbol[n]=morseCode[k];
			   n++;
	   }
	   k++;
	        }


	  System.out.println("\nMenu:\n");
      System.out.println("1. Send Morse Message ");
      System.out.println("2. Receive Morse Message");
      System.out.println("3. Print Letters and Morse Code");
      System.out.println("4. Exit"); 

      int choice = sc.nextInt();            
      while(choice!=4) {
      if (choice==1) {
    	  File file2 = new File ("wordtomorse.dat");
    	  Scanner data = new Scanner(file2);
    	  
    	  FileOutputStream writer = new FileOutputStream("message.txt");

    	  //this appends the data to the file and keeps a running input 
    	  FileWriter fWriter = new FileWriter("message.txt", true);
    	  PrintWriter outPutFile = new PrintWriter(fWriter);

    	  boolean found; 
    	  int  number1 = morseCode.length; 
    	  int a=0,b=0,c=0,num=0,alp=0,sym=0;
    	  String answer1="";
    	  List <String> list1=new ArrayList<String>();
    	  while (data.hasNext())
    	  {
    		   //reads each line of mesage
    		  String sentence = data.nextLine(); 
    		  sentence = sentence.toUpperCase(); //Because morse code is defined only for the lower case letters and the numbers and the Symbols will remain the Same
    	      if (!sentence.equals("EOT")) {
    	    	  char[] morsec = sentence.toCharArray();
    	          String answer="";
    	          for(int i = 0; i < morsec.length;i++)  //The loop will run till i is less than the number of characters in the Sentence because Every Character needs to Be Converted into the Respective Morse Code 
    	          {//For Every Letter in the User Input Sentence
    	              for(int j = 0;j<letter1.length;j++)   //For Every Character in the morsec array we will have to traverse the entire English Array and find the match so that it can be represented 
    	              {
    	                  if(letter1[j] == morsec[i])  //If the Character Present in English array is equal to the character present in the Morsec array then Only Execute 
    	                  {//Always remember that the condition in the Inner loop will be the first to be Equated in the If Statement because that will change until the characters match 
    	                	  answer = answer + morseCode[j] + " ";  //After Every Letter is generated in the Morse Code we will give a Space 
    	                	  //System.out.println(answer);
    	                  }  //Since the Letters in the English char and the symbols present in the morse array are at the Same Index 
    	              }
    	              if (morsec[i]!=' ') {
    	            	  a++;
    	            	  for (int j=0;j<number.length;j++) {
    	            		  if (morsec[i]==number[j]) {
    	            			  num++;
    	            		  }
    	            	  }
    	            	  for (int j=0;j<alphabet.length;j++) {
    	            		  if (morsec[i]==alphabet[j]) {
    	            			  alp++;
    	            		  }
    	            	  }
    	            	  for (int j=0;j<symbol.length;j++) {
    	            		  if (morsec[i]==symbol[j]) {
    	            			  sym++;
    	            		  }
    	            	  }
    	              }
    	              else if(morsec[i]==' ') {
    	            	  answer=answer+"| ";
    	              }
    	              
    	          }
    	          String [] word=sentence.split(" ");
    	    	  for (String str : word) {
    	    		  str=str.trim();
    	    		  list1.add(str);
    	    		  //System.out.print(str+" ");
    	    	  }  
    	    	  c=list1.size();
    	          b++;
    	          System.out.println(answer);
    	          outPutFile.println(answer);
    	      }
    	      else if (sentence.equals("EOT")){
    	    	  char[] morsec1 = sentence.toCharArray();
    	          for(int i = 0; i < morsec1.length;i++)  //The loop will run till i is less than the number of characters in the Sentence because Every Character needs to Be Converted into the Respective Morse Code 
    	          {//For Every Letter in the User Input Sentence
    	              for(int j = 0;j<letter1.length;j++)   //For Every Character in the morsec array we will have to traverse the entire English Array and find the match so that it can be represented 
    	              {
    	                  if(letter1[j] == morsec1[i])  //If the Character Present in English array is equal to the character present in the Morsec array then Only Execute 
    	                  {//Always remember that the condition in the Inner loop will be the first to be Equated in the If Statement because that will change until the characters match 
    	                	  answer1 = answer1 + morseCode[j] + " ";  //After Every Letter is generated in the Morse Code we will give a Space 
    	                	  //System.out.println(answer);
    	                  }  //Since the Letters in the English char and the symbols present in the morse array are at the Same Index 
    	                  
    	              }
    	          }
    	      }
    	  }
    	  String ml=String.valueOf(b); // ml stand for total line in morse
    	  String mw=String.valueOf(c); // mw stand for total word in morse 
    	  String ma=String.valueOf(a); // ma stand for total alphabet in morse
    	  String ms=String.valueOf(sym); // ms stand for total symbol in morse
    	  String mn=String.valueOf(num); // mn stand for total number in morse
    	  for (int i=0;i<ml.length();i++) {
    		  for (int j=0;j<morseNumber.length;j++) {
    			  if (ml.charAt(i)==number[j]) {
    				  System.out.print(morseNumber[j]+" ");
    				  outPutFile.print(morseNumber[j]);
    			  }
    		  }
    	  }
    	  outPutFile.println();
    	  System.out.println();
    	  for (int i=0;i<mw.length();i++) {
    		  for (int j=0;j<morseNumber.length;j++) {
    			  if (mw.charAt(i)==number[j]) {
    				  System.out.print(morseNumber[j]+" ");
    				  outPutFile.print(morseNumber[j]+" ");
    			  }
    		  }
    	  }
    	  outPutFile.println();
    	  System.out.println();
    	  for (int i=0;i<ma.length();i++) {
    		  for (int j=0;j<morseNumber.length;j++) {
    			  if (ma.charAt(i)==number[j]) {
    				  System.out.print(morseNumber[j]+" ");
    				  outPutFile.print(morseNumber[j]+" ");
    			  }
    		  }
    	  }
    	  outPutFile.println();
    	  System.out.println();
    	  for (int i=0;i<ms.length();i++) {
    		  for (int j=0;j<morseNumber.length;j++) {
    			  if (ms.charAt(i)==number[j]) {
    				  System.out.print(morseNumber[j]+" ");
    				  outPutFile.print(morseNumber[j]+" ");
    			  }
    		  }
    	  }
    	  outPutFile.println();
    	  System.out.println();
    	  for (int i=0;i<mn.length();i++) {
    		  for (int j=0;j<morseNumber.length;j++) {
    			  if (mn.charAt(i)==number[j]) {
    				  System.out.print(morseNumber[j]+" ");
    				  outPutFile.print(morseNumber[j]+" ");
    			  }
    		  }
    	  }
    	  outPutFile.println();
    	  System.out.println();
    	  System.out.println(answer1);
    	  outPutFile.println(answer1);
    	  outPutFile.println();
    	  outPutFile.close();
      }
      else if(choice==2) {
    	  File file3 = new File ("morsetoword.dat");
    	  Scanner data1 = new Scanner(file3);
    	  
    	  File file4 = new File ("wordtomorse.dat");
    	  Scanner data2 = new Scanner(file4);
    	  
    	  FileOutputStream writer1 = new FileOutputStream("message2.txt");

    	  //this appends the data to the file and keeps a running input 
    	  FileWriter fWriter1 = new FileWriter("message2.txt", true);
    	  PrintWriter outPutFile1 = new PrintWriter(fWriter1);

    	  boolean found1; 
    	  //int  number1 = morseCode.length; 
    	  int a1=0,b1=0,c1=0,num1=0,alp1=0,sym1=0,c4=0,c2=0,c3=0;
    	  
    	  List <String> list2=new ArrayList<String>();
    	  Queue <String> q1=new Queue<String>();
    	  Queue <String> q2=new Queue<String>();
    	  String [] comp=new String[5]; //compare with the previous message
    	  String answer="";
    	  while (data1.hasNext())
    	  {
    		   //reads each line of mesage
    		  String answer2="";
    		  String sentence = data1.nextLine(); 
    		  sentence = sentence.toUpperCase(); //Because morse code is defined only for the lower case letters and the numbers and the Symbols will remain the Same
    		  String [] words=sentence.split(" ");
    	      int ab=0;
    	      for (String str : words) {
    	  		str=str.trim();
    	  		//System.out.print(str+" ");
    	  		q1.enqueue(str);
    	  		//System.out.println(str);
    	  		ab++;
    	  		}

    	      //System.out.println();
    	      //System.out.println(q1);
    	      //System.out.println(ab);
    	      String qr;
    	      String temp="";
    	      for (int i=0;i<ab;i++) {
    	    	  qr=q1.dequeue();
    	    	  for (int j=0;j<morseCode.length;j++) {
    	    		  if (morseCode[j].equals(qr)) {
    	    			  answer=answer+letter[j];
    	    			  answer2=answer2+letter[j];
    	    			  if (c4>=5&&c4!=10) {
    	    				  temp=temp+letter[j];
    	    			  }
    	        	  }
    	    		  
    	    	  }
    	    	  if (qr.equals("|")) {
    				  answer=answer+" ";
    				  answer2=answer2+" ";
    			  }
    	    	  
    	      }
    	      if (c4>=5&&c4!=10) {
    	    	  comp[c2]=temp;
    	    	  c2++;
    	    	  System.out.println(c2);
    	      }
    	      c4++;
    	      //System.out.println();
    	      answer=answer+"\n";
    	      outPutFile1.println(answer2);
    	      
    	  }
    	  System.out.println(answer);
    	  //outPutFile.println(answer);
    	  outPutFile1.close();
    	  while (data2.hasNext())
    	  {
    		   //reads each line of mesage
    		  String sentence = data2.nextLine(); 
    		  sentence = sentence.toUpperCase(); //Because morse code is defined only for the lower case letters and the numbers and the Symbols will remain the Same
    	      if (!sentence.equals("EOT")) {
    	    	  char[] morsec = sentence.toCharArray();
    	          for(int i = 0; i < morsec.length;i++)  //The loop will run till i is less than the number of characters in the Sentence because Every Character needs to Be Converted into the Respective Morse Code 
    	          {//For Every Letter in the User Input Sentence
    	              if (morsec[i]!=' ') {
    	            	  a1++;
    	            	  for (int j=0;j<number.length;j++) {
    	            		  if (morsec[i]==number[j]) {
    	            			  num1++;
    	            		  }
    	            	  }
    	            	  for (int j=0;j<alphabet.length;j++) {
    	            		  if (morsec[i]==alphabet[j]) {
    	            			  alp1++;
    	            		  }
    	            	  }
    	            	  for (int j=0;j<symbol.length;j++) {
    	            		  if (morsec[i]==symbol[j]) {
    	            			  sym1++;
    	            		  }
    	            	  }
    	              }
    	              
    	          }
    	          String [] word=sentence.split(" ");
    	    	  for (String str : word) {
    	    		  str=str.trim();
    	    		  list2.add(str);
    	    		  //System.out.print(str+" ");
    	    	  }  
    	    	  c1=list2.size();
    	          b1++;
    	      }
    	  }
    	  String ml1=String.valueOf(b1); // ml stand for total line in morse
    	  String mw1=String.valueOf(c1); // mw stand for total word in morse 
    	  String ma1=String.valueOf(a1); // ma stand for total alphabet in morse
    	  String ms1=String.valueOf(sym1); // ms stand for total symbol in morse
    	  String mn1=String.valueOf(num1); // mn stand for total number in morse
    	  
    	  if (ml1.equals(comp[0])) {
    		  c3++;
    		  System.out.print(ml1+" ");
    	  }
    	  if (mw1.equals(comp[1])) {
    		  c3++;
    		  System.out.print(mw1+" ");
    	  }
    	  if (ma1.equals(comp[2])) {
    		  c3++;
    		  System.out.print(ma1+" ");
    	  }
    	  if (ms1.equals(comp[3])) {
    		  c3++;
    		  System.out.print(ms1+" ");
    	  }
    	  if (mn1.equals(comp[4])) {
    		  c3++;
    		  System.out.print(mn1+" ");
    	  }
    	  System.out.println();
    	  if (c3==5) {
    		  System.out.println("Consistent Summary");
    	  }
    	  else {
    		  System.out.println("Inconsistent Summary");
    	  }
      }
      else if (choice==3) {
    	  MorseCoder mc = new MorseCoder();   
          mc.inOrderPrint();
    	  
      }
      System.out.println("\nMenu:\n");
      System.out.println("1. Send Morse Message ");
      System.out.println("2. Receive Morse Message");
      System.out.println("3. Print Letters and Morse Code");
      System.out.println("4. Exit"); 

      choice = sc.nextInt();
      }
    System.out.println("bye dits dahs..");
      
      
}
}

