package observer;

import database.DBHelper;

public class CountObserver implements Observer {

	static DBHelper db = null;

	
	public void update(int uid, int blogId,String action) {

		if(action.equals("check")){

			db = new DBHelper();
			try {
				db.updateBlogViewNumber(uid, blogId) ;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
