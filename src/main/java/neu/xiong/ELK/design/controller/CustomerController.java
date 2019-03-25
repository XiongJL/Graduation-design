package neu.xiong.ELK.design.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;
import java.util.regex.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;
import neu.xiong.ELK.design.dao.CustomerDao;
import neu.xiong.ELK.design.dao.GoodsDao;
import neu.xiong.ELK.design.entity.Customer;
import neu.xiong.ELK.design.entity.Goods;

/**
 * 本项目不是前后端分离 注意是Controller 不是
 * RestController @RestController实际上= @Controller+@ResponseBody其返回自动解析成json,
 * 不能通过视图解析器解析;
 * 
 * @author Administrator
 *
 */
@Controller
@CrossOrigin
public class CustomerController {
	@Autowired
	private CustomerDao cusDao;
	@Autowired
	private GoodsDao goodsDao;

	@GetMapping(value = "/login")
	public String login() {
		return "entry";
	}

	

	/**
	 * 加上@ResponseBody 以JSON格式返回数据,而不是默认的视图层了
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @param code
	 *            验证码
	 * @return
	 */
	@GetMapping(value = "/api/login")
	@ResponseBody
	public String tologin(String username, String password, String code, HttpServletRequest request) {
		Customer cus = null;
		try {
			System.out.println("username" + username);
			cus = cusDao.findByUsername(username);
			if (username.equals(cus.getUsername()) && password.equals(cus.getPassword())) {
				// 设置Session
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				session.setAttribute("cusId", cus.getCtid());
				// 设值1 ,表示用户登录,前端判断来显示登录界面,或者用户名字
				session.setAttribute("state", 1);
				// 当返回英文的时候前端ajax进不了sucess函数,需要改为严格JSON格式,这里我就用数字代替了文字
				return "1";
			} else {
				// LoginFail
				return "2";
			}
		} catch (Exception e) {
			e.printStackTrace();
			// NullInput
			return "3";
		}
	}

	@GetMapping(value = "/logout")
	public String logout(HttpSession session) {
		// 移除session
		System.out.println(session.getAttribute("username"));
		if (session.getAttribute("username") != null) {
			session.removeAttribute("username");
			session.removeAttribute("state");
			return "index";
		} else {
			return "entry";
		}
	}
/**
 *   另一种错误提示思路： 
 *   	在每一个输入框添加一个页面失去焦点事件。
 *     事件发生后，立马异步传输值到后台，后台根据值查询数据库，并给出
 *     相应提示，例如，账号已存在啥的。
 * @param username
 * @param password2
 * @param password1
 * @param phone
 * @param yazheng
 * @param request
 * @return
 */
	@Transactional
	@PostMapping(value = "/api/register")
	@ResponseBody
	public String toregister(@RequestParam("username") String username, @RequestParam("password2")String password2,
			@RequestParam("password1")String password1,
			@RequestParam("phone")String phone,@RequestParam("yazheng") String yazheng, HttpServletRequest request) {
		HttpSession session = request.getSession();
//		System.out.println("uuid: " + session.getAttribute("uuid"));
//		System.out.println(yazheng.equals(session.getAttribute("uuid")));
		
		if(!Pattern.matches("^[0-9a-zA-Z\\u4e00-\\u9fa5]+$", username)){
			return "3";
		}
		if (password1.equals(password2)) {
			if (cusDao.findByUsername(username) != null) {
				// model.addAttribute("userErr","用户已存在");
				return "用户已存在";
			} else if (!yazheng.equals(session.getAttribute("uuid"))) { // 如果验证码错误
				// model.addAttribute("yzErr","验证码错误");
				return "验证码错误";
			} else { // 如果都没问题,则注册
				Customer cus = new Customer();
				cus.setUsername(username);
				cus.setPassword(password1);
				cus.setState(0); // 默认注册后为0
				cusDao.save(cus); // 保存用户
				return "1";
			}
		} else { // 两次输入的密码不匹配
			// model.addAttribute("pwdErr","请输入相同的密码");
			return "请输入相同的密码";
		}

	}
}
