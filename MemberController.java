package com.example.board_longin.controller;

import com.example.board_longin.dto.MemberDTO;
import com.example.board_longin.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {
    //생성자 주입
    private final MemberService memberService;
    private Object memberDTO;

    //회원가입 페이지 출력 요청
    @GetMapping("/member/save")
    public String saveForm() {
        return "savel";
    }

    @PostMapping("/member/save")
    public String save(RequestParam MemberDTO, String memberEmail, String memberPassword, String memberName, MemberDTO memberDTO) {
        System.out.println("MemberController.save");
        System.out.println("memberEmail = " + memberEmail + ", memberPassword =" + memberPassword + ",memberName = " + memberName);
        memberService.save(memberDTO);
        return "login";
    }

    @GetMapping("/member/login")
    public String loginForm() {
        return "login";
    }

    private class MenberService extends MemberService {
        public MenberService(MemberRepository memberRepository) {
            super(memberRepository);
        }
    }

    @PostMapping("/Member/login")
    public String lohin(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        BoardController memberSwrvice;
        MemberDTO loginResult = memberSwrvice.login(memberDTO);
        if (loginResult != null) {
            //login 성공
            session.setAttribute("loginEmail",loginResult.getMemberEmail());
            return "main";
        } else {
            //login 실패
            return "login";
        }

    }

}
