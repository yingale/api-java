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
			Properties properties = new Properties();
			properties.setProperty("mail.store.protocol", "imaps");
			properties.put("mail.imaps.host", "sm1.netcore.in");
			properties.put("mail.imaps.port", 993);
			properties.put("mail.imaps.fetchsize", 10);
			properties.put("mail.imaps.starttls.enable", "false");
			properties.put("mail.imaps.ssl.checkserveridentity", "false");
			properties.setProperty("mail.imap.connectiontimeout", "5000");
			properties.setProperty("mail.imap.timeout", "5000");
			MailSSLSocketFactory socketFactory= new MailSSLSocketFactory();
			socketFactory.setTrustAllHosts(true);
			properties.put("mail.imaps.ssl.socketFactory", socketFactory);
			properties.setProperty("mail.imaps.ssl.trust", "*");
			Session emailSession = Session.getInstance(properties);
//			emailSession.setDebug(true);
			Store store = emailSession.getStore("imaps");
			store.connect(username, password);
			store.close();
			return true;
		} catch(AuthenticationFailedException e) {
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

}
