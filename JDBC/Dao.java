package javaWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.jdbc.Driver;

public class Dao{
	public Connection getConnection(){
		Connection connection = null;
		try {
			//1、加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			/**
			 *jdbc:mysql://localhost  表示数据库位置 
			 *3306  表示当前要链接的数据库的端口号
			 *test 表示
			 */
			String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
			String userName = "root";
			String password = "root";
			//2、创建连接对象
			connection = DriverManager.getConnection(url,userName,password);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public ResultSet getResultSet(String sql) {
		ResultSet resultSet = null;
		Dao dao = new Dao();
		Connection connection = dao.getConnection();
		try {
			//3、创建执行对象
			Statement statement = connection.createStatement();
			//4、执行sql语句，得到结果集
			resultSet = statement.executeQuery(sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultSet;
	}
	public static void main(String[] args){
		Dao dao = new Dao();
		Connection connection = dao.getConnection();
		if(connection!=null){
			System.out.println("数据库连接成功！");
		}
		else {
			System.out.println("数据库连接失败！");
		}
		
		String sql = "select * from student";
		ResultSet resultSet = dao.getResultSet(sql);
		try {
			while(resultSet.next())
			{
				int id = resultSet.getInt(1);
				String name = resultSet.getString("name");
				System.out.println("id:"+id+",name:"+name);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
