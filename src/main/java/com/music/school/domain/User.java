package com.music.school.domain;


import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "users")
public class User implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;
@NotEmpty


@Column(name = "username",nullable = false, unique = true,columnDefinition = "VARCHAR")
private String username;
@NotEmpty
@Column(name = "password",columnDefinition = "VARCHAR")
private String password;

@Column(name = "enabled")
private boolean enabled;

@Column(name = "dateCreated")
private Date dateCreated;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name ="FK_Authority_Id",nullable = false)
private Authority authorities ;

public User() {
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

public Date getDateCreated() {
	return dateCreated;
}

public void setDateCreated(Date dateCreated) {
	this.dateCreated = dateCreated;
}

public boolean isEnabled() {
	return enabled;
}

public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}

public Authority getAuthorities() {
	return authorities;
}

public void setAuthorities(Authority authorities) {
	this.authorities = authorities;
}
}