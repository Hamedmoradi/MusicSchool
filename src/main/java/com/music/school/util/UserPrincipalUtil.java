package com.music.school.util;

import com.music.school.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

public class UserPrincipalUtil implements UserDetails, Serializable {
@Autowired
private User user;

public UserPrincipalUtil(User user) {
	this.user = user;
}

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	return null;
}

@Override
public String getPassword() {
	return user.getPassword();
}

@Override
public String getUsername() {
	return user.getUsername();
}

@Override
public boolean isAccountNonExpired() {
	return false;
}

@Override
public boolean isAccountNonLocked() {
	return false;
}

@Override
public boolean isCredentialsNonExpired() {
	return false;
}

@Override
public boolean isEnabled() {
	return true;
}

}