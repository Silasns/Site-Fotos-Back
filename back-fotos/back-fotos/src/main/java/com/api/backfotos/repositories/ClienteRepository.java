package com.api.backfotos.repositories;

import com.api.backfotos.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, UUID> {

    boolean existsByEmail(String email);

    boolean existsByCpf(String cpf);
}
