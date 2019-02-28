package neu.xiong.ELK.design.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin
public class UtilController {

		/*提供验证码*/
		@GetMapping(value="/register")
		public String reg(Model model,HttpServletRequest request){
			String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	        String uuid=new String();
	        for(int i=0;i<4;i++)
	        {
	            char ch=str.charAt(new Random().nextInt(str.length()));
	            uuid+=ch;
	        }
	        HttpSession session = request.getSession();
			session.setAttribute("uuid", uuid); //保存在session中以比对
			model.addAttribute("uuid",uuid);
			return "register";
		}
}
