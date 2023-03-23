package com.mohanmmohadikar.inventoryservice.repository;

import com.mohanmmohadikar.inventoryservice.model.Inventory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

  List<Inventory>  findBySkuCodeIn(List<String> skuCode);}
