package JavaCode.persistance;

import java.sql.*;

public class PrepareDatabase {
	private static Connection bdd;
	private Statement request;
	public PrepareDatabase() {
		try{
			this.bdd = DriverManager.getConnection("jdbc:mariadb://localhost:3306/projet", "root", "root");
			this.request = bdd.createStatement();
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	public Statement getrequest(){
		return this.request;
	}
	public synchronized ResultSet getselect(String Table, String condition){
		try {
			ResultSet Result = this.request.executeQuery("SELECT * FROM " + Table + " WHERE " + condition + "");
		return Result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
    }
	public synchronized ResultSet getInsert(String Table, String condition) {
		try {
			ResultSet Result = this.request.executeQuery("INSERT INTO " + Table + " values( " + condition + ")");
			return Result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public synchronized ResultSet getUpdate(String Table, String set, String condition) {
		try {
			ResultSet Result = this.request.executeQuery("Update " + Table + " SET " + set + " WHERE " + condition + "");
			return Result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}