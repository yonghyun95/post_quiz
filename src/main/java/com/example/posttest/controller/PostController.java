package com.example.posttest.controller;

import com.example.posttest.dto.PostRequestDto;
import com.example.posttest.dto.PostResponseDto;
import com.example.posttest.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 게시글 생성
    @PostMapping("/api/post")
    public PostResponseDto createPost(@RequestBody PostRequestDto postRequestDto) {
        return postService.createPost(postRequestDto);
    }

    // 게시글 전체 리스트 리턴
    @GetMapping("/api/post")
    public List<PostResponseDto> getPostList() {
        return postService.findAllPost();
    }
}