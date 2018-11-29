package kr.ac.dit.service;
import java.util.List;

import kr.ac.dit.domain.BoardVO;
import kr.ac.dit.domain.LogonDTO;
import kr.ac.dit.domain.MemberVO;
import kr.ac.dit.domain.UploadFileVO;
public interface BoardService {
	public void createArticle(BoardVO boardVO) throws Exception;
	public BoardVO readArticle(int no) throws Exception;
	public void updateArticle(BoardVO boardVO) throws Exception;
	public void deleteArticle(int no) throws Exception;
	public void uploadFile(UploadFileVO uploadFileVO);
	public Object readAttachFile(int no);
	public UploadFileVO downloadFile(int fileId);
	public int selectTotalArticleCount();
	public List<BoardVO> listArticle(int page);
	
}
