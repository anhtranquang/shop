package com.digital.shop.controller;

import com.digital.shop.entity.Shop;
import com.digital.shop.service.ShopService;
import com.digital.shop.service.impl.ShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shops")
public class ShopController {
    @Autowired
    private ShopServiceImpl shopService;

    @GetMapping("")
    public ResponseEntity<List<Shop>> getAllShops() {
        List<Shop> shops = shopService.getAllShops();
        return new ResponseEntity<>(shops, HttpStatus.OK);
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<Shop>> getShopsByLocation(@PathVariable String location) {
        List<Shop> shops = shopService.getShopsByLocation(location);
        return new ResponseEntity<>(shops, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Shop> saveShop(@RequestBody Shop shop) {
        Shop savedShop = shopService.saveShop(shop);
        return new ResponseEntity<>(savedShop, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShop(@PathVariable Long id) {
        shopService.deleteShop(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
