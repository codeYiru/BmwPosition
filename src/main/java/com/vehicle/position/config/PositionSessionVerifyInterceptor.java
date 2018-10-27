package com.vehicle.position.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.vehicle.position.auth.api.IAuthService;
import com.vehicle.position.services.so.VechResponseSo;
import com.vehicle.position.services.so.VehicleSessionSo;

public class PositionSessionVerifyInterceptor extends HandlerInterceptorAdapter {

	private final static Logger LOG = LoggerFactory.getLogger(PositionSessionVerifyInterceptor.class);

	@Autowired
	private IAuthService authService;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String session = request.getParameter("session");

		if (session != null && !session.isEmpty()) {
			VehicleSessionSo object = authService.checkSession(session);
			if (object != null) {
				request.setAttribute("vehicleSession", object);
				LOG.info(session + ": Session Authenticated");
				return true;
			}
		}
		LOG.info(session + ": Session Authenticate failed");
		response.setStatus(HttpStatus.OK.value());
		response.setContentType("application/json");

		response.getWriter().println((new VechResponseSo(VechResponseSo.ERROR, "AUTHENTICATION_ERROR")).toJsonString());

		return false;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
