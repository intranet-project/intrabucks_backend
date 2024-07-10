package com.intrabucks.approval.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intrabucks.entity.AttachedFile;

public interface AttachedFileRepository extends JpaRepository<AttachedFile, Long> {

	 Optional<AttachedFile> findById(Long fileId); // 파일 아이디 조회
}
