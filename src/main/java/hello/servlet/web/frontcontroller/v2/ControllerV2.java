package hello.servlet.web.frontcontroller.v2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hello.servlet.web.frontcontroller.MyView;

//프론트컨트롤러가 구현할 인터페이스 
public interface ControllerV2 {
	//V1과 차이는 MyView반환
	MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
