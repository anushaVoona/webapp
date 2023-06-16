package com.MyFIrstWebApplication.Webapplication.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SelfController {

	@GetMapping("sayhi")
	@ResponseBody
	public String sayHi() {
		return "Hi Anusha";
	}

	@RequestMapping("say_hi_html")
	@ResponseBody
	public String sayhello() {

		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> My First HTML Page - Changed</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My first html page with body - Changed");
		sb.append("</body>");
		sb.append("</html>");

		return sb.toString();
	}

	@RequestMapping("say_hi_jsp")
//src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	public String sayHiJSP() {
		return "sayhi";
	}

}
