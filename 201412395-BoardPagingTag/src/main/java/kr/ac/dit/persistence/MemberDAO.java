package kr.ac.dit.persistence;
import kr.ac.dit.domain.LogonDTO;
import kr.ac.dit.domain.MemberVO;
public interface MemberDAO {
	public void insert(MemberVO memberVO) throws Exception;
	public MemberVO select(LogonDTO logonDTO) throws Exception;
}
