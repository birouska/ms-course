package br.com.birouska.hroauth.services;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.birouska.hroauth.entities.User;
import br.com.birouska.hroauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService {
	
	Logger logger = org.slf4j.LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	public User findByEmail(String email) {
		User user = userFeignClient.findByEmail(email).getBody();
		
		if (user == null) {
			logger.error("Email not Found: " + email);
			throw new IllegalArgumentException("Email not found.");
		}
		
		logger.info("Email Found: " + email);
		
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeignClient.findByEmail(username).getBody();
		
		if (user == null) {
			logger.error("Email not Found: " + username);
			throw new UsernameNotFoundException("Email not found.");
		}
		
		logger.info("Email Found: " + username);
		
		return user;
	}
}
