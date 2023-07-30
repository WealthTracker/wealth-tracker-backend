package org.wealthtracker.backend.core.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wealthtracker.backend.core.jpa.entity.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {

}
