package com.example.FirstWeb.service.api;

import com.example.FirstWeb.dto.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto> search(String finder);
}
