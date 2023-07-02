package com.medium.service;

import com.medium.repository.IPostRepository;
import com.medium.repository.entity.Post;
import com.medium.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class PostService extends ServiceManager<Post,Long> {
    private final IPostRepository repository;
    public PostService(IPostRepository repository) {
        super(repository);
        this.repository=repository;
    }

}
