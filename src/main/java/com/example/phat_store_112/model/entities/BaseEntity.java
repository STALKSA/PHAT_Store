package com.example.phat_store_112.model.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public abstract class BaseEntity {
    private final Integer id;

    public BaseEntity() {
        this.id = -1;
    }

    public BaseEntity(Integer id) {
        this.id = id;
    }
}
