package com.briup.estore.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/*@WebFilter(filterName = "EncodingFilter",
        urlPatterns = "/*",
        initParams={@WebInitParam(name = "encode", value = "UTF-8")})*/
public class EncodingFilter implements Filter {
    private static String encode = "utf-8";

    public void init(FilterConfig config) throws ServletException {
        encode = config.getInitParameter("encode");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("EncodingFilter doFilter ...");

        request.setCharacterEncoding(encode);
        response.setCharacterEncoding(encode);
        response.setContentType("text/html;charset=utf-8");

        chain.doFilter(request, response);

    }

    public void destroy() {
    }

}
