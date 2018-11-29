package kr.ac.dit.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.ac.dit.domain.BoardVO;
import kr.ac.dit.domain.UploadFileVO;
import kr.ac.dit.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<BoardVO> listArticle(int page) {
			int start = (page - 1) * 10; // 페이징 의 조건절에 사용되는 시작 rownum
			System.out.println("BoardServiceImpl->start(select 할 ROWNUM 시작값): " + start); //7페이지를 입력하면 70번 부터 시작하므로 60이라는 숫자가 출력된다
			  return boardDAO.selectList(start, start+10);

		}
    	
	public void createArticle(BoardVO boardVO) throws Exception {
		boardDAO.insert(boardVO);
	}

	public BoardVO readArticle(int no) throws Exception {
		return boardDAO.select(no);
	}

	public void updateArticle(BoardVO boardVO) throws Exception {
		boardDAO.update(boardVO);
	}

	public void deleteArticle(int no) throws Exception {
		boardDAO.delete(no);
	}
	@Override
	public void uploadFile(UploadFileVO uploadFileVO) {
		uploadFileVO.setFileId(boardDAO.selectMaxFileId() + 1);
		boardDAO.insertFile(uploadFileVO);
	}

	@Override	
	public Object readAttachFile(int no) {
		return boardDAO.selectAttachFile(no);
	}

	@Override
	public UploadFileVO downloadFile(int fileId) {
		return boardDAO.selectDownloadFile(fileId);
	}
	@Override
	public int selectTotalArticleCount() {
		return boardDAO.selectTotalArticleCount(); // 전체페이지 갯수를 가져옴 Mapper 이동
	}


	
}
	

	


	

