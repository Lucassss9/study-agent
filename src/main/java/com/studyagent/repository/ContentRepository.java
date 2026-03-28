package com.studyagent.repository;

import com.studyagent.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
}
