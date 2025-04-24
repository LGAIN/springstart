package com.gain.spring.springstart.controller;

import com.gain.spring.springstart.entity.PostEntity;
import com.gain.spring.springstart.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // JSON 응답
@RequestMapping("/api/posts") // POST 요청 허용
@RequiredArgsConstructor //
public class PostApiController {

    public final PostService postService;

    @GetMapping
    public List<PostEntity> getAllPosts() {
        return postService.getAllPosts(); // JSON 형식으로 변환
    }

    @PostMapping
    public ResponseEntity<PostEntity> createPost (@RequestBody PostEntity post) {
        PostEntity savedPost = postService.savePost(post);
        return ResponseEntity.ok(savedPost);
    }

    @GetMapping("{id}")
    public PostEntity getPostById (@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostEntity> updatePost (@PathVariable Long id, @RequestBody PostEntity updatedPost) {
        postService.updatePost(id, updatedPost);
        return ResponseEntity.ok(updatedPost);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost (@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.ok().build();
    }

}
