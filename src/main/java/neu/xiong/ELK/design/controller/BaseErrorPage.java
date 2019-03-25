package neu.xiong.ELK.design.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
@CrossOrigin
@Controller
/**
 *  全部错误处理页面
 * @author Administrator
 *
 */
public class BaseErrorPage implements ErrorController{
	
	@Override
	public String getErrorPath() {
		
		return "error";
	}
	@RequestMapping("error")
	public String error(){
		return getErrorPath();
	}
}
