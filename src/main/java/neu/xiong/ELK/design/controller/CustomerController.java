package neu.xiong.ELK.design.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import neu.xiong.ELK.design.dao.CustomerDao;
import neu.xiong.ELK.design.dao.GoodsDao;
import neu.xiong.ELK.design.entity.Customer;
import neu.xiong.ELK.design.entity.Goods;



/**
 * 				本项目不是前后端分离
 *              注意是Controller 不是 RestController
 *              @RestController实际上= @Controller+@ResponseBody其返回自动解析成json,
 *              不能通过视图解析器解析;
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
	
	@GetMapping(value="/login")
	public String login(){
		return "entry";
	}
	@GetMapping(value="/index")
	public String index(Model model){
		/*获取数据库的商品信息*/
		List<Goods> result = goodsDao.indexGoods();
		//System.out.println(result);
		model.addAttribute("result",result);
		return "index";
	}
	
	@GetMapping(value="/goods/{goodsId}")
	public String goods(@PathVariable("goodsId") int goodsId,Model model){
		Goods goods = goodsDao.findByGoodsId(goodsId);
		System.out.println(goods);
		model.addAttribute("goods",goods);
		return "goods";
	}
	/**
	 *   加上@ResponseBody 以JSON格式返回数据,而不是默认的视图层了
	 * @param username	用户名
	 * @param password	密码
	 * @param code	验证码
	 * @return
	 */
	@GetMapping(value="/api/login")
	@ResponseBody
	public String tologin(String username,String password,String code,HttpServletRequest request){
		Customer cus = null;
		try {
			System.out.println("username"+username);
			cus = cusDao.findByUsername(username);
			if(username.equals(cus.getUsername())&&password.equals(cus.getPassword())){
				//设置Session
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				//设值1 ,表示用户登录,前端判断来显示登录界面,或者用户名字
				session.setAttribute("state", 1);
				//当返回英文的时候前端ajax进不了sucess函数,需要改为严格JSON格式,这里我就用数字代替了文字
				return "1";
			}else{
				//LoginFail
				return "2";
			}
		} catch (Exception e) {
			e.printStackTrace();
			//NullInput
			return "3";
		}	
	}
	@GetMapping(value="/logout")
	public String logout(HttpSession session){
		//移除session
		System.out.println(session.getAttribute("username"));
		if(session.getAttribute("username")!=null){
			session.removeAttribute("username");
			session.removeAttribute("state");
			return "index";
		}else{
			return "entry";
		}
	}
}
