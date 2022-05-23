package service;

import exception.EntityNotFoundException;
import exception.InvalidEntityException;
import model.Store;
import model.service.StoreServiceModel;

import java.util.List;

public interface StoreService {
    List<Store> getAll();
    Store getByName(String storeName) throws EntityNotFoundException;
    Store create(StoreServiceModel model) throws InvalidEntityException;
    Store deleteByName(String name) throws EntityNotFoundException;
    Store update(String name, StoreServiceModel model) throws EntityNotFoundException;
}
