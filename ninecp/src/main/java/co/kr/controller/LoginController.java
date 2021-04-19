package co.kr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	
	
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public ModelAndView logout(@RequestParam("intname")String name,
			HttpSession session) {
		session.removeAttribute("name");
		ModelAndView mav = new ModelAndView("redirect:/intro");
		return mav;
	}

	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(@RequestParam("loginpass")String pass,
						@RequestParam("intpass")String intpass,
						@RequestParam("intname")String name,
						@RequestParam("profile")String profile,
						RedirectAttributes redirectAttr,
						HttpSession session) throws Exception {
		if(pass.equals(intpass)) {
		session.setAttribute("name", name);
		session.setAttribute("profile",profile);
			return "redirect:/intro";
		}
		return "redirect:/intro";
}
}
