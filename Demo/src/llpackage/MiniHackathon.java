package llpackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MiniHackathon {
	public static void main(String[] args) throws IOException {
		MiniHackathon m = new MiniHackathon();

		m.loadVendorData();

	}

	void loadVendorData() throws IOException {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		// please map this file to your drive
		String file = "C:\\Users\\harik\\Desktop\\Swapna\\PerScholas\\us-500.csv";
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] attributes = line.replaceAll("\"[,]|[,]\"","\b").replace("\"", "").split("\b");
				
				// adding customers into ArrayList
				Customer cust = Customer.createCust(attributes);
				customers.add(cust);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		Scanner scn = new Scanner(System.in);
		System.out.println("Please specify last name");
		String lastName = scn.nextLine();
		scn.close();
		
		boolean customerFound=false;
		for (Customer x : customers) {
			if (x.getLast_name().equalsIgnoreCase(lastName)) {
				System.out.println(x.toString());
				customerFound=true;
				break;
			}

		}
		if(!customerFound) {
			System.out.println("Given customer details are not in the file");
		}
	}

}
