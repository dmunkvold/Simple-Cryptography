package cryptography;
import java.util.*;


public class crypto {
	
	 /*
	  * this program is a simple encryption and decryption program that takes 
	  * a message and a number key, shifts all of the letters in the message
	  * by that number key in the alphabet, then returns an encrypted message. If
	  * the user wants to decrypt the message, they simply enter the message and the 
	  * number and the decryptor will do the opposite procedure. This program is
	  * obviously not very secure because the "hacker" would only have to 
	  * try 27 times before reaching the solution, but it is good practice with
	  * data types :)
	  * The only fields I use are the key, the message, and the alphabet.
	  */
	
	
	public static int key;
	public static String message;
	public final String alphabet = "abcdefghijklmnopqrstuvwxyz ";

	
	public crypto(String newmessage, int newkey){
		message = newmessage;
		key = newkey;
	}
	
	/*
	 * the methods required for this program are get functions for the key and 
	 * message (encrypted or not), and the encryptor and decryptor themselves
	 */
	
	
	public String getMessage(){
		return message;
	}
	public int getKey(){
		return key;
	}

	
	/*
	 * The encryptor method declares two new arrays, one of integers and one of 
	 * characters. they are intitialized with the length of the message, and for each 
	 * spot in the message, a number in the alphabet that corresponds to the letter
	 * in the message is added to the secretint array, and then that number is
	 * shifted by the key, and then the character that corresponds to this new number 
	 * is added to the secret array, which is printed as the new message.
	 */
	
	
	public char encrypt(){
		int[] secretint;
		char[] secret;
		secretint = new int[message.length()];
		secret = new char[message.length()];
		for (int z=0;z<message.length();z++){
			if (alphabet.indexOf(message.charAt(z)) == -1){
				secretint[z] = 26+key;
			} else {
				secretint[z] = alphabet.indexOf(message.charAt(z))+key;
			}
			if (secretint[z] > 26){
				secretint[z] = secretint[z] - 27;
			} 
			secret[z] = alphabet.charAt(secretint[z]);
		}
		System.out.print(secret);
		return ' ';
	}

	
	/*
	 * the decrypt method does the same thing as the encrypt method but in reverse.
	 */
	
	
	public char decrypt(){
		int[] secretint2;
		char[] realmes;
		secretint2 = new int[message.length()];
		realmes = new char[message.length()];
		for (int z=0; z<message.length();z++){
			secretint2[z] = alphabet.indexOf(message.charAt(z)) - key;
			if (secretint2[z]<0){
				secretint2[z] = secretint2[z] +27;
			}
			realmes[z] = alphabet.charAt(secretint2[z]);	
		}
		System.out.print(realmes);
		return ' ';
	}
	
	
	/*
	 * the main method uses a scanner to retrieve input from the user such as the message
	 * and the key, and whether the user wants to encrypt or decrypt a message.
	 */
	
	
	public static void main(String[]args){
		int g;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter 0 if you want to encrypt and 1 if you want to decrypt");
		g = in.nextInt();
		
		Scanner mes = new Scanner(System.in);
		
		System.out.println("Enter the message");
		message = mes.nextLine();
		
		Scanner numkey = new Scanner(System.in);
		
		System.out.println("Enter the key (between 0 and 26)");
		key = numkey.nextInt();
		
		crypto myMessage = new crypto(message, key);
		
		
		if (g == 0) {
			System.out.println("Your encrypted message is: ");
			myMessage.encrypt();
		}
		if (g == 1) {
			System.out.println("Your decrypted message is: ");
			myMessage.decrypt();
		}
	}
}


/*
 * code written by 
 * David Munkvold
 * 6/30/15
 */

	
		


