package com.netcore.productmatrix.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netcore.productmatrix.Services.AuthService;
import com.netcore.productmatrix.Services.CompressionService;

@RestController
@EnableAutoConfiguration
public class AuthController {

	@Autowired
	private AuthService authService;

	@Autowired
	private CompressionService compressionService;

	@RequestMapping("/")
	public String home() {
		return "Welcome home";
	}

	@RequestMapping(value = "/login", params = { "username", "password" })
	public HashMap<String, String> authRequest(HttpServletRequest request,
			@RequestParam("username") String username,
			@RequestParam("password") String password) {
		String passwordDecompressed = CompressionService.decompressFromBase64(password);
		return this.authService.getAuthDetails(username, passwordDecompressed);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String getAuth() {
		return "narendra";

	}
}
