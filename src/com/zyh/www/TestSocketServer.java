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
			Class.forName("com.mysql.jdbc.Driver");     //����mysq����
		}catch(ClassNotFoundException e){
			System.out.println("�Ҳ������������� ����������ʧ�ܣ�");   
			e.printStackTrace() ;  
		}
		//�������ݿ�
		try {
			url = "jdbc:mysql://localhost:3306/testa";
			user = "root";
			password = "jdimage";
			conn = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			System.out.println("���ݿ����Ӵ���");
			e.printStackTrace();
		} 
		
		//��ȡ���ݿ�
		try {
			stmt = conn.createStatement();
			sql = "select * from student";
			rs = stmt.executeQuery(sql);//ִ��sql���
			while(rs.next()) {
			    System.out.print(rs.getString("name") + "   ");
			    System.out.print(rs.getString("age") + "   ");
			    System.out.println(rs.getString("address") + "   ");
			   }
		} catch (SQLException e) {
			System.out.println("���ݲ�������");
			e.printStackTrace();
		}
		
		//�ر����ݿ�
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
		    System.out.println("���ݿ�رմ���");
		    e.printStackTrace();
		}
	}		
	
}
