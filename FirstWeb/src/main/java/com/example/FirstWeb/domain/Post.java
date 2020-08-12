package com.example.FirstWeb.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String body;
    private String img;
}
