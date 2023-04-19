package com.example.advertiseboard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ProductCreateRequest {

    private String name;

    public ProductCreateRequest() { }

    public ProductCreateRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
