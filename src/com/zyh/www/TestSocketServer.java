package com.zyh.www;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSocketServer {
	public static void main(String[] args) { 
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String url = null;
		String user = null;
		String password = null;
		String sql = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");     //加载mysq驱动
		}catch(ClassNotFoundException e){
			System.out.println("找不到驱动程序类 ，加载驱动失败！");   
			e.printStackTrace() ;  
		}
		//连接数据库
		try {
			url = "jdbc:mysql://localhost:3306/testa";
			user = "root";
			password = "jdimage";
			conn = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			System.out.println("数据库链接错误");
			e.printStackTrace();
		} 
		
		//读取数据库
		try {
			stmt = conn.createStatement();
			sql = "select * from student";
			rs = stmt.executeQuery(sql);//执行sql语句
			while(rs.next()) {
			    System.out.print(rs.getString("name") + "   ");
			    System.out.print(rs.getString("age") + "   ");
			    System.out.println(rs.getString("address") + "   ");
			   }
		} catch (SQLException e) {
			System.out.println("数据操作错误");
			e.printStackTrace();
		}
		
		//关闭数据库
		try {
			if(rs != null) {
				rs.close();
				rs = null;
		    }
		    if(stmt != null) {
			    stmt.close();
			    stmt = null;
		    }
		    if(conn != null) {
			    conn.close();
			    conn = null;
		    }
		}catch(Exception e) {
		    System.out.println("数据库关闭错误");
		    e.printStackTrace();
		}
	}		
	
}
