package com.dollop.OnlineComplaintSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.OnlineComplaintSystem.model.Complaint;
import com.dollop.OnlineComplaintSystem.model.User;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

	List<Complaint> findByUser(User user);

}
