package com.intrabucks.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class BucksAccessDeniedHandler implements AccessDeniedHandler {
	
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException accessDeniedException) throws IOException, ServletException {
	response.setStatus(HttpServletResponse.SC_FORBIDDEN); // 403 Forbidden 상태 코드
	response.getWriter().write("Access Denied!"); // 클라이언트에게 메시지 전달
	}
}
