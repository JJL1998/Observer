package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DBHelper {
	static String sql = null;  
	static DBHelper db1 = null;  
	static ResultSet ret = null;
	
	public void updateBlogViewNumber( int uid, int blogId) throws Exception {
		ResultSet ret1 = null;
		String sql1 = "SELECT viewNumber from bloginfo WHERE uid = "+ uid +" and blogId = "+ blogId;
		Connection conn = getConn();
		conn.setAutoCommit(false);
	    int i = 0;
	    int a = 0;
	    PreparedStatement pstmt,pstmt1;
	    try {
	    	
	    	pstmt1 = (PreparedStatement) conn.prepareStatement(sql1);
	    	ret1 = pstmt1.executeQuery();
	    	while(ret1.next()){
	    		a = ret1.getInt("viewNumber")+1;
	    		System.out.println(a);
	    	}

	    	sql = "UPDATE bloginfo SET viewNumber = " + a +" WHERE uid = "+ uid +" and blogId = "+ blogId; 
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        
	        i = pstmt.executeUpdate();
	        conn.commit();
	    } catch (Exception e) {
	    	try {   
                conn.rollback();  
            } catch (Exception e1) {  
                  
                e1.printStackTrace();  
            }  
	        e.printStackTrace();
	    }

	}
		   
	public void UpdateLog(int uid,int blogId,String operate) throws Exception {
			
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = df.format(new Date());
		
		sql = "INSERT INTO loginfo ( uid,blogId,time,operate) VALUES  ( " + uid + ","+blogId+ ",'"+now+ "','"+operate + "') ";//SQL语句 	
		String sql1 ="Select * from loginfo"+" WHERE uid = "+ uid +" and blogId = "+ blogId;
		
		Connection conn = getConn();
		conn.setAutoCommit(false);
	    PreparedStatement pstmt,pstmt1;
	    
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        int i = pstmt.executeUpdate();
	        
	        pstmt1 = conn.prepareStatement(sql1);
	        ret = pstmt1.executeQuery();
	        
	        while(ret.next()){
	        	System.out.println("UserId:" + ret.getInt(1) + "  BlogId: " + ret.getInt(2) + "  Operate time: " + ret.getString(3) + "  Operation: " + ret.getString(4));
	        }
	        
	        conn.commit();
	    } catch (SQLException e) {
	    	try {   
                conn.rollback();  
            } catch (Exception e1) {                   
                e1.printStackTrace();  
            }  
	        e.printStackTrace();
	    }
	}
	
	
	   private static Connection getConn() {
	        String driver = "com.mysql.jdbc.Driver";
	        String url = "jdbc:mysql://127.0.0.1/microblog";
	        String username = "root";
	        String password = "root";
	        Connection conn = null;
	        try {
	            Class.forName(driver); //classLoader,加载对应驱动
	            conn = (Connection) DriverManager.getConnection(url, username, password);
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return conn;
	    }
	   
}
