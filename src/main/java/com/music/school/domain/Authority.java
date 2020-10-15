package com.music.school.domain;

import com.music.school.enums.AuthorityType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "authority")
public class Authority implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;
@Enumerated(EnumType.STRING)
private AuthorityType authorityType;

public Authority() {
}

public Authority(AuthorityType authorityType) {
	this.authorityType = authorityType;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public AuthorityType getAuthorityType() {
	return authorityType;
}

public void setAuthorityType(AuthorityType authorityType) {
	this.authorityType = authorityType;
}

}