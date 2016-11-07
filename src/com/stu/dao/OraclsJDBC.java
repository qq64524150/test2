package com.stu.dao;

import java.sql.*;

public class OraclsJDBC {

	public static Connection getConnection() {
		try {
			// ��ȡ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// �õ�����
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "stu", "123456");
			//������ģʽ����Ϊ�ֶ��ύ����  
            conn.setAutoCommit(false);  
          
			return conn ;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void closeDb(Connection con, Statement st, ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (st != null)
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	
	public static boolean updateDb(String sql) throws SQLException {
		Connection conn = getConnection();
		Statement st = null;
		try {
			st = conn.createStatement();
			 //�ύ����  
            conn.commit();  
			if (st.executeUpdate(sql) > 0)
				return true;
		} catch (SQLException e) {
			// ���������쳣���ع�����  
            conn.rollback(); 
			e.printStackTrace();
		} finally {
			OraclsJDBC.closeDb(conn, st, null);
		}
		return false;
	}

	public static boolean updateDb(String sql, Object[] objs) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			if (objs != null && objs.length > 0) {
				for (int i = 0; i < objs.length; i++) {
					if (objs[i] == null)
						objs[i] = "";
					ps.setObject(i + 1, objs[i]);
				}
			}
			 //�ύ����  
            conn.commit();  
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			// ���������쳣���ع�����  
            conn.rollback();  
			e.printStackTrace();
		} finally {
			closeDb(conn, ps, null);
		}
		return false;
	}


}