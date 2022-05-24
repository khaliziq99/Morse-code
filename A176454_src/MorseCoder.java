import java.io.*;
import java.util.*;
 
public class MorseCoder implements MorseCodeInterface {
     
    private MorseNode root;
    private int num;
 
    /**
     * constructor to build the tree
     */
    public MorseCoder() {
        root = new MorseNode();
        readTreeInfo();
    }
 
    /**
     * reads in the tree info from the text file (helper method)
     */
    private void readTreeInfo() {
        Scanner input = null;
        try {
            input = new Scanner(new File("alphabet.txt"));
        } catch (FileNotFoundException exception) {
            System.out.println("File not found!");
        }
        int num=0;
        while (input.hasNext()) {
  		  
 		   //read in letter
 		  String letter=input.next();
 		  char ltr=letter.charAt(0);
 		  String morse=input.next();
 		  num++;
 		  //System.out.println(num);

	 		if (letter.length() > 0&&!letter.equals(" ")) {
	            add(morse, ltr, num);
	        }
        }
        input.close();
    }
     
    /**
     * adds the letter to the tree based on the mcode string (helper method)
     * @param mcode the string being fed in
     * @param ltr the letter being added at the node
     */
    private MorseNode nextNode(MorseNode current, char dotOrDash) {
    	   switch (dotOrDash) {
    	      case '.':
    	         if (current.getLeft() == null)
    	            current.setLeft(new MorseNode());
    	         return current.getLeft();
    	      case '-':
    	         if (current.getRight() == null)
    	            current.setRight(new MorseNode());
    	         return current.getRight();
    	      default:
     	         throw new IllegalArgumentException("bad Morse character");
    	   }
    	}
    	 
    	/** your docs */
    	private void add(String mcode, char letter, int num1) {
    	   MorseNode current = root;
    	   for (int i = 0; i < mcode.length(); i++) {
	    	      current = nextNode(current, mcode.charAt(i));
	    	   }
    	   //System.out.println(mcode.length());
	 	   current.setLetter(letter);
	 	   current.setMorse(mcode);
	 	   current.setNum(num1);
    	}
 
    /**
     * prints out inorder tree contents 
     */
    public void inOrderPrint() {    
    	MorseNode current = root;
        printInorder(current);
    }
 
    /**
     * called by inOrderPrint to print tree contents (helper method)
     * @param current the node to print
     */
    private void printInorder(MorseNode current) {   
        if (current != null) {
        	printInorder(current.getLeft());
            System.out.print(current.getLetter()+" "+current.getMorse()+"\n");  
            printInorder(current.getRight());
        	
        }
    }
}
 