package com.cavalier.game;

/*shep
 * �������ݿ��޸�����
 */
public class Change {
	boolean flag = false;
	public void Change(String user,String newkeys){
		EditAccess data = new EditAccess();
		String backMess = data.record();
			data.setDatasourceName("signups");
			data.setSQL("UPDATE information SET password = '"+newkeys+"' WHERE username = '"+user+"'");
			backMess = data.record();
	}
}
