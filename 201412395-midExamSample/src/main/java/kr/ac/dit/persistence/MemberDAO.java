package kr.ac.dit.persistence;
import java.util.*;
import kr.ac.dit.domain.MemberVO;
public interface MemberDAO {
	public void insertMember(MemberVO memberVO) throws Exception;
	public List<MemberVO> selectMemberList() throws Exception;
}
