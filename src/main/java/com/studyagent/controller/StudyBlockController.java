package com.studyagent.controller;

import com.studyagent.dto.StudyBlockRequestDTO;
import com.studyagent.dto.StudyBlockResponseDTO;
import com.studyagent.model.StudyBlock;
import com.studyagent.service.StudyBlockService;
import lombok.RequiredArgsConstructor;
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

import java.util.List;

@RestController
@RequestMapping("/v1/study-blocks")
@RequiredArgsConstructor
public class StudyBlockController {

    private final StudyBlockService studyBlockService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudyBlockResponseDTO getStudyBlocks(@PathVariable Long id) {
        return studyBlockService.buscarPorId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudyBlock> listarTodos() {
        return studyBlockService.listarTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudyBlockResponseDTO salvarConteudo(@RequestBody StudyBlockRequestDTO block) {
        return studyBlockService.salvar(block);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public StudyBlockResponseDTO atualizarConteudo(@PathVariable Long id, @RequestBody StudyBlockRequestDTO dataNew) {
        return studyBlockService.atualizar(id, dataNew);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarConteudo(@PathVariable Long id) {
      studyBlockService.delete(id);
    }
}