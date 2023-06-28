package ra.service;

import ra.model.Catalog;

import java.util.List;

public class CatalogService implements IService<Catalog, Integer> {
    private List<Catalog> catalogs;

    public List<Catalog> getCatalogs() {
        return catalogs;
    }

    @Override
    public List<Catalog> getAll() {
        return null;
    }

    @Override
    public void save(Catalog catalog) {

    }

    @Override
    public void findById(Integer integer) {

    }

    @Override
    public void delete(Integer integer) {

    }
}
