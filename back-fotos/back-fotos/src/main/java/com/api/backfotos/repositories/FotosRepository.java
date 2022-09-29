package com.api.backfotos.repositories;

import com.api.backfotos.models.FotosModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FotosRepository extends JpaRepository<FotosModel, UUID> {
}
