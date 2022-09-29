package com.api.backfotos.repositories;

import com.api.backfotos.models.ProvaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProvaRepository extends JpaRepository<ProvaModel, UUID> {
}
