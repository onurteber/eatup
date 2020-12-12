package com.eatup.authserver.security;

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

@Service
public class UserDetailsServiceImpl implements UserDetailsService  {
	
	@Autowired
	private BCryptPasswordEncoder encoder;

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
}