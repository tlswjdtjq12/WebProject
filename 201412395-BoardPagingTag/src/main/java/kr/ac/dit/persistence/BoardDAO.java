package kr.ac.dit.persistence;
import java.util.*;

import org.apache.ibatis.annotations.Param;

import kr.ac.dit.domain.BoardVO;
import kr.ac.dit.domain.UploadFileVO;
public interface BoardDAO {
	public List<BoardVO> selectList(@Param("start")int start, @Param("end")int end);
	public void insert(BoardVO boardVO) throws Exception;
	public BoardVO select(int no) throws Exception;
	public void update(BoardVO boardVO) throws Exception;
	public void delete(int no) throws Exception;
	public void insertFile(UploadFileVO uploadFileVO);
	public int selectMaxFileId();
	public Object selectAttachFile(int no);
	public UploadFileVO selectDownloadFile(int fileId);
	public int selectTotalArticleCount();
}
