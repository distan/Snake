package com.cavalier.net;

import java.net.*;

public class Reception implements Runnable {
	
	public static String smessage;
	
	 public String xiaoxi() {
			return smessage;   	
		}
	 
	public void run() {
		
		
		DatagramPacket pack=null;
		DatagramSocket postman=null;
		
		byte data[]=new byte[8192];
		Send xZhang=new Send();
	
		try {
			pack= new DatagramPacket(data, data.length);
			postman= new DatagramSocket(xZhang.xy());
		
		} catch (Exception e) {
			
		}
		while(true){
			if (postman==null) {
				break;
				
			}
			else
				try {
					postman.receive(pack);
					String message = new String(pack.getData(), 0,pack.getLength());
					smessage = message;
				
					
				} catch (Exception e) {
					
				}
		}
	}


	
	

}

