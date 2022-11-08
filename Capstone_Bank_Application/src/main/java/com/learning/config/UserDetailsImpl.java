/*package com.learning.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.learning.entity.User;

public class UserDetailsImpl implements UserDetails {
	
	@Autowired
	User user;
	
	private String username;
	private String password;
	private boolean active;
	private List<GrantedAuthority> roles;
	
	
	public UserDetailsImpl (User user) {
		this.username = user.getUserName();
		this.password = user.getPassword();
		this.active = user.isActive();
		this.roles = Arrays.stream(user.getRole().split(","))
								.map(SimpleGrantedAuthority::new)
								.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return roles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true; //for now we can return active
	}

}
*/