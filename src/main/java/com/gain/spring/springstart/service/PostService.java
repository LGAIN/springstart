package com.gain.spring.springstart.service;

import com.gain.spring.springstart.entity.PostEntity;
import com.gain.spring.springstart.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


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

    public Page<PostEntity> getPostsList(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    public PostEntity getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 글이 없습니다."));
    }

    @Transactional
    public void updatePost(Long id, PostEntity updatedPost) {
        PostEntity exisiting = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 글입니다."));

        exisiting.setTitle(updatedPost.getTitle());
        exisiting.setContent(updatedPost.getContent());
    }

    @Transactional
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
