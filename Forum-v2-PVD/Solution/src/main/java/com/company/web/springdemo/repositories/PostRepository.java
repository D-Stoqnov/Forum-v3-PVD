package com.company.web.springdemo.repositories;

import com.company.web.springdemo.models.Post;
import com.company.web.springdemo.models.FilterOptions;

import java.util.List;

public interface PostRepository {

    List<Post> get(FilterOptions filterOptions);

    Post get(int id);

    Post get(String title);

    void create(Post post);

    void update(Post post);

    void delete(int id);

}
