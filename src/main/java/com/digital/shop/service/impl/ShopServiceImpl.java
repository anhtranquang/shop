package com.digital.shop.service.impl;

import com.digital.shop.entity.Shop;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShopServiceImpl {
    List<Shop> getAllShops();

    List<Shop> getShopsByLocation(String location);

    Shop saveShop(Shop shop);

    void deleteShop(Long id);
}
