package com.example.posttest.service;

import com.example.posttest.dto.PostRequestDto;
import com.example.posttest.dto.PostResponseDto;
import com.example.posttest.entity.Post;
import com.example.posttest.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public PostResponseDto createPost(PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto);   // 이 생성자를 만들 때, postRequestDto 안에 있는 걸 가져가겠다. -> 객체 부분에 있는 생성자를 postRequestDto로 변환!!
        postRepository.save(post);  // postRepository 에 저장한다.( postRequestDto 값을 받은 post를 저장한다.)
        PostResponseDto postResponseDto = new PostResponseDto(post);    // 반환 타입에 맞게 객체를 생성 -> 값이 들어있는 객체를 PostResponseDto 안에 넣는다.
        return postResponseDto; // postResponseDto를 반환한다.
    }

    @Transactional
    public List<PostResponseDto> findAllPost() {
        List<PostResponseDto> postResponseDtoList = new ArrayList<>(); // List 형식의 <PostResponseDto>
        List<Post> postList = postRepository.findAll(); // 전체 조회 하는 것
        for (Post post : postList) {    // post를 postList만큼 반복하겠다.
            postResponseDtoList.add(new PostResponseDto(post)); // add() ->
        }
        return postResponseDtoList;
    }
}