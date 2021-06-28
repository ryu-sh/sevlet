package hello.servlet.web.frontcontroller.v4.controller;

import hello.servlet.web.frontcontroller.Member;
import hello.servlet.web.frontcontroller.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {
    @Autowired
    MemberRepository memberRepository;
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        String username = (String) paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.put("member",member);
        return "save-result";
    }
}
