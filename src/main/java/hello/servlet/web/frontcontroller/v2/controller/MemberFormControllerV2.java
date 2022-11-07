package hello.servlet.web.frontcontroller.v2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;

public class MemberFormControllerV2 implements ControllerV2{

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//이전 V1의 경우
		/*
		 * String viewPath = "/WEB-INF/views/new-form.jsp"; 
		 * RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath); 
		 * dispatcher.forward(request,response);
		 */
		
		MyView myView = new MyView("/WEB-INF/views/new-form.jsp");
		return myView;
		//return new myView("/WEB-INF/views/new-form.jsp");로 합칠 수도 있음
	}

	
}
