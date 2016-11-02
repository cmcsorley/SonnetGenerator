import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import java.util.Scanner;
import java.util.Random;

public class SonnetGenerator{

    //if something goes wrong, we might see a TwitterException
    public static void main(String... args) throws TwitterException, FileNotFoundException, InterruptedException{

        //access the twitter API using your twitter4j.properties file
        Twitter twitter = TwitterFactory.getSingleton();
        
        while(true){
        //send a tweet
        Status status = twitter.updateStatus(poemCreator("sonnets1.txt"));
        //print a message so we know when it finishes
        System.out.println("Sleeping.");
        Thread.sleep(60*60*1000);
        }
    }
    
    public static String poemCreator(String file) throws FileNotFoundException{
    	Scanner scnr1 = new Scanner(new File(file)); //scanner for first line
    	Scanner scnr2 = new Scanner(new File(file)); //scanner for second line
    	Scanner scnr3 = new Scanner(new File(file)); //scanner for third line
    	String poem=""; //initialize string for the final poem
    	Random rand = new Random();
    	for(int i=0; i<rand.nextInt(2152)-1; i++){
    		scnr1.nextLine(); //go to a random line
    	}
    	String poem1 = scnr1.nextLine(); //set poem1 to that line
    	scnr1.close();
    	for(int i=0; i<rand.nextInt(2152)-1; i++){
    		scnr2.nextLine(); //different random line
    	}
    	String poem2 = scnr2.nextLine(); //set poem2 to that line
    	scnr2.close();
    	for(int i=0; i<rand.nextInt(2152)-1; i++){
    		scnr3.nextLine(); //different random line
    	}
    	String poem3 = scnr3.nextLine(); //set poem3 to that line
    	scnr3.close();
    	poem=poem1+"\n"+poem2+"\n"+poem3;
    	if(poem.length()>140){ //if three lines put over 140 chars
    		poem=poem1+"\n"+poem2; //just use the first two lines
    	}
    	return poem;
    }
}