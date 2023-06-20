package com.main.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "UserInfo")
public class User {
	
	@Id
	@Column(name="ID")
	private String userId;
	@Column(name="email",length = 20)
	private String email;
	private String name;
	private String about;
	
	@Transient
	private List<Rating> ratings=new ArrayList<>();
	

}
