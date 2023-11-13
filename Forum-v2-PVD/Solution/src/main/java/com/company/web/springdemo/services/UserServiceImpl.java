package com.company.web.springdemo.services;

import com.company.web.springdemo.exceptions.EntityDuplicateException;
import com.company.web.springdemo.exceptions.EntityNotFoundException;
import com.company.web.springdemo.models.Post;
import com.company.web.springdemo.models.User;
import com.company.web.springdemo.repositories.PostRepository;
import com.company.web.springdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PostRepository postRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository repository, PostRepository postRepository,BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.postRepository = postRepository;
       this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> get() {
        return repository.get();
    }

    @Override
    public User get(int id) {
        return repository.get(id);
    }

    @Override
    public User get(String username) {
        return repository.get(username);
    }

    @Override
    public void create(User user) {
        boolean duplicateExists = true;
        try {
            repository.get(user.getUsername());

        } catch (EntityNotFoundException e) {
            duplicateExists = false;
        }

        if (duplicateExists) {
            throw new EntityDuplicateException("User", "username", user.getUsername());
        }



       String encryptedPassword = passwordEncoder.encode(user.getPassword());
       user.setPassword(encryptedPassword);
        repository.create(user);
    }
}






