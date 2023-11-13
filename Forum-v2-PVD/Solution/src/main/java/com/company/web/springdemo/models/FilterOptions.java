package com.company.web.springdemo.models;

import java.util.Optional;

public class FilterOptions {

    private Optional<String> title;
    private Optional<String> content;

    private Optional<Integer> categoryId;
    private Optional<String> sortBy;
    private Optional<String> sortOrder;

    public FilterOptions() {
        this(null,  null, null, null, null);
    }

    public FilterOptions(
            String title,
            String content,

            Integer categoryId,
            String sortBy,
            String sortOrder) {
        this.title = Optional.ofNullable(title);
        this.content = Optional.ofNullable(content);
        this.categoryId = Optional.ofNullable(categoryId);
        this.sortBy = Optional.ofNullable(sortBy);
        this.sortOrder = Optional.ofNullable(sortOrder);
    }

    public Optional<String> getName() {
        return title;
    }

    public Optional<String> getContent() {
        return content;
    }



    public Optional<Integer> getCategoryId() {
        return categoryId;
    }

    public Optional<String> getSortBy() {
        return sortBy;
    }

    public Optional<String> getSortOrder() {
        return sortOrder;
    }

}
