package kr.ac.dit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.dit.domain.BoardVO;
import kr.ac.dit.domain.UploadFileVO;
import kr.ac.dit.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;

	@RequestMapping("/board/list/{page}") // 페이지 번호 입려
	  public String listGET(@PathVariable int page, Model model, HttpSession httpSession) throws Exception {
	   httpSession.setAttribute("page", page);
	   System.out.println("BoardController->page(현재 페이지 번호): " + page); //
	   List<BoardVO> boardList = boardService.listArticle(page); // listArticle 실행 (보더서비스에있는 페이지 번호를 int 값으로 넘김) 리턴을 계속해서 boardList에 담긴다.
	   model.addAttribute("items", boardList); //
	   int totalCount = boardService.selectTotalArticleCount(); // 전체 게시물 개수
	   System.out.println("BoardController->totalCount(총 게시물 수): " + totalCount);
	  int totalPage = 0;
	   if (totalCount>0) totalPage = (int)Math.ceil(totalCount/10.0); // 전체 페이지 개수를 selectTotalArticleCount 를 사용해서 가져온다. (전체게시글수를 10으로 나눠서 한페이지에 10개의 게시글만 나오도록 한다.)
	  model.addAttribute("totalPageCount", totalPage); //토탈페이지 값을 넘겨준다
	   model.addAttribute("page", page); //현재 페이지 값을 넘겨준다
	   System.out.println("BoardController->totalPage(총 페이지 수): " + totalPage);
	  return "/board/list";
	  }

	@RequestMapping(value = "/board/create", method = RequestMethod.GET)
	public void createGET() throws Exception {
	}

	@RequestMapping(value = "/board/createPost", method = RequestMethod.POST)

	public String createPOST(BoardVO boardVO) throws Exception {

	boardService.createArticle(boardVO);

	UploadFileVO uploadFileVO = new UploadFileVO();

	MultipartFile[] uploadFile = boardVO.getUploadFile();

	if (uploadFile != null) {

	for (MultipartFile eachFile : uploadFile) {

	uploadFileVO.setFileName(eachFile.getOriginalFilename());

	uploadFileVO.setFileData(eachFile.getBytes());

	boardService.uploadFile(uploadFileVO);
	}
	}
		boardService.createArticle(boardVO);
		return "redirect:/board/list";
	}
	@RequestMapping("/board/read")
	public void readGET(@RequestParam("no") int no, Model model) throws Exception {
		model.addAttribute("boardVO",boardService.readArticle(no));
		model.addAttribute("items",boardService.readAttachFile(no));
	}
	@RequestMapping(value = "/board/update", method = RequestMethod.GET)
	public void updateGET(@RequestParam("no") int no, Model model) throws Exception {
		model.addAttribute(boardService.readArticle(no));
	}

	@RequestMapping(value = "/board/update", method = RequestMethod.POST)
	public String updatePOST(BoardVO boardVO) throws Exception {
		boardService.updateArticle(boardVO);
		return "redirect:/board/list";
	}
	@RequestMapping(value = "/board/delete", method = RequestMethod.GET)
	public String deleteGET(@RequestParam("no") int no) throws Exception {
		boardService.deleteArticle(no);
		return "redirect:/board/list";
	}
	@RequestMapping(value = "/download/{fileId}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> download(@PathVariable int fileId) throws Exception {
	UploadFileVO downloadFile = boardService.downloadFile(fileId);
	HttpHeaders httpHeaders = new HttpHeaders();
	httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	httpHeaders.setContentDispositionFormData("attachment", downloadFile.getFileName());
	return new ResponseEntity<byte[]>(downloadFile.getFileData(), httpHeaders, HttpStatus.OK);
	}
	

	
}