package subject;

import observer.CountObserver;
import observer.LogObserver;

public class Test {
	public static void main(String[] args) {
		Blog blog = new Blog();
		CountObserver count = new CountObserver();
		LogObserver log = new LogObserver();
		
		blog.addObserver(count);
		blog.addObserver(log);
		
		blog.setUid(2);
		blog.setBlogId(5);
		
//		blog.check();
		blog.add();
//		blog.delete();
//		blog.modify();

	}
}
