package com.jambler.bfm.repository;

import com.jambler.bfm.domain.ShopItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopItemRepository extends JpaRepository<ShopItem, Long> {
}
