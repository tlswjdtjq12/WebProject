package kr.ac.dit.logon;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object handler) throws Exception {
		HttpSession httpSession = httpServletRequest.getSession();
		if(httpSession.getAttribute("login")==null) {
			httpSession.removeAttribute("login");
		}
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object handler, ModelAndView modelAndView) throws Exception {
		HttpSession httpSession = httpServletRequest.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		Object memberVO = modelMap.get("memberVO");
		if (memberVO != null) {
			httpSession.setAttribute("login", memberVO);
			Object saveDirect = httpSession.getAttribute("saveDirect");
			httpServletResponse.sendRedirect(saveDirect != null ? (String)saveDirect:"/");
		}
	}
}
