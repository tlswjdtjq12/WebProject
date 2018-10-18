package kr.ac.dit.service;
import java.util.*;
import kr.ac.dit.domain.MemberVO;
public interface MemberService {
	public void createMember(MemberVO memberVO) throws Exception;
	public List<MemberVO> readMemberList() throws Exception;
}
