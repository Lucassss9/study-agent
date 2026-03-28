package com.studyagent.service;

import com.studyagent.dto.ContentRequestDTO;
import com.studyagent.dto.ContentResponseDTO;
import com.studyagent.dto.StudyBlockResponseDTO;
import com.studyagent.exception.EntityNotFoundException;
import com.studyagent.model.Content;
import com.studyagent.model.StudyBlock;
import com.studyagent.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContentService {

    private final ContentRepository contentRepository;
    private final StudyBlockService blockService;

    private Content buscarEntidadePorId(Long id) {
        return contentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Id não existe"));
    }

    public ContentResponseDTO buscarPorId(Long id) {
        Content content = buscarEntidadePorId(id);
        return new ContentResponseDTO(content.getId(), content.getTitle(), content.getDateTime());
    }

    public final ContentResponseDTO salvar(ContentRequestDTO contentResquest, Long blockId) {
        StudyBlock block = blockService.buscarEntidadePorId(blockId);
        Content content = new Content();
        content.setTitle(contentResquest.getTitle());
        content.setDateTime(contentResquest.getDateTime());
        content.setStudyBlock(block);
        Content salvo = contentRepository.save(content);

        return new ContentResponseDTO(salvo.getId(), salvo.getTitle(), salvo.getDateTime());
    }

    public ContentResponseDTO atualizar(Long id, ContentRequestDTO dataNew) {
        Content contentExistente = buscarEntidadePorId(id);
        contentExistente.setTitle(dataNew.getTitle());
        contentExistente.setDateTime(dataNew.getDateTime());
        Content salvo = contentRepository.save(contentExistente);

        return new ContentResponseDTO(salvo.getId(), salvo.getTitle(), salvo.getDateTime());
    }

    public void delete(Long id) {
        Content contentExistente = buscarEntidadePorId(id);
        contentRepository.delete(contentExistente);
    }
}
