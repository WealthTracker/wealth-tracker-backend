package org.wealthtracker.backend.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wealthtracker.backend.core.jpa.record.AssetRecord;
import org.wealthtracker.backend.core.jpa.record.MessageRecord;
import org.wealthtracker.backend.core.jpa.record.NewAssetRecord;
import org.wealthtracker.backend.core.jpa.services.AssetService;

@RestController
@RequestMapping("/v1/assets")
@RequiredArgsConstructor
public class AssetController {

  private final AssetService assetService;

  @GetMapping(produces = "application/json")
  public ResponseEntity<Page<AssetRecord>> list(Pageable pageable) {
    Page<AssetRecord> assets = assetService.assets(pageable);
    return ResponseEntity.ok(assets);
  }

  @PostMapping(
      produces = "application/json"
  )
  public ResponseEntity<MessageRecord> createOrder(@RequestBody NewAssetRecord assetRecord) {
    MessageRecord messageRecord = assetService.addAsset(assetRecord);
    return new ResponseEntity<>(messageRecord, HttpStatus.CREATED);
  }

}
