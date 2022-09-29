package com.api.backfotos.repositories;

import com.api.backfotos.models.FotografoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FotografoRepository extends JpaRepository<FotografoModel, UUID> {
}
