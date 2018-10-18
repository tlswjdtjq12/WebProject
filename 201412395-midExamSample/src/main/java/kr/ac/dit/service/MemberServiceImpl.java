package kr.ac.dit.service;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.ac.dit.domain.MemberVO;
import kr.ac.dit.persistence.MemberDAO;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;
	public void createMember(MemberVO memberVO) throws Exception {
		memberDAO.insertMember(memberVO);
	}
	public List<MemberVO> readMemberList() throws Exception {
		return memberDAO.selectMemberList();
	}
}
