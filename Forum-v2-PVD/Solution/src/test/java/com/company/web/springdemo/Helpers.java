//package com.company.web.springdemo;
//
//import com.company.web.springdemo.models.*;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class Helpers {
//
//    public static User createMockAdmin() {
//        User mockUser = createMockUser();
//        mockUser.setAdmin(true);
//        return mockUser;
//    }
//
//    public static User createMockUser() {
//        var mockUser = new User();
//        mockUser.setId(1);
//        mockUser.setUsername("MockUsername");
//        mockUser.setPassword("MockPassword");
//        mockUser.setLastName("MockLastName");
//        mockUser.setFirstName("MockFirstName");
//        mockUser.setEmail("mock@user.com");
//        return mockUser;
//    }
//
//    public static Post createMockPost() {
//        var mockBeer = new Post();
//        mockBeer.setId(1);
//        mockBeer.setTitle("MockPost");
//        mockBeer.setCreatedBy(createMockUser());
//        mockBeer.setCategory(createMockCategory());
//        return mockBeer;
//    }
//
//    public static Category createMockCategory() {
//        var mockCategory = new Category();
//        mockCategory.setId(1);
//        mockCategory.setName("MockCategory");
//        return mockCategory;
//    }
//
//
//    public static PostDto createBeerDto() {
//        PostDto dto = new PostDto();
//        dto.setCategoryId(1);
//        dto.setTitle("MockBeer");
//        dto.setContent("dsadadasdasdsadasdadasdasdsadasdasdasdsad");
//        return dto;
//    }
//
//    /**
//     * Accepts an object and returns the stringified object.
//     * Useful when you need to pass a body to a HTTP request.
//     */
//    public static String toJson(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//}
