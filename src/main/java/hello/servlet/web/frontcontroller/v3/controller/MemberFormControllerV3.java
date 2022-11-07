package hello.servlet.web.frontcontroller.v3.controller;

import java.util.Map;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

public class MemberFormControllerV3 implements ControllerV3{
	
	//request, response를 모두 제거 -> 서블릿의 종속성을 제거
	//컨테이너에 종속되도록 구성
	@Override
	public ModelView process(Map<String, String> paramMap) {
		return new ModelView("new-form");
	}
	
	
}
