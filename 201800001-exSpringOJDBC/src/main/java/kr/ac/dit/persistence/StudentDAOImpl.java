package kr.ac.dit.persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import kr.ac.dit.domain.StudentVO;
@Repository
public class StudentDAOImpl implements StudentDAO {
	@Override
	public void insertStudent(StudentVO studentVO) throws Exception {
		String no = studentVO.getNo();

		String name = studentVO.getName();

		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "201412395", "201412395");

		PreparedStatement pstmt = conn.prepareStatement("insert into student values(?,?)");

		pstmt.setString(1, no);

		pstmt.setString(2, name);

		pstmt.executeUpdate();

		pstmt.close();

		conn.close();

		}
	@Override
	public List<StudentVO> selectStudentList() throws Exception {
		List<StudentVO> items = new ArrayList<StudentVO>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "201412395", "201412395");
		PreparedStatement pstmt = conn.prepareStatement("select * from student");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			StudentVO item = new StudentVO();
			item.setNo(rs.getString("no"));
			item.setName(rs.getString("name"));
			items.add(item);
		}
		pstmt.close();
		rs.close();
		conn.close();
		return items;
	}
}
