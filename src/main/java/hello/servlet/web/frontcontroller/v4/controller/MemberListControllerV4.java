package hello.servlet.web.frontcontroller.v4.controller;

import hello.servlet.web.frontcontroller.Member;
import hello.servlet.web.frontcontroller.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {
    @Autowired
    MemberRepository memberRepository;

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<Member> members = memberRepository.findAll();
        model.put("members", members);
        return "members";
    }
}
