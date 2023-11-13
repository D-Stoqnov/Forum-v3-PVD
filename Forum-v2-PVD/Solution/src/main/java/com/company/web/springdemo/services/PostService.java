package com.company.web.springdemo.services;

import com.company.web.springdemo.models.Post;
import com.company.web.springdemo.models.FilterOptions;
import com.company.web.springdemo.models.User;

import java.util.List;

public interface PostService {

    List<Post> get(FilterOptions filterOptions);

    Post get(int id);

    void create(Post post, User user);

    void update(Post post, User user);

    void delete(int id, User user);



}
