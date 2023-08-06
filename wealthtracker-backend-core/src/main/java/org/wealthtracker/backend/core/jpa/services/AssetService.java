package org.wealthtracker.backend.core.jpa.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.wealthtracker.backend.core.jpa.entity.Asset;
import org.wealthtracker.backend.core.jpa.repository.AssetRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class AssetService {

  private final AssetRepository assetRepository;

  public Page<Asset> assets(Pageable pageable) {
    return assetRepository.findAll(pageable);
  }


}
