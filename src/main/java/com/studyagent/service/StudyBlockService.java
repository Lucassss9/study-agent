package com.studyagent.service;

import com.studyagent.dto.StudyBlockRequestDTO;
import com.studyagent.dto.StudyBlockResponseDTO;
import com.studyagent.exception.DataValidationException;
import com.studyagent.exception.EntityNotFoundException;
import com.studyagent.model.StudyBlock;
import com.studyagent.repository.StudyBlockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudyBlockService {

    private final StudyBlockRepository blockRepository;

    protected StudyBlock buscarEntidadePorId(Long id) {
        return blockRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Id não existe"));
    }

    public StudyBlockResponseDTO buscarPorId(Long id) {
        StudyBlock block = buscarEntidadePorId(id);
        return new StudyBlockResponseDTO(block.getId(), block.getName(), block.getSubject());
    }

    public StudyBlockResponseDTO salvar(StudyBlockRequestDTO dto) {
        StudyBlock block = new StudyBlock();

        if (dto.getName() == null || dto.getName().isBlank()) {
            throw new DataValidationException("O nome do bloco de estudo não pode ser vazio.");
        }

        block.setName(dto.getName());
        block.setSubject(dto.getSubject());
        StudyBlock salvo = blockRepository.save(block);

        return new StudyBlockResponseDTO(salvo.getId(), salvo.getName(), salvo.getSubject());
    }

    public StudyBlockResponseDTO atualizar(Long id, StudyBlockRequestDTO dto) {
        StudyBlock blocoExistente = buscarEntidadePorId(id);

        if (dto.getName() == null || dto.getName().isBlank()) {
            throw new DataValidationException("O nome do bloco de estudo não pode ser vazio.");
        }

        blocoExistente.setName(dto.getName());
        blocoExistente.setSubject(dto.getSubject());
        StudyBlock salvo = blockRepository.save(blocoExistente);

        return new StudyBlockResponseDTO(salvo.getId(), salvo.getName(), salvo.getSubject());
    }

    public void delete(Long id) {
        StudyBlock blocoExistente = buscarEntidadePorId(id);
        blockRepository.delete(blocoExistente);
    }
}