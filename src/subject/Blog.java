package subject;

import observer.Observer;

public class Blog extends Observable{
	
	private String action = "";
	private int uid;
	private int blogId;
	private int addCount = 0;
	private int deleteCount = 0;

	@Override
	public void notifyObservers() {
		for(Observer o:observers){
			o.update(uid,blogId,action);			
		}
	}
	
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	
	public void check() {
		// TODO Auto-generated method stub
		action = "check";
		notifyObservers();
	}
	
	public void add() {
		// TODO Auto-generated method stub
		
		action = "add";
		if(addCount == 0){
			notifyObservers();
		}
		addCount++;
	}
	
	public void modify() {
		// TODO Auto-generated method stub
		action = "modify";
		notifyObservers();
	}
	
	public void delete() {
		// TODO Auto-generated method stub
		action = "delete";
		if(deleteCount == 0){
			notifyObservers();
		}
		deleteCount++;
	}
	


}
