package com.company.web.springdemo.repositories;

import com.company.web.springdemo.models.Category;

import java.util.List;

public interface CategoryRepository {

    List<Category> get();

    Category get(int id);

}
