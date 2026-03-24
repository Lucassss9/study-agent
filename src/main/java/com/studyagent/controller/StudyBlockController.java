package com.studyagent.controller;

import com.studyagent.model.StudyBlock;
import com.studyagent.service.StudyBlockService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/study-blocks")
public class StudyBlockController {

    private StudyBlockService studyBlockService;

    public StudyBlockController(StudyBlockService studyBlockService) {
        this.studyBlockService = studyBlockService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudyBlock getStudyBlocks(@PathVariable Long id) {
        return studyBlockService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudyBlock salvarConteudo(@RequestBody StudyBlock block) {
        return studyBlockService.salvar(block);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public StudyBlock atualizarConteudo(@PathVariable Long id, @RequestBody StudyBlock dataNew) {
        return studyBlockService.atualizar(id, dataNew);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarConteudo(@PathVariable Long id) {
      studyBlockService.delete(id);
    }
}