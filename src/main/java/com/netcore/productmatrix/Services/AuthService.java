package com.netcore.productmatrix.Services;


import java.util.HashMap;
import java.util.Properties;
import javax.mail.AuthenticationFailedException;	
import javax.mail.Session;
import javax.mail.Store;
import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
@Configuration
public class AuthService {

	@Value("${spring.mail.pop3Host}")
	private String pop3Host;
	
	@Value("${spring.mail.pop3Port}")
	private String pop3Port;
	
	public HashMap<String, String> getAuthDetails(String username, String password) {
		HashMap<String, String> map = new HashMap<>();
		map.put("status", "You are not authorized to access this page.");
		if (this.verify(username, password)) {
			map.put("uname", username);
			map.put("status", "authorized user");
			return map;
		}

		return map;
	}

	public Boolean verify(String username, String password) {
		try {
			System.err.println("Need to write login code");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

}
