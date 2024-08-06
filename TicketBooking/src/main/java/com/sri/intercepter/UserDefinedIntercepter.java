package com.sri.intercepter;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class UserDefinedIntercepter implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		int hour=LocalDateTime.now().getHour();
		if(hour>10) {
			System.err.println(hour);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/pages/error/RestrictionPeriod.jsp");
			rd.forward(request, response);
			return false;
		}
		return true;
	}
}
