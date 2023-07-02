package com.medium.service;

import com.medium.repository.ICommentRepository;
import com.medium.repository.entity.Comment;
import com.medium.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends ServiceManager<Comment,Long> {
    private final ICommentRepository repository;
    public CommentService(ICommentRepository repository){
        super(repository);
        this.repository=repository;
    }
}
