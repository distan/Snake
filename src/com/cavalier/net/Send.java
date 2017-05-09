package com.cavalier.net;
import java.net.*;

public class Send  {
	static int b;
	static int c;
	static String IIp;
	public static String smess;
	static int t;
	
    public int xy() {
		return b;
	}
    public int xyz() {
		return c;	
	}
    public String xyzz() {
		return IIp;
	}
    public String mxyzz(){
		return smess;	
	}
    
	public static void main(String[] args) {
		int t=1;
		Thread readData;
		Send zZhang=new Send();//iP
		Send qZhang=new Send();//c
		Send messZhang=new Send();
		Reception receiver = new Reception();
		try {
			readData = new Thread(receiver);
			readData.start();
			byte [] buffer=new byte[1];
			InetAddress address=InetAddress.getByName(zZhang.xyzz());
			DatagramPacket dataPack = 
			new DatagramPacket(buffer, buffer.length,address,qZhang.xyz());
			@SuppressWarnings("resource")
			DatagramSocket postman=new DatagramSocket();
			while (t==1) {
				String mess =  messZhang.mxyzz();
				buffer= mess.getBytes();
				if(mess.length()==0)
					System.exit(0);
				buffer=mess.getBytes();
				dataPack.setData(buffer);
				postman.send(dataPack);
				t--;	
				}
		} 
		catch (Exception e) {
			System.out.println(e);
			}
		}
	}
