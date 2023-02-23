package com.digital.shop.service.impl;

import com.digital.shop.entity.ShopEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ShopServiceImpl {
    List<ShopEntity> getAllShops();

    ShopEntity getShopById(Long id);

    List<ShopEntity> getShopsByLocation(String location);

    ShopEntity saveShop(ShopEntity shop);

    void deleteShop(Long id);
}
