package com.company.web.springdemo.services;

import com.company.web.springdemo.models.Category;
import com.company.web.springdemo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> get() {
        return repository.get();
    }

    @Override
    public Category get(int id) {
        return repository.get(id);
    }

}
