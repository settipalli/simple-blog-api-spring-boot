package com.settipalli.blog;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blog")
public class BlogItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;

    public BlogItem(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
