package com.gain.spring.springstart.service;

import com.gain.spring.springstart.entity.PostEntity;
import com.gain.spring.springstart.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    // 생성자
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void savePost(PostEntity post) {
        postRepository.save(post);
    }

    public List<PostEntity> getAllPost() {
        return postRepository.findAll();
    }

}
