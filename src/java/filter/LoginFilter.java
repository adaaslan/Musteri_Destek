package filter;

import controller.LoginBean;
import entity.Musteriler;
import java.io.IOException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter("/view/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String url = req.getRequestURI();
//
        Musteriler m = (Musteriler) req.getSession().getAttribute("valid_user");
//
        if (m == null) {
            if (url.contains("secret") || url.contains("logout")) {
                res.sendRedirect(req.getContextPath() + "/login.xhtml");
            } else {
                chain.doFilter(request, response);
            }
        } else {
            if (url.contains("register") || url.contains("login")) {
                res.sendRedirect(req.getContextPath() + "/secret/secret.xhtml");
            } else if (url.contains("logout")) {
                req.getSession().invalidate();
                res.sendRedirect(req.getContextPath() + "/view/anasayfa.xhtml");
            } else {
                chain.doFilter(request, response);
            }

        }
// Get the loginBean from session attribute
        LoginBean loginBean = (LoginBean) ((HttpServletRequest) request).getSession().getAttribute("loginBean");
        System.out.println("aaaaaaaaaaaaaaa" + ((HttpServletRequest) request).getSession());
        System.out.println("aaaaaaaaaaaaaaa" + ((HttpServletRequest) request).getSession().getAttributeNames());
        // For the first application request there is no loginBean in the session so user needs to log in
        // For other requests loginBean is present but we need to check if user has logged in successfully
        if (loginBean == null || !loginBean.isLoggedIn()) {
            String contextPath = ((HttpServletRequest) request).getContextPath();
            System.out.println(contextPath);
            ((HttpServletResponse) response).sendRedirect(contextPath + "/login.xhtml");
        }

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

}
