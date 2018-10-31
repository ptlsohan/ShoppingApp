package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

@Component("urlFilter")
public class CategoryFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CategoryFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//System.out.println(((HttpServletRequest)request).getRequestURI());
		
		//request.setAttribute("url", ((HttpServletRequest)request).getRequestURI());
		//System.out.println(((HttpServletRequest)request).getRequestURI());
//		 request.setAttribute("url", ((HttpServletRequest)request).getRequestURI());
//	        RequestDispatcher rd= ((HttpServletRequest)request).getRequestDispatcher("loginValidate");
//	        rd.forward(request, response);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
