package com.studyagent.service;

import com.studyagent.exception.EntityNotFoundException;
import com.studyagent.model.Content;
import com.studyagent.model.StudyBlock;
import com.studyagent.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContentService {

    private final ContentRepository contentRepository;
    private final StudyBlockService blockService;

    public final Content buscarPorId(Long id) {
        Optional<Content> content = contentRepository.findById(id);

        return content.orElseThrow(() -> new EntityNotFoundException("Id não existe"));
    }

    public final Content salvar(Content content, Long blockId) {
        StudyBlock block = blockService.buscarPorId(content.getStudyBlock().getId());
        content.setStudyBlock(block);
        return contentRepository.save(content);
    }

    public Content atualizar(Long id, Content dataNew) {
        Content contentExistente = buscarPorId(id);

        contentExistente.setTitle(dataNew.getTitle());
        contentExistente.setDateTime(dataNew.getDateTime());

        return contentRepository.save(contentExistente);
    }

    public void delete(Long id) {
        Content contentExistente = buscarPorId(id);

        contentRepository.delete(contentExistente);
    }
}
