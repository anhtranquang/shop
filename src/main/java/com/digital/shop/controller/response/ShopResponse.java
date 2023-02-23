package com.digital.shop.controller.response;

import com.digital.shop.entity.MenuEntity;

import java.util.List;

public class ShopResponse {
    private Long id;

    private String name;

    private String location;

    private List<MenuResponse> menus;

    public ShopResponse() {
    }

    public ShopResponse(Long id, String name, String location, List<MenuResponse> menus) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.menus = menus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<MenuResponse> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuResponse> menus) {
        this.menus = menus;
    }
}
