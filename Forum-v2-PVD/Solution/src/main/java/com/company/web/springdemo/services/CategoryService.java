package com.company.web.springdemo.services;

import com.company.web.springdemo.models.Category;

import java.util.List;

public interface CategoryService {

    List<Category> get();

    Category get(int id);

}
