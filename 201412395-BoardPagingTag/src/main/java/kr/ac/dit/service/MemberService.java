package kr.ac.dit.service;
import kr.ac.dit.domain.LogonDTO;
import kr.ac.dit.domain.MemberVO;
public interface MemberService {
	public void createMember(MemberVO memberVO) throws Exception;
	public MemberVO readMember(LogonDTO logonDTO) throws Exception;
}
