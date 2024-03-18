package hello.hellospring.service;

import hello.hellospring.controller.*;
import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CookieValue;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public String join(Member member) throws SQLException {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    public Member loginCheck(LoginMemberForm member){
        Member member1= new Member();

        memberRepository.findByLogin(member.getId(), member.getPass())
                .ifPresentOrElse(m-> {
                    member1.setId(m.getId());
                    member1.setPass(m.getPass());
                    member1.setEmail(m.getEmail());
                    member1.setTotalDate(m.getTotalDate());


                    } , () -> {
                    member1.setId("false");
                    member1.setPass("false");
                    member1.setEmail("false");
                    member1.setTotalDate(-1);

                });
        return member1;
    }

    public DateCheck checkTotalDate(DateCheckForm member) throws SQLException {
        DateCheck dateCheck = memberRepository.checkDate(member.getId());
        return dateCheck;
    }

    public CheckPoint checkTotalPoint(CheckPointForm member) throws SQLException {
        CheckPoint checkPoint = memberRepository.checkPoint(member.getName());

        return checkPoint;
    }

    public AddPoint addTotalPoint(AddPointForm member) throws SQLException {
        AddPoint addPoint = memberRepository.addPoint(member.getId(), member.getSort(), member.getPoints());

        System.out.println(member.getPoints());
        return addPoint;
    }

    public CreatePoint createTotalPoint(CreatePointForm member) throws SQLException {
        CreatePoint createPoint = memberRepository.createPoint(member.getId());

        return createPoint;
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findById(member.getId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(String memberId){
        return memberRepository.findById(memberId);
    }

}
