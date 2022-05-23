package dao.impl;

import dao.StoreRepository;
import exception.EntityNotFoundException;
import exception.InvalidEntityException;
import model.Store;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.*;

public class StoreRepositoryJDBC implements StoreRepository {
    private final Map<String, Store> stores = new HashMap<>();
    private final Connection connection;

    public StoreRepositoryJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Store> findAll() {
        return new ArrayList<>(stores.values());
    }

    @Override
    public Store findByName(String storeName) throws EntityNotFoundException {
        Store store = stores.get(storeName);
        if (store != null) {
            return store;
        }
        throw new EntityNotFoundException(format("Store with NAME:'%s' does not exists", storeName));
    }

    @Override
    public Store create(Store store) throws InvalidEntityException {
        Store byName = stores.get(store.getName());
        if (byName == null) {
            stores.put(store.getName(), store);
            return store;
        }
        throw new InvalidEntityException(String.format("Store with NAME:'%s' already exist", store.getName()));
    }

    @Override
    public Store deleteByName(String name) throws EntityNotFoundException {
        findByName(name);
        return stores.remove(name);
    }

    @Override
    public Store update(String name, Store store) throws EntityNotFoundException {
        Store byName = findByName(name);
        String storeName = store.getName();
        String description = store.getDescription();
        String address = store.getAddress();
        String picture = store.getPicture();
        if (storeName != null) {
            byName.setName(storeName);
        }
        if (description != null) {
            byName.setDescription(description);
        }
        if (address != null) {
            byName.setAddress(address);
        }
        if (picture != null) {
            byName.setPicture(picture);
        }
        return byName;
    }
}
