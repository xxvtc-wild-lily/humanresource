package com.ysd.humanresource.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ysd.humanresource.dao.LoginMapper;
import com.ysd.humanresource.entity.Employee;
import com.ysd.humanresource.util.TokenUtil;

import io.jsonwebtoken.Claims;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private LoginMapper loginMapper;
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		String token = request.getParameter("token");
		
		// 判断token是否为空
		if (token != null && token != "" && !token.isEmpty()) {
			Claims parserTonken = TokenUtil.parserTonken(token);
			Employee employee = loginMapper.selectEmployeeById(Integer.parseInt(parserTonken.getId()));
			
			// 判断token中的数据是否与数据库中该token对应的数据一致
			if (employee.getEmp_name().equals(parserTonken.getSubject())) {
				return true;
			} else {
				return false;
			}
		}
        
        return false;
    }
	
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    	
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    	
    }
	
}
