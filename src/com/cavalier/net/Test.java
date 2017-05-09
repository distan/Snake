package com.cavalier.net;

import java.net.*;
import java.util.*;


public class Test {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Thread readData ;
		Tests receiver = new Tests();
		try {
			readData = new Thread (receiver);
			readData.start();
			byte [] buffer=new byte[1];
			InetAddress address=InetAddress.getByName("127.0.0.1");
			DatagramPacket dataPack = 
			new DatagramPacket(buffer, buffer.length,address,8888);
		
			@SuppressWarnings("resource")
			DatagramSocket postman=new DatagramSocket();
			System.out.print(" ‰»Î");
			while (scanner.hasNext()) {
				String mess = scanner.nextLine();
				buffer= mess.getBytes();
				if(mess.length()==0)
					System.exit(0);
				buffer=mess.getBytes();
				dataPack.setData(buffer);
				postman.send(dataPack);
				System.out.print("ºÃ–¯ ‰»Î");
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}


