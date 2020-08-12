package com.example.FirstWeb.service.impl;

import com.example.FirstWeb.dto.PostDto;
import com.example.FirstWeb.service.api.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemPostService implements PostService {

    private List<PostDto> posts = new ArrayList<>(Arrays.asList(
            PostDto.builder()
                    .title("First title")
                    .body("First body")
                    .img("/img/Sushi.jpg")
                    .build(),

            PostDto.builder()
                    .title("Second title")
                    .body("Second body")
                    .img("/img/Pizza.jpg")
                    .build(),
            PostDto.builder()
                    .title("Third title")
                    .body("Third body")
                    .img("/img/Vine.jpg")
                    .build())
    );

    @Override
    public List<PostDto> search(String finder) {
        return finder != null && !finder.isEmpty() ?
                posts.stream().filter(post ->
                post.getTitle().toLowerCase().matches(".*" + finder.toLowerCase() + ".*"))
                        .collect(Collectors.toList())
                :
                posts;
    }
}
