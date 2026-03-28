package com.studyagent.controller;

import com.studyagent.dto.ContentRequestDTO;
import com.studyagent.dto.ContentResponseDTO;
import com.studyagent.model.Content;
import com.studyagent.service.ContentService;
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
@RequestMapping("/v1/study-blocks/{blockId}/contents")
public class ContentController {

    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContentResponseDTO buscarPorId(@PathVariable Long id) {
        return contentService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContentResponseDTO salvarConteudo(@PathVariable Long blockId, @RequestBody ContentRequestDTO content) {
        return contentService.salvar(content, blockId);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ContentResponseDTO atualizarConteudo(@PathVariable Long id, @RequestBody ContentRequestDTO dataNew) {
        return contentService.atualizar(id, dataNew);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarConteudo(@PathVariable Long id) {
        contentService.delete(id);
    }
}
