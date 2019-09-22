package phonebooklookup;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.List;
import java.io.*;
public class Phonebook {
	

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> fname = new ArrayList();
		ArrayList<String> lname = new ArrayList();
		ArrayList<String> phoneNumber = new ArrayList();
		
		int entries = readInfo(fname, lname, phoneNumber);
		
		int ret;
		ret = searchDirectory(fname, lname, phoneNumber);
		while(ret!=0) {
			ret = searchDirectory(fname, lname, phoneNumber);
		}

		
		
	}
	
	public static int readInfo(ArrayList<String> fname, ArrayList<String> lname, ArrayList<String> phoneNumber) throws FileNotFoundException {
		int numaccts = 0;
		File inputFile = new File("C:\\Users\\Oljas\\Desktop\\inputphonebook.txt");
		
		Scanner myFile = new Scanner(inputFile);
		
		while(myFile.hasNext()) {
			fname.add(myFile.next());
			lname.add(myFile.next());
			phoneNumber.add(myFile.next());
			numaccts++;
		}
		
		return numaccts;
	}
	public static int searchDirectory(ArrayList fname, ArrayList lname, ArrayList phoneNumber) {
		System.out.println("lookup, reverse-lookup, quit (l/r/q)?");
		Scanner input = new Scanner(System.in);
		String response = input.next();
		int ret = 1;
		switch(response) {
		case("l"): lookup(fname,lname,phoneNumber);
		break;
		case("r"): reverselookup(fname,lname,phoneNumber);
		break;
		case("q"):ret = 0;
		}
		return ret;
	}
	

	public static void lookup(ArrayList fname, ArrayList lname, ArrayList phoneNumber) {
		int ver0, ver1, ret = 1;
		Scanner input = new Scanner(System.in);
		
		System.out.println("last name?");	
		String lastnameresponse = input.next();
		System.out.println("firstname?");
		String firstnameresponse = input.next();
			
		ver0 = lname.indexOf(lastnameresponse);
		ver1 = fname.indexOf(firstnameresponse);
		
		if(ver0 == ver1 && ver0!=-1 ||ver1!=-1) {
			System.out.println(fname.get(ver1)+" "+lname.get(ver0)+"'s phone number is "+phoneNumber.get(ver0));
		}
		else {
			ret = 0;
			System.out.println("-- Name not found");
			
		}
		
		
	}
	public static void reverselookup(ArrayList fname, ArrayList lname, ArrayList phoneNumber) {
		int index, ret = 1;
		Scanner input = new Scanner(System.in);
		
		System.out.println("phone number (nnn-nnn-nnnn)?");
		String response = input.next();
		
		index = phoneNumber.indexOf(response);
		if(index!=-1) {
			System.out.println(response+" belongs to "+lname.get(index)+", "+fname.get(index));
		} else {
			System.out.println("-- Phone number not found");
		}
		
		
	}
	
	
	
}
