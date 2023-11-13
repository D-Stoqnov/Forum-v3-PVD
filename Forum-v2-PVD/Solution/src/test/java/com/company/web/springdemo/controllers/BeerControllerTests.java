//package com.company.web.springdemo.controllers;
//
//import com.company.web.springdemo.exceptions.EntityDuplicateException;
//import com.company.web.springdemo.exceptions.EntityNotFoundException;
//import com.company.web.springdemo.exceptions.AuthorizationException;
//import com.company.web.springdemo.helpers.AuthenticationHelper;
//import com.company.web.springdemo.helpers.PostMapper;
//import com.company.web.springdemo.models.Post;
//import com.company.web.springdemo.models.PostDto;
//import com.company.web.springdemo.models.User;
//import com.company.web.springdemo.services.PostService;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.web.server.ResponseStatusException;
//
//import static com.company.web.springdemo.Helpers.*;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class BeerControllerTests {
//
//    @MockBean
//    PostService mockService;
//
//    @MockBean
//    PostMapper mockBeerMapper;
//
//    @MockBean
//    AuthenticationHelper mockAuthenticationHelper;
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Test
//    public void getById_Should_ReturnStatusOk_When_BeerExists() throws Exception {
//        // Arrange
//        Post mockBeer = createMockBeer();
//
//        Mockito.when(mockService.get(Mockito.anyInt()))
//                .thenReturn(mockBeer);
//
//        // Act, Assert
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/beers/{id}", 1))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(mockPost.getName()));
//    }
//
//    @Test
//    public void getById_Should_ReturnStatusNotFound_When_BeerDoesntExist() throws Exception {
//        // Arrange
//        Mockito.when(mockService.get(Mockito.anyInt()))
//                .thenThrow(EntityNotFoundException.class);
//
//        // Act, Assert
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/beers/{id}", 1))
//                .andExpect(MockMvcResultMatchers.status().isNotFound());
//    }
//
//    @Test
//    public void create_Should_ReturnStatusOk_When_CorrectRequest() throws Exception {
//        // Arrange
//        User mockUser = createMockUser();
//
//        Mockito.when(mockAuthenticationHelper.tryGetUser(Mockito.any()))
//                .thenReturn(mockUser);
//
//        Post mockBeer = createMockPost();
//
//        Mockito.when(mockBeerMapper.fromDto(Mockito.any()))
//                .thenReturn(mockBeer);
//
//        // Act, Assert
//        String body = toJson(createBeerDto());
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/posts")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(body))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    public void create_Should_ReturnStatusUnauthorized_When_AuthorizationIsMissing() throws Exception {
//        // Arrange
//        Mockito.when(mockAuthenticationHelper.tryGetUser(Mockito.any()))
//                .thenThrow(new ResponseStatusException(HttpStatus.UNAUTHORIZED, null));
//
//        // Act, Assert
//        String body = toJson(createBeerDto());
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/posts")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(body))
//                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
//    }
//
//    @Test
//    public void create_Should_ReturnStatusBadRequest_When_BodyIsInvalid() throws Exception {
//        // Arrange
//        PostDto dto = createBeerDto();
//        dto.setName(null);
//
//        // Act, Assert
//        String body = toJson(dto);
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/posts")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(body))
//                .andExpect(MockMvcResultMatchers.status().isBadRequest());
//    }
//
//    @Test
//    public void create_Should_ReturnStatusNotFound_WhenStyleDoesntExist() throws Exception {
//        // Arrange
//        User mockUser = createMockUser();
//
//        Mockito.when(mockAuthenticationHelper.tryGetUser(Mockito.any()))
//                .thenReturn(mockUser);
//
//        Mockito.when(mockBeerMapper.fromDto(Mockito.any()))
//                .thenThrow(EntityNotFoundException.class);
//
//        // Act, Assert
//        String body = toJson(createBeerDto());
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/posts")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(body))
//                .andExpect(MockMvcResultMatchers.status().isNotFound());
//    }
//
//    @Test
//    public void create_Should_ReturnStatusConflict_WhenBeerWithSameNameExists() throws Exception {
//        // Arrange
//        User mockUser = createMockUser();
//        Post mockBeer = createMockPost();
//
//        Mockito.when(mockAuthenticationHelper.tryGetUser(Mockito.any()))
//                .thenReturn(mockUser);
//
//        Mockito.when(mockBeerMapper.fromDto(Mockito.any()))
//                .thenReturn(mockBeer);
//
//        Mockito.doThrow(EntityDuplicateException.class)
//                .when(mockService)
//                .create(mockBeer, mockUser);
//
//        // Act, Assert
//        String body = toJson(createBeerDto());
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/post")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(body))
//                .andExpect(MockMvcResultMatchers.status().isConflict());
//    }
//
//    @Test
//    public void update_Should_ReturnStatusOk_When_CorrectRequest() throws Exception {
//        // Arrange
//        User mockUser = createMockUser();
//
//        Mockito.when(mockAuthenticationHelper.tryGetUser(Mockito.any()))
//                .thenReturn(mockUser);
//
//        Post mockBeer = createMockPost();
//
//        Mockito.when(mockBeerMapper.fromDto(Mockito.anyInt(), Mockito.any()))
//                .thenReturn(mockBeer);
//
//        // Act, Assert
//        String body = toJson(createBeerDto());
//        mockMvc.perform(MockMvcRequestBuilders.put("/api/beers/{id}", 1)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(body))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    public void update_Should_ReturnStatusUnauthorized_When_AuthorizationIsMissing() throws Exception {
//        // Arrange
//        Mockito.when(mockAuthenticationHelper.tryGetUser(Mockito.any()))
//                .thenThrow(new ResponseStatusException(HttpStatus.UNAUTHORIZED, null));
//
//        // Act, Assert
//        String body = toJson(createBeerDto());
//        mockMvc.perform(MockMvcRequestBuilders.put("/api/beers/{id}", 1)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(body))
//                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
//    }
//
//    @Test
//    public void update_Should_ReturnStatusBadRequest_When_BodyIsInvalid() throws Exception {
//        // Arrange
//        PostDto dto = createBeerDto();
//        dto.setName(null);
//
//        // Act, Assert
//        String body = toJson(dto);
//        mockMvc.perform(MockMvcRequestBuilders.put("/api/beers/{id}", 1)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(body))
//                .andExpect(MockMvcResultMatchers.status().isBadRequest());
//    }
//
//    @Test
//    public void update_Should_ReturnStatusNotFound_When_BeerOrStyleDoesntExist() throws Exception {
//        // Arrange
//        User mockUser = createMockUser();
//
//        Mockito.when(mockAuthenticationHelper.tryGetUser(Mockito.any()))
//                .thenReturn(mockUser);
//
//        Mockito.when(mockBeerMapper.fromDto(Mockito.anyInt(), Mockito.any()))
//                .thenThrow(EntityNotFoundException.class);
//
//        // Act, Assert
//        String body = toJson(createBeerDto());
//        mockMvc.perform(MockMvcRequestBuilders.put("/api/beers/{id}", 1)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(body))
//                .andExpect(MockMvcResultMatchers.status().isNotFound());
//    }
//
//    @Test
//    public void update_Should_ReturnStatusConflict_When_BeerWithSameNameExists() throws Exception {
//        // Arrange
//        User mockUser = createMockUser();
//
//        Mockito.when(mockAuthenticationHelper.tryGetUser(Mockito.any()))
//                .thenReturn(mockUser);
//
//        Post mockBeer = createMockPost();
//
//        Mockito.when(mockBeerMapper.fromDto(Mockito.anyInt(), Mockito.any()))
//                .thenReturn(mockBeer);
//
//        Mockito.doThrow(EntityDuplicateException.class)
//                .when(mockService)
//                .update(mockBeer, mockUser);
//
//        // Act, Assert
//        String body = toJson(createBeerDto());
//        mockMvc.perform(MockMvcRequestBuilders.put("/api/beers/{id}", 1)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(body))
//                .andExpect(MockMvcResultMatchers.status().isConflict());
//    }
//
//    @Test
//    public void update_Should_ReturnStatusUnauthorized_When_UserIsNotAuthorizedToEdit() throws Exception {
//        // Arrange
//        User mockUser = createMockUser();
//
//        Mockito.when(mockAuthenticationHelper.tryGetUser(Mockito.any()))
//                .thenReturn(mockUser);
//
//        Post mockBeer = createMockBeer();
//
//        Mockito.when(mockBeerMapper.fromDto(Mockito.anyInt(), Mockito.any()))
//                .thenReturn(mockBeer);
//
//        Mockito.doThrow(AuthorizationException.class)
//                .when(mockService)
//                .update(mockBeer, mockUser);
//
//        // Act, Assert
//        String body = toJson(createBeerDto());
//        mockMvc.perform(MockMvcRequestBuilders.put("/api/beers/{id}", 1)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(body))
//                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
//    }
//
//    @Test
//    public void delete_Should_ReturnStatusOk_When_CorrectRequest() throws Exception {
//        // Arrange
//        User mockUser = createMockUser();
//
//        Mockito.when(mockAuthenticationHelper.tryGetUser(Mockito.any()))
//                .thenReturn(mockUser);
//
//        // Act, Assert
//        mockMvc.perform(MockMvcRequestBuilders.delete("/api/beers/{id}", 1))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    public void delete_Should_ReturnStatusUnauthorized_When_AuthorizationIsMissing() throws Exception {
//        // Arrange
//        Mockito.when(mockAuthenticationHelper.tryGetUser(Mockito.any()))
//                .thenThrow(new ResponseStatusException(HttpStatus.UNAUTHORIZED, null));
//
//        // Act, Assert
//        mockMvc.perform(MockMvcRequestBuilders.delete("/api/beers/{id}", 1))
//                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
//    }
//
//    @Test
//    public void delete_Should_ReturnStatusNotFound_When_BeerDoesNotExist() throws Exception {
//        // Arrange
//        User mockUser = createMockUser();
//
//        Mockito.when(mockAuthenticationHelper.tryGetUser(Mockito.any()))
//                .thenReturn(mockUser);
//
//        Mockito.doThrow(EntityNotFoundException.class)
//                .when(mockService)
//                .delete(1, mockUser);
//
//        // Act, Assert
//        mockMvc.perform(MockMvcRequestBuilders.delete("/api/beers/{id}", 1))
//                .andExpect(MockMvcResultMatchers.status().isNotFound());
//    }
//
//    @Test
//    public void delete_Should_ReturnStatusUnauthorized_When_UserIsNotAuthorizedToEdit() throws Exception {
//        // Arrange
//        User mockUser = createMockUser();
//
//        Mockito.when(mockAuthenticationHelper.tryGetUser(Mockito.any()))
//                .thenReturn(mockUser);
//
//        Mockito.doThrow(AuthorizationException.class)
//                .when(mockService)
//                .delete(1, mockUser);
//
//        // Act, Assert
//        mockMvc.perform(MockMvcRequestBuilders.delete("/api/beers/{id}", 1))
//                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
//    }
//
//}
