package com.settipalli.blog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<BlogItem, Integer> {

    List<BlogItem> findByTitleContainingOrContentContaining(String text, String content);
}
