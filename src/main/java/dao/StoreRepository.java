package dao;

import exception.EntityNotFoundException;
import exception.InvalidEntityException;
import model.Store;

import java.util.List;

public interface StoreRepository {
    List<Store> findAll();
    Store findByName(String storeName) throws EntityNotFoundException;
    Store create(Store store) throws InvalidEntityException;
    Store deleteByName(String name) throws EntityNotFoundException;
    Store update(String name, Store store) throws EntityNotFoundException;
}
