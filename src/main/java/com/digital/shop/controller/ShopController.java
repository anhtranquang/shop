package com.digital.shop.controller;

import com.digital.shop.aspect.LogAround;
import com.digital.shop.controller.response.MenuResponse;
import com.digital.shop.controller.response.ResponseStatusEnum;
import com.digital.shop.controller.response.ShopResponse;
import com.digital.shop.domain.GeneralResponse;
import com.digital.shop.entity.ShopEntity;
import com.digital.shop.exeption.BadRequestValidationException;
import com.digital.shop.factory.ResponseFactory;
import com.digital.shop.service.impl.ShopServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/shops")
public class ShopController {
    @Autowired
    private ShopServiceImpl shopService;

    @Autowired
    private ResponseFactory responseFactory;
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Description("API for get Shop Information by shop ID. If there are no matching Shop with given ID will be throw bad request exception")
    @GetMapping("/{shop_id}")
    @LogAround(message = "Get active shop by ID")
    public ResponseEntity<GeneralResponse<ShopResponse>> getShopById(@PathVariable(name = "shop_id") Long shopId) {
        ResponseEntity response;
        ShopResponse shop = buildShopResponseFromShopEntity(getShopEntity(shopId));
        response = responseFactory.success(shop, ShopResponse.class);
        return response;
    }

    private ShopEntity getShopEntity(Long shopId){
        ShopEntity shopEntity = shopService.getShopById(shopId);
        if(shopEntity == null){
            LOGGER.error("Cannot find shop information with shopID [{}]", shopId);
            throw new BadRequestValidationException(ResponseStatusEnum.SHOP_NOT_EXIST);
        }
        return shopEntity;
    }

    private ShopResponse buildShopResponseFromShopEntity(ShopEntity shopEntity){
        ShopResponse shopResponse;
        List<MenuResponse> menuResponses = new ArrayList<>();
        if(shopEntity.getMenus().size() > 0){
            shopEntity.getMenus().forEach(menu -> {
                MenuResponse menuResponse = new MenuResponse(menu.getId(), menu.getItemName(), menu.getPrice());
                menuResponses.add(menuResponse);
            });
        }
        shopResponse = new ShopResponse(shopEntity.getId(),shopEntity.getName(), shopEntity.getLocation(), menuResponses);
        return shopResponse;
    }

}
