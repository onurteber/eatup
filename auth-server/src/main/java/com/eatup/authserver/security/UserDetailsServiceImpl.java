package com.eatup.authserver.security;

import com.eatup.authserver.entity.UserEntity;
import com.eatup.authserver.model.LoginUserModel;
import com.eatup.authserver.repository.UserRepository;
import com.eatup.authserver.service.EatupCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserDetailsServiceImpl implements UserDetailsService  {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private UserRepository userRepository;


	@Autowired
	private EatupCustomRepository eatupCustomRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		List<LoginUserModel> userAndRolesByUsername = eatupCustomRepository.getUserAndRolesByUsername(username);

		if (userAndRolesByUsername != null && userAndRolesByUsername.get(0).getActive()) {
			StringBuilder sr = new StringBuilder();
			for(LoginUserModel appUser: userAndRolesByUsername) {
				sr.append(appUser.getName()); // Role Name
			}
			if(userAndRolesByUsername.get(0).getUserName().equals(username)) {

				List<GrantedAuthority> grantedAuthorities = AuthorityUtils
						.createAuthorityList(String.valueOf(sr));

				return new User(userAndRolesByUsername.get(0).getUserName(), encoder.encode(userAndRolesByUsername.get(0).getPassword()), grantedAuthorities);
			}
		}


		throw new UsernameNotFoundException("Username: " + username + " not found");
	}

	private static class AppUser {
		private Integer id;
	    private String username, password;
	    private List<String> role;
	    
		public AppUser(Integer id, String username, String password, List<String> role) {
	    	this.id = id;
	    	this.username = username;
	    	this.password = password;
	    	this.role = role;
	    }

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

	    public List<String> getRole() {
			return role;
		}

		public void setRole(List<String> role) {
			this.role = role;
		}
	}
}