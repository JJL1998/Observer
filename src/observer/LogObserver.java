package observer;


import database.DBHelper;


public class LogObserver implements Observer{
	static DBHelper db = null;
	
	@Override
	public void update(int uid, int blogId,String action) {
		
		System.out.println(action);
		db = new DBHelper();
		try {
			db.UpdateLog(uid,blogId,action);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
