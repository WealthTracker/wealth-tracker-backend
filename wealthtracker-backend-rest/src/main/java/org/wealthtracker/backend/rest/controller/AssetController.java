package org.wealthtracker.backend.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wealthtracker.backend.core.jpa.entity.Asset;
import org.wealthtracker.backend.core.jpa.services.AssetService;

@RestController
@RequestMapping("/v1/assets")
@RequiredArgsConstructor
public class AssetController {

  private final AssetService assetService;

  @GetMapping(produces = "application/json")
  public ResponseEntity<Page<Asset>> list(Pageable pageable) {
    Page<Asset> assets = assetService.assets(pageable);
    return ResponseEntity.ok(assets);
  }

}
