package com.cavalier.game;
import java.sql.*;
/*
 * ���ݿ����
 */
public class EditAccess {
	String datasourceName = "";
	String SQL,message = "";
	ResultSet rs;
	public EditAccess(){
		try {
			Class.forName("com.hxtt.sql.access.AccessDriver").newInstance();
		} catch (Exception e) {
			System.out.println("�������ݿ�ʧ��");
			e.printStackTrace();
		}
	}
	
	public void setSQL(String SQL){
		this.SQL = SQL;
	}
	
	public void setDatasourceName(String s){
		datasourceName = s.trim();
	}
	
	public String record() {
		try{	 
			Connection con = null;
			Statement sql = null;
			String url ="jdbc:Access:///src//db//"+datasourceName+".mdb";
			con = DriverManager.getConnection(url,"","");
			sql = con.createStatement();
			sql.execute(SQL);
			message = "�����ɹ�";
			con.close();
		}
		catch (SQLException e) {
			message = e.toString();
			}
		return message;
		}
	}
