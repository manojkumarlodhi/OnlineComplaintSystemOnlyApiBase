package com.dollop.OnlineComplaintSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.OnlineComplaintSystem.model.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

}
