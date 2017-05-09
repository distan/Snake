package com.cavalier.game;


import java.sql.*;

public class Search {
	String datasourceName = "signups";
	String modescore;
	String []name = new String[5];
	int []scores = new int[5];
	public Search(){
		try {
			Class.forName("com.hxtt.sql.access.AccessDriver").newInstance();
		} catch (Exception e) {
			System.out.println("加载数据库失败");
			e.printStackTrace();
		}
	}
	
	public boolean searchName(String user) {
		boolean flag = false;
		Connection con = null;
		Statement sql = null;
		String username = null;
		ResultSet rs1;
		try{	
			String url ="jdbc:Access:///src//db//"+datasourceName+".mdb";
			
			con = DriverManager.getConnection(url,"","");
			sql = con.createStatement();
			rs1 = sql.executeQuery("SELECT username FROM information");
			while(rs1.next()){
				username = rs1.getString("username");
				if(username.equals(user)){
					flag = true;
					break;
				}
			}
			con.close();
			sql.close();
		}
		catch (SQLException e) {
			System.out.println("请输入正确的表名"+e);
			}
		return flag;
		}
	
	
	
	public boolean searchKey(String user,String key){
		boolean flag2 = false;
		try{	 
			Connection con = null;
			Statement sql = null;
			ResultSet rs2;
			String passwords = null;
			String url ="jdbc:Access:///src//db//"+datasourceName+".mdb";
			con = DriverManager.getConnection(url,"","");
			sql = con.createStatement();
			rs2 = sql.executeQuery("SELECT password FROM information WHERE username='"+user+"'");
			while(rs2.next()){
				passwords = rs2.getString("password");
				if(key.equals(passwords)){
					flag2 = true;
				}
			}
			con.close();
			sql.close();
		}
		catch (SQLException e) {
			System.out.println("请输入正确的表名"+e);
			}
		return flag2;
		}
	
	public boolean searchScore(String userflag,int score,int mode){
		String user = userflag;
		boolean flag3 = false;
		if(mode==1)		modescore = "mode1score";
		if(mode==2) 	modescore = "mode2score";
		if(mode==3)		modescore = "mode3score";
		try{	 
			Connection con = null;
			Statement sql = null;
			ResultSet rs3;
			int scores = 0;
			String url ="jdbc:Access:///src//db//"+datasourceName+".mdb";
			con = DriverManager.getConnection(url,"","");
			sql = con.createStatement();
			rs3 = sql.executeQuery("SELECT "+modescore+" FROM information WHERE username='"+user+"'");
			while(rs3.next()){
				scores = rs3.getInt(modescore);
				if(scores <= score){
					flag3 = true;
				}
			}
			con.close();
			sql.close();
		}
		catch (SQLException e) {
			System.out.println("请输入正确的表名"+e);
			}
		return flag3;
		}
	public void readScore(int mode){
		if(mode==1)		modescore = "mode1score";
		if(mode==2) 	modescore = "mode2score";
		if(mode==3)		modescore = "mode3score";
		try{	 
			Connection con = null;
			Statement sql = null;
			ResultSet rs4;
			int i = 0; 
			String url ="jdbc:Access:///src//db//"+datasourceName+".mdb";
			con = DriverManager.getConnection(url,"","");
			sql = con.createStatement();
			rs4 = sql.executeQuery("SELECT username,"+modescore+" FROM information order by "+modescore+" desc");
			while(rs4.next()&&i<=4){
				name[i] = rs4.getString("username");
				scores[i] = rs4.getInt(modescore);
				i++;
			}
			con.close();
			sql.close();
		}
		catch (SQLException e) {
			System.out.println("请输入正确的表名"+e);
			}
		}
	}