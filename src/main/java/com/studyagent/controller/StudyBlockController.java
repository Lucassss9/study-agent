package com.studyagent.controller;

import com.studyagent.model.StudyBlock;
import com.studyagent.service.StudyBlockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/study-blocks")
public class StudyBlockController {
    private StudyBlockService studyBlockService;

    public StudyBlockController(StudyBlockService studyBlockService) {
        this.studyBlockService = studyBlockService;
    }

    @GetMapping("{id}")
    public StudyBlock getStudyBlocks(@PathVariable Long id) {
        return studyBlockService.buscarPorId(id);
    }
}
