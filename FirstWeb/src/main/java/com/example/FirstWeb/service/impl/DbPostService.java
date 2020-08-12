package com.example.FirstWeb.service.impl;

import com.example.FirstWeb.domain.Post;
import com.example.FirstWeb.dto.PostDto;
import com.example.FirstWeb.jpa.PostRepository;
import com.example.FirstWeb.service.api.PostService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DbPostService implements PostService {

    public PostRepository postRepository;

    public DbPostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostDto> search (String finder) {
        List<Post> posts = finder != null && !finder.isEmpty() ?
                postRepository.findAllByTitleLike("%" + finder + "%")
                :
                postRepository.findAll();

        return posts.stream().map(post -> PostDto.builder()
                .title(post.getTitle())
                .body(post.getBody())
                .img(post.getImg())
                .build())
                .collect(Collectors.toList());
    }

//    @PostConstruct
//    public void setup() {
//        postRepository.saveAll(Arrays.asList(
//                Post.builder()
//                        .title("First title")
//                        .body("First body")
//                        .img("/img/Sushi.jpg")
//                        .build(),
//
//                Post.builder()
//                        .title("Second title")
//                        .body("Second body")
//                        .img("/img/Pizza.jpg")
//                        .build(),
//                Post.builder()
//                        .title("Third title")
//                        .body("Third body")
//                        .img("/img/Vine.jpg")
//                        .build())
//        );
//    }
}
