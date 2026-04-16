package com.studyagent.repository;

import com.studyagent.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Long> {

    public List<Content> findByStudyBlockId(Long blockId);
}
