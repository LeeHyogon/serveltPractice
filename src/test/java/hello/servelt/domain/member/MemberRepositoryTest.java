package hello.servelt.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    public void save() throws Exception {
        //given
        Member member = new Member("hello", 23);
        //when
        Member savedMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        assertEquals(findMember,savedMember);
    }

    @Test
    public void findAll() throws Exception {
        //given
        Member member1 = new Member("hello", 25);
        Member member2 = new Member("gon", 29);
        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> result = memberRepository.findAll();
        //then
        assertEquals(result.size(), 2);
        org.assertj.core.api.Assertions.assertThat(result).contains(member1,member2);

    }
}