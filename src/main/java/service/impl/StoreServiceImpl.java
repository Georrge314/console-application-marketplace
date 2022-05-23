package service.impl;

import dao.StoreRepository;
import exception.EntityNotFoundException;
import exception.InvalidEntityException;
import model.Store;
import model.service.StoreServiceModel;
import service.StoreService;
import util.ObjectMapper;

import java.util.List;

import static util.ObjectMapper.*;

public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public List<Store> getAll() {
        return storeRepository.findAll();
    }

    @Override
    public Store getByName(String storeName) throws EntityNotFoundException {
        return storeRepository.findByName(storeName);
    }

    @Override
    public Store create(StoreServiceModel model) throws InvalidEntityException {
        Store store = MODEL_MAPPER.map(model, Store.class);
        return storeRepository.create(store);
    }

    @Override
    public Store deleteByName(String name) throws EntityNotFoundException {
        return storeRepository.deleteByName(name);
    }

    @Override
    public Store update(String name, StoreServiceModel model) throws EntityNotFoundException {
        Store store = MODEL_MAPPER.map(model, Store.class);
        return storeRepository.update(name, store);
    }
}
