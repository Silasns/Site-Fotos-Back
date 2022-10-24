package com.api.backfotos.repositories;

import com.api.backfotos.models.FotografoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FotografoRepository extends JpaRepository<FotografoModel, UUID> {
    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);
}
