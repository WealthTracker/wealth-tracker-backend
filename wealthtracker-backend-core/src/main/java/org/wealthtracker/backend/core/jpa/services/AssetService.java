package org.wealthtracker.backend.core.jpa.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.wealthtracker.backend.core.jpa.entity.Asset;
import org.wealthtracker.backend.core.jpa.record.AssetRecord;
import org.wealthtracker.backend.core.jpa.record.MessageRecord;
import org.wealthtracker.backend.core.jpa.record.NewAssetRecord;
import org.wealthtracker.backend.core.jpa.repository.AssetRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class AssetService {

  private final AssetRepository assetRepository;

  public Page<AssetRecord> assets(Pageable pageable) {
    Page<Asset> page = assetRepository.findAll(pageable);
    return page.map(
        asset -> new AssetRecord(String.valueOf(asset.getId()), asset.getName()));
  }

  public MessageRecord addAsset(NewAssetRecord assetRecord) {
    Asset newAsset = Asset.builder()
        .name(assetRecord.name())
        .build();
    Asset save = assetRepository.save(newAsset);
    log.info("created new asset with id: {}", save.getId());
    return new MessageRecord("asset created with name: " + save.getName());
  }


}
