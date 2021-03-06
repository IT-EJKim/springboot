package com.myapp.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myapp.demo.domain.User;

@Controller
public class HomeController {
	
	// 뷰와 컨트롤러 사이의 데이터를 Model을 통해 전달한다
	@GetMapping("/")
	public String home(Model model) {
		// "user"이름으로 User의 빈객체를 넣어서 "user" = new User();
		model.addAttribute("user", new User());
		// model을 통해 index.html 페이지에 전달
		return "index"; //index라는 뷰를 찾는다.
						// resoures의 templates 안에 있음.
	}

	@PostMapping("/create")
	// user객체를 받음 
	public String processFormData(User user, RedirectAttributes attr) {
		//System.out.println(user.toString());
//		return "result"; //result.html 로 이동
		attr.addFlashAttribute("user", user);
		return "redirect:/display"; //display 페이지로 새로운 요청. 
									//redirect로 보낼경우, 데이터가 전달이 안되므로 RedirecAttribute를 인수로, 그리고 addFlashAttribute메소드를 써줘야함
	}
	
	@GetMapping("/display")
	public String displayFormData(User user) {
		return "result";
	}
}
