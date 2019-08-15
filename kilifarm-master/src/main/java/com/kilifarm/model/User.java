package com.kilifarm.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int user_id;
	
	@Column(name = "first_name")
	@NotEmpty(message = "Please provide Your First Name")
	private String first_name;
	
	@Column(name = "last_name")
	@NotEmpty(message = "Please provide Your Last Name")
	private String last_name;
	
	@Pattern(regexp = "(\\+254|0)[0-9]{9}")
	@NotEmpty(message = "Please provide your phone number")
	@Column(name = "phone", unique = true)
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	@NotEmpty(message = "Please provide Your Password")
	@Length(min = 5, message = "*Your password MUST be more than 5 characters")
	private String password;
	
	@Column(name = "active")
	private int active;
	
	@CreationTimestamp
	@Column(name = "created_at")
    private LocalDateTime created_at;
 
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updated_at;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
}
