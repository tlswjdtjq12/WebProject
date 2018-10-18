package kr.ac.dit.persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.ac.dit.domain.MemberVO;
@Repository
public class MeMberDAOImpl implements MemberDAO {
	@Autowired
	 JdbcTemplate jdbcTemplate;
	@Override
	public void insertMember(MemberVO MemberVO) throws Exception {
		 jdbcTemplate.update("insert into Member values(?,?,?)", MemberVO.getName(), MemberVO.getPassword(), MemberVO.getEmail());

		}
	@Override
	public List<MemberVO> selectMemberList() throws Exception {
		  List<MemberVO> items = new ArrayList<MemberVO>();
		    List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from Member"); 
		    for (Map row : rows) { 
		    	MemberVO item = new MemberVO(); 
		      item.setName((String) row.get("name")); 
		      item.setPassword((String) row.get("password"));
		      item.setEmail((String) row.get("email"));
		      items.add(item); 
		    } 
		    return items;
	}
}