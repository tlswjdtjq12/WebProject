package kr.ac.dit.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.dit.domain.MemberVO;
import kr.ac.dit.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService MemberService;
	@RequestMapping(value="createMember", method=RequestMethod.GET)
	public String createGET() throws Exception {
		return "createMember";
	}

	@RequestMapping(value="createMember", method=RequestMethod.POST)

	public void createPOST(MemberVO MemberVO, Model model) throws Exception {

		MemberService.createMember(MemberVO);

	}
	@RequestMapping("readMember")
	public void readList(Model model) throws Exception {
		model.addAttribute("items", MemberService.readMemberList());
	}
}
