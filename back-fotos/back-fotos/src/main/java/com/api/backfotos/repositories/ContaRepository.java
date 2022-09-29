package com.api.backfotos.repositories;

import com.api.backfotos.models.ContaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContaRepository extends JpaRepository<ContaModel, UUID> {
}
