package com.company.web.springdemo.helpers;

import com.company.web.springdemo.models.Post;
import com.company.web.springdemo.models.PostDto;
import com.company.web.springdemo.services.PostService;
import com.company.web.springdemo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    private final PostService postService;

    private final CategoryService categoryService;

    @Autowired
    public PostMapper(PostService postService, CategoryService categoryService) {
        this.postService = postService;
        this.categoryService = categoryService;
    }

    public Post fromDto(int id, PostDto dto) {
        Post post = fromDto(dto);
        post.setId(id);
        Post repositoryPost = postService.get(id);
        post.setCreatedBy(repositoryPost.getCreatedBy());
        return post;
    }

    public Post fromDto(PostDto dto) {
        Post post = new Post();
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setCategory(categoryService.get(dto.getCategoryId()));
        return post;
    }

    public PostDto toDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setCategoryId(post.getCategory().getId());
        return postDto;
    }

}
