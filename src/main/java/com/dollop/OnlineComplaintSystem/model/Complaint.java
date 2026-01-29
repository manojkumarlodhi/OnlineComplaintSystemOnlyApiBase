package com.dollop.OnlineComplaintSystem.model;

import java.sql.Date;
import java.time.LocalDateTime;

import com.dollop.OnlineComplaintSystem.enums.ComplaintStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "complaint")
public class Complaint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "complaintId")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "userId",nullable = false)
	private User user;
	@Column(name = "category")
	private String category;
	@Column(name = "description")
	private String description;
	@Enumerated(EnumType.STRING)
	@Column(name = "ComplaintStatus ")
	private ComplaintStatus status=ComplaintStatus.OPEN;
	@Column(name = "createdAt")
	private LocalDateTime createdAt;
	@Column(name="updatedAt")
	private LocalDateTime updatedAt;

}
