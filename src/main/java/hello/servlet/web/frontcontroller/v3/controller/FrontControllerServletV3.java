package hello.servlet.web.frontcontroller.v3.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

// /frontcontroller/v3/*: 뒤에 어떤 내용이 나와도 연결되게
@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet{

	private Map<String, ControllerV3> controllerMap = new HashMap<>();

	public FrontControllerServletV3() {
		controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
		controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
		controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String requestURI = request.getRequestURI();
	
		ControllerV3 controller = controllerMap.get(requestURI);
		if(controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		//paramMap -> 너무 디테일해서 메소드로 만듦
		Map<String, String> paramMap = createParamMap(request);
		
		ModelView mv = controller.process(paramMap);
		String viewName = mv.getViewName(); //논리이름만 
		MyView view = viewResolver(viewName); //new MyView("/WEB-INF/views/" + viewName + ".jsp"); //논리이름을 물리이름으로 반환
		view.render(mv.getModel(), request, response);
	}
	private Map<String, String> createParamMap(HttpServletRequest request) {
		
		Map<String, String> paramMap = new HashMap<>();
		request.getParameterNames().asIterator()
			.forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
		
		return paramMap;
	}
	//논리이름을 물리이름으로 반환해주는 메소드
	private MyView viewResolver(String viewName) {
		return new MyView("/WEB-INF/views/" + viewName + ".jsp");
	}
}
