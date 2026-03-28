package com.studyagent.service;

import com.studyagent.exception.EntityNotFoundException;
import com.studyagent.model.StudyBlock;
import com.studyagent.repository.StudyBlockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudyBlockService {

    private final StudyBlockRepository blockRepository;

    public final StudyBlock buscarPorId(Long id) {
        Optional<StudyBlock> studyBlock = blockRepository.findById(id);

        return studyBlock.orElseThrow(() -> new EntityNotFoundException("Id não existe"));
    }

    public final StudyBlock salvar(StudyBlock studyBlock) {
        return blockRepository.save(studyBlock);
    }

    public StudyBlock atualizar(Long id, StudyBlock dataNew) {
        StudyBlock blocoExistente = buscarPorId(id);

        blocoExistente.setName(dataNew.getName());
        blocoExistente.setSubject(dataNew.getSubject());

        return blockRepository.save(blocoExistente);
    }

    public void delete(Long id) {
        StudyBlock blocoExistente = buscarPorId(id);

        blockRepository.delete(blocoExistente);
    }
}