package com.digital.shop.service;

import com.digital.shop.entity.Shop;
import com.digital.shop.repository.ShopRepository;
import com.digital.shop.service.impl.ShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
public class ShopService implements ShopServiceImpl {

    @Autowired
    private ShopRepository shopRepository;

    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    public List<Shop> getShopsByLocation(String location) {
        return shopRepository.findAllByLocation(location);
    }

    public Shop saveShop(Shop shop) {
        return shopRepository.save(shop);
    }

    public void deleteShop(Long id) {
        shopRepository.deleteById(id);
    }
}
