package com.intrabucks.approval.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intrabucks.entity.AttachedFile;

public interface AttachedFileRepository extends JpaRepository<AttachedFile, Long> {

}
