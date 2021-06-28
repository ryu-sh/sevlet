package hello.servlet.web.frontcontroller;

import java.util.List;

public interface MemberRepository {

    List<Member> findAll();

    void save(Member member);
}
