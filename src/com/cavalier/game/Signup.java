package com.cavalier.game;

/*Shepherd*/

public class Signup {
	public void Signup(String newUser,String newKey){
		EditAccess data = new EditAccess();
		String backMess = data.record();
		data.setDatasourceName("signups");
		/*������˻�*/
		data.setSQL("INSERT INTO information(username,password) VALUES ('"+newUser+"','"+newKey+"')");
		backMess = data.record();
	}

}
