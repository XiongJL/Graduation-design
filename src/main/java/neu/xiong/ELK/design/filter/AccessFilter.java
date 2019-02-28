package neu.xiong.ELK.design.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 过滤器
 * @author Administrator
 *
 */
public class AccessFilter implements Filter{
	//设置未登录信息
	String NO_LOGIN="NO_LOGIN";
	//不需要登录就可以访问的路径
	String[] includeUrls = new String[]{"/search","/login","/index","/goods/{goodsId}","/api/login",
			"/api/register"};
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
	// flase 该方法，若存在会话则返回该会话，否则返回NULL
		//(true)    ，否则新建一个会话
		HttpSession session = request.getSession(false);
		String uri = request.getRequestURI();
		boolean needFilter = isNeedFilter(uri);
		if(!needFilter){ //不需要过滤，传递下一个过滤器
			chain.doFilter(req, res);
		}else{
			if(session !=null && session.getAttribute("username")!=null){
				chain.doFilter(req, res);
			}else{
				response.getWriter().write(this.NO_LOGIN);
			}
		}
	}
	/**
	 * 是否需要过滤
	 * @param uri
	 * @return
	 */
	private boolean isNeedFilter(String uri) {
		for(String url : includeUrls){
			if(url.equals(uri)){
				//不需要
				return false;
			}
		}
		return true;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
