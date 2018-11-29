package kr.ac.dit.persistence;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.ac.dit.domain.LogonDTO;
import kr.ac.dit.domain.MemberVO;
@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	SqlSession sqlSession;
	@Override
	public void insert(MemberVO memberVO) throws Exception {
		sqlSession.insert("MemberMapper.insert", memberVO);
	}
	@Override
	public MemberVO select(LogonDTO logonDTO) throws Exception {
		return sqlSession.selectOne("MemberMapper.select", logonDTO); 
	}
}
