package com.example.auilaboratory.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<Entity, Key> {
    Optional<Entity> find(Key pk);

    List<Entity> findAllObjects();

    void save(Entity e);

    void delete(Entity e);
}
