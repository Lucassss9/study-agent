package com.studyagent.service;

import com.studyagent.dto.StudyBlockRequestDTO;
import com.studyagent.dto.StudyBlockResponseDTO;
import com.studyagent.exception.EntityNotFoundException;
import com.studyagent.model.StudyBlock;
import com.studyagent.repository.StudyBlockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyBlockService {

    private final StudyBlockRepository blockRepository;

    public List<StudyBlockResponseDTO> listarTodos(){
        return blockRepository.findAll()
                .stream()
                .map(block -> new StudyBlockResponseDTO(
                        block.getId(),
                        block.getName(),
                        block.getSubject()))
                .toList();
    }

    protected StudyBlock buscarEntidadePorId(Long id) {
        return blockRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bloco com id " + id + " não encontrado"));
    }

    public StudyBlockResponseDTO buscarPorId(Long id) {
        StudyBlock block = buscarEntidadePorId(id);
        return new StudyBlockResponseDTO(block.getId(), block.getName(), block.getSubject());
    }

    @Transactional
    public StudyBlockResponseDTO salvar(StudyBlockRequestDTO dto) {
        StudyBlock block = new StudyBlock();
        block.setName(dto.getName());
        block.setSubject(dto.getSubject());
        StudyBlock salvo = blockRepository.save(block);

        return new StudyBlockResponseDTO(salvo.getId(), salvo.getName(), salvo.getSubject());
    }

    @Transactional
    public StudyBlockResponseDTO atualizar(Long id, StudyBlockRequestDTO dto) {
        StudyBlock blocoExistente = buscarEntidadePorId(id);
        blocoExistente.setName(dto.getName());
        blocoExistente.setSubject(dto.getSubject());
        StudyBlock salvo = blockRepository.save(blocoExistente);

        return new StudyBlockResponseDTO(salvo.getId(), salvo.getName(), salvo.getSubject());
    }

    @Transactional
    public void delete(Long id) {
        StudyBlock blocoExistente = buscarEntidadePorId(id);
        blockRepository.delete(blocoExistente);
    }
}