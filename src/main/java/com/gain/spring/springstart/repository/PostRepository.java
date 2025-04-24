package com.gain.spring.springstart.repository;

import com.gain.spring.springstart.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    Page<PostEntity> findByWriter(String writer, Pageable pageable); // 작성자로 검색

}
