package com.db;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.junit.Test;


public class testMysqlDriver {
	// 驱动程序名
	private String driver = "com.mysql.jdbc.Driver";
	// URL指向要访问的数据库名world
	private String url = "jdbc:mysql://127.0.0.1:3306/cvtoken";
	// MySQL配置时的用户名
	private String user = "root";
	// MySQL配置时的密码
	private String password = "root";
	
	public void test() {

		String name;
		try {
			// 加载驱动程序
			Class.forName(driver);
			// 连续数据库
			Connection conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			// statement用来执行SQL语句
			Statement statement = conn.createStatement();
			// 要执行的SQL语句
			String sql = "select * from cv_token";
			try {
				// 结果集
				ResultSet rs = statement.executeQuery(sql);
				while (rs.next()) {
					// 选择Name这列数据
					name = rs.getString("token");
					// 输出结果
					System.out.println(rs.getString("token") + "\t" + name);
				}
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void tests(){
		Connection conn=null;
		try {
			InputStreamReader readtypes = new InputStreamReader(new FileInputStream(new File("E:\\项目\\cvtoken\\数据备份\\token_count\\0.txt")), "UTF-8");
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("E:\\项目\\cvtoken\\数据备份\\token_count\\1.sql")));
			BufferedReader bufferedReader = new BufferedReader(readtypes);
			String lineTxt = null;
			int rowNum = 0;
			Class.forName(driver);
			// 连续数据库
			conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			// statement用来执行SQL语句
			Statement statement = conn.createStatement();
			while ((lineTxt = bufferedReader.readLine()) != null) {
				rowNum++;
				if (rowNum < 1000) {
					System.out.println(importSql(lineTxt));
					writer.append(importSql(lineTxt)+"\r\n");
				}
			}
			writer.close();
			bufferedReader.close();

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
				System.out.println("close");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private String importSql(String item){
		
		String[] is=item.split(",");
		StringBuilder sql=new StringBuilder("insert into `token_count`(`id`,`count_time`,`day`,`hour`,`minute`,`month`,`token`,`total`,`type`,`year`)");
		sql.append(" values");
		sql.append("('"+is[0]+"'");//id
		sql.append(",'"+is[1]+"'");//count_time
		sql.append(",'"+is[2]+"'");//day
		sql.append(",'"+is[3]+"'");//hour
		sql.append(",'"+is[4]+"'");//minute
		sql.append(",'"+is[5]+"'");//month
		sql.append(",'"+is[6]+"'");//token
		sql.append(",'"+is[7]+"'");//total
		sql.append(",'"+is[8]+"'");//type
		sql.append(",'"+is[9]+"');");//year
		
		return sql.toString();
	}

}
