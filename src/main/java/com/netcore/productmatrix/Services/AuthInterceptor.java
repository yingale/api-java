package com.netcore.productmatrix.Services;

import java.io.IOException;
import java.util.*;

import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

	@Value("${spring.auth.ips}")
	private String ipPool;

	private boolean validateIp(String ip) {
		List<String> iplist = new ArrayList<String>(Arrays.asList(ipPool.split(",")));
		return iplist.contains(ip);
	}

	private String getClientIP(HttpServletRequest request) {
		String remoteAddr = "";
		if (request != null) {
			remoteAddr = request.getHeader("X-FORWARDED-FOR");
			if (remoteAddr == null || "".equals(remoteAddr)) {
				remoteAddr = request.getRemoteAddr();
			}
		}
		return remoteAddr;
	}

	private void returnUnAuthResponse(HttpServletResponse response, String ipAddress) throws IOException {
		logger.info("User not allowed from IP :: " + ipAddress);
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		JSONObject errorMessage = new JSONObject();
		try {
			errorMessage.put("error", "Unauthorised");
			errorMessage.put("Message", "You are not authorised to access this page.");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		response.getOutputStream().println(errorMessage.toString());
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	                throws IOException {
		UUID uuid = UUID.randomUUID();
		String processId = uuid.toString();
		long startTime = System.currentTimeMillis();
		String ipAddress = getClientIP(request);
		logger.info("PreHandle, Process Id :: " + processId + ", Request IP :: " + ipAddress + ", Request URL :: "
		                + request.getMethod() + ", " + request.getRequestURL().toString() + ", Start Time :: "
		                + System.currentTimeMillis());
		request.setAttribute("startTime", startTime);
		request.setAttribute("processId", processId);
		String loggedInUser = request.getParameter("username");
		logger.info("Requesting User :: " + loggedInUser);

		if (validateIp(ipAddress) == false || loggedInUser == "" || loggedInUser == null) {
			this.returnUnAuthResponse(response, ipAddress);
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	                ModelAndView modelAndView) throws Exception {
		String processId = request.getAttribute("processId").toString();
		logger.info("Sent to Handler, Process Id :: " + processId + ", Request URL :: " + request.getMethod() + " "
		                + request.getRequestURL().toString() + ", Current Time :: " + System.currentTimeMillis());
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
	                throws Exception {
		long startTime = (Long) request.getAttribute("startTime");
		long timetaken = (System.currentTimeMillis() - startTime);
		String processId = request.getAttribute("processId").toString();

		logger.info("AfterCompletion, Process Id :: " + processId + ", Request URL :: " + request.getMethod() + ", "
		                + request.getRequestURL().toString() + ", End Time :: " + System.currentTimeMillis()
		                + ", Time Taken :: " + timetaken);
	}

}