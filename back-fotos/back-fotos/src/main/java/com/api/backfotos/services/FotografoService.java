package com.api.backfotos.services;

import com.api.backfotos.models.ClienteModel;
import com.api.backfotos.models.FotografoModel;
import com.api.backfotos.repositories.FotografoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FotografoService {

    final FotografoRepository fotografoRepository;

    @Transactional
    public FotografoModel save(FotografoModel fotografoModel) {
        return fotografoRepository.save(fotografoModel);
    }

    public FotografoService(FotografoRepository fotografoRepository){
        this.fotografoRepository = fotografoRepository;
    }
    public boolean existsByCpf(String cpf) {
        return fotografoRepository.existsByCpf(cpf);
    }

    public boolean existsByEmail(String email) {
        return fotografoRepository.existsByEmail(email);
    }

    public List<FotografoModel> findAll() {
        return fotografoRepository.findAll();
    }

    public Optional<FotografoModel> findById(UUID id) {
        return fotografoRepository.findById(id);
    }

    public void delete(FotografoModel fotografoModel) {
        fotografoRepository.delete(fotografoModel);
    }
}
