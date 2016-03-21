package exec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Dbconnection implements CallNumberDAO_interface {
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url ="jdbc:sqlserver://54.169.217.3:1433;databaseName=OD_YDL;user=sa;password=Care53477159";
	
	private static final String INSERT_STMT=
			"INSERT INTO CALL_NUMBER(company_no,clinic,room,gw_mac,number) VALUES(?,?,?,?,?)";
	
	@Override
	public int insert(CallNumberVO callNumberVO) {
		
		int insertCount = 0;
		Connection con =null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1,"0B1234567");
			pstmt.setString(2,"雅得");
			pstmt.setString(3,"/dev/ttyS3");
			pstmt.setString(4,"00:aa:bb:cc:dd:ee");
			pstmt.setInt(5,12);
			
			insertCount = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(con !=null) {
				try{
					con.close();
				}catch(Exception e) {
					e.printStackTrace(System.err);
				}
				
			}
		}
			
		
		return insertCount;
	}

	@Override
	public int update(CallNumberVO callNumberVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CallNumberVO findByGwMac(String GwMac) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CallNumberVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args)  throws ClassNotFoundException, SQLException {
		/*String url = "jdbc:sqlserver://54.169.217.3:1433;databaseName=OD_YDL;user=sa;password=Care53477159";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(url);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM CALL_NUMBER");
		*/
		Dbconnection dbcon = new Dbconnection();
		CallNumberVO callNumVO = new CallNumberVO();
		callNumVO.setClinicName("新光診所");
		callNumVO.setClinicNo("345678");
		callNumVO.setGwMac("02:0E:09:83:0A:28");
		callNumVO.setNumber(2);
		
		int insertCount = dbcon.insert(callNumVO);
		
		System.out.println("已新增"+insertCount+"筆資料");
	}

	
}
