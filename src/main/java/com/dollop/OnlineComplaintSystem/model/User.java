package com.dollop.OnlineComplaintSystem.model;

import java.sql.Date;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.dollop.OnlineComplaintSystem.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userTable")
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private Long id;
	@Column(name = "userName")
	private String name;
	@Column(name = "userEmail", unique = true)
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "userMobile")
	private String mobile;
	@Column(name = "registrationDate" ,updatable = false)
	@CreationTimestamp
	private LocalDateTime registrationDate;
	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private Role role=Role.USER;

}
