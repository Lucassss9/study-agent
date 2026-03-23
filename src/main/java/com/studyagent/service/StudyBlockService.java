package com.studyagent.service;

import com.studyagent.exception.EntityNotFoundException;
import com.studyagent.model.StudyBlock;
import com.studyagent.repository.StudyBlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service()
public class StudyBlockService {
    @Autowired
    private StudyBlockRepository blockRepository;

    public final StudyBlock buscarPorId(Long id) {
        Optional<StudyBlock> studyBlock = blockRepository.findById(id);

        return studyBlock.orElseThrow(() -> new EntityNotFoundException("Id não existe"));
    }

    public final StudyBlock salvar(StudyBlock studyBlock) {
        return blockRepository.save(studyBlock);
    }
}
