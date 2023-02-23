package com.digital.shop.service;

import com.digital.shop.entity.ShopEntity;
import com.digital.shop.repository.ShopRepository;
import com.digital.shop.service.impl.ShopServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
public class ShopService implements ShopServiceImpl {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ShopRepository shopRepository;

    public List<ShopEntity> getAllShops() {
        return shopRepository.findAll();
    }

    @Override
    public ShopEntity getShopById(Long shopID) {
        LOGGER.info("Finding shop profile by Shop ID [{}]", shopID);
        ShopEntity shopEntity = shopRepository.findById(shopID).orElse(null);
        LOGGER.info("Retrieved shop profile with Shop ID[{}]", shopID);
        return shopEntity;
    }

    public List<ShopEntity> getShopsByLocation(String location) {
        return shopRepository.findAllByLocation(location);
    }

    public ShopEntity saveShop(ShopEntity shop) {
        return shopRepository.save(shop);
    }

    public void deleteShop(Long id) {
        shopRepository.deleteById(id);
    }
}
