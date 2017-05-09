package com.cavalier.game;

/*shep
 * 链接数据库修改密码
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
