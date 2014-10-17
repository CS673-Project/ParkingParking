package edu.bu.heptagon.upark.interceptor;

/**
 * 
 */
 
import java.net.URLEncoder;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
//import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
 
/**
 * @author Mingli
 * 
 *         2014-10-15
 */
public class AuthInterceptor implements HandlerInterceptor {
 
    public final static String SEESION_MEMBER = "seesion_member";
 
    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
     */
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
            Exception arg3) throws Exception {
        // TODO Auto-generated method stub
 
    }
 
    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
     */
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
            ModelAndView arg3) throws Exception {
        // TODO Auto-generated method stub
 
    }
 
    /*
     * (non-Javadoc)
     * 拦截mvc.xml配置的/member/**路径的请求
     * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, java.lang.Object)
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        //请求的路径
      
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("username");
        //这里可以根据session的用户来判断角色的权限，根据权限来重定向不同的页面，简单起见，这里只是做了一个重定向
        if (!user.isEmpty()) {
            //被拦截，重定向到login界面
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
 
}
