package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.rsocket.context.LocalRSocketServerPort;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@RestController
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String home() {
        String hello1="aaa";

        return hello1;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(@RequestBody MemberForm form) throws SQLException {
        Member member = new Member();
        member.setId(form.getId());
        member.setPass(form.getPass());
        member.setEmail(form.getEmail());

        memberService.join(member);

        return "success";
    }

    @PostMapping("/members/Login")
    public Member login(@RequestBody LoginMemberForm form){
        Member member = memberService.loginCheck(form);

        return member;
    }

    @PostMapping("/members/DateCheck")
    public DateCheck dateCheck(@RequestBody DateCheckForm form) throws SQLException {
        DateCheck dateCheck = memberService.checkTotalDate(form);

        return dateCheck;
    }

    @PostMapping("members/CheckPoint")
    public CheckPoint checkPoint(@RequestBody CheckPointForm form) throws SQLException {
        CheckPoint checkPoint = memberService.checkTotalPoint(form);

        return checkPoint;
    }

    @PostMapping("members/AddPoint")
    public AddPoint addPoint(@RequestBody AddPointForm form) throws SQLException {
        AddPoint addPoint = memberService.addTotalPoint(form);

        return addPoint;
    }

    @PostMapping("members/CreatePoint")
    public CreatePoint createPoint(@RequestBody CreatePointForm form) throws SQLException {
        CreatePoint createPoint = memberService.createTotalPoint(form);

        return createPoint;
    }


    @PostMapping("/members/upload")
    public String upload(@RequestBody CheckVideos checkVideos){
        return "success";
    }


    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
