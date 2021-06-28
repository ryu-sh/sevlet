package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerV2Map = new HashMap<>();

    public FrontControllerServletV2() {
        controllerV2Map.put("/front-controller/v1/members/new-from", new MemberFormControllerV2());
        controllerV2Map.put("/front-controller/v1/members/save", new MemberSaveControllerV2());
        controllerV2Map.put("/front-controller/v1/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();

        ControllerV2 controllerV2 = controllerV2Map.get(requestURI);
        if(controllerV2 == null){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        MyView myView = controllerV2.process(req, resp);
        myView.render(req,resp);
    }
}
