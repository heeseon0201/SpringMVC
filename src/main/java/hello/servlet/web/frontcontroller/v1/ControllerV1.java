package hello.servlet.web.frontcontroller.v1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//프론트컨트롤러가 구현할 인터페이스
public interface ControllerV1 {

	void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
