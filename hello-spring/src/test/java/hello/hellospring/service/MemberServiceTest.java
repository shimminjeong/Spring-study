package hello.hellospring.service;

import hello.hellospring.Repository.MemoryMemberRepositoryTest;
import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService=new MemberService(memberRepository);
    }


    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();

    }

    @Test
    void 회원가입() {
        //given
        Member member =new Member();
        member.setName("hello");
        //when
        Long savaId=memberService.join(member);

        //then
        Member findMember = memberService.findOne(savaId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복회원예외(){
        Member member1 =new Member();
        member1.setName("spring");

        Member member2 =new Member();
        member2.setName("spring");

        memberService.join(member1);
        IllegalStateException e=assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미존재하는회원");
//        memberService.join(member2);
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}