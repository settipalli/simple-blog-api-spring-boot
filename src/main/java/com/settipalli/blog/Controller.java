package com.settipalli.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class Controller {

    BlogRepository blogRepository;

    @Autowired
    public Controller(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @GetMapping("/blogs")
    public List<BlogItem> index() {
        return blogRepository.findAll();
    }

    @GetMapping("/blogs/{id}")
    public BlogItem show(@PathVariable String id) {
        int blogId = Integer.parseInt(id);
        BlogItem blog = blogRepository.findById(blogId).get();
        return blog;
    }

    @PostMapping("/blogs/search")
    public List<BlogItem> search(@RequestBody Map<String, String> body) {
        String searchTerm = body.getOrDefault("text", "");
        return blogRepository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
    }

    @PostMapping("/blogs")
    public BlogItem create(@RequestBody Map<String, String> body) {
        String title = body.get("title");
        String content = body.get("content");
        return blogRepository.save(new BlogItem(title, content));
    }

    @PutMapping("/blogs/{id}")
    public BlogItem update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int blogId = Integer.parseInt(id);
        BlogItem blog = blogRepository.findById(blogId).get();
        blog.setTitle(body.get("title"));
        blog.setContent(body.get("content"));
        return blogRepository.save(blog);
    }

    @DeleteMapping("blogs/{id}")
    public boolean delete(@PathVariable String id) {
        int blogId = Integer.parseInt(id);
        blogRepository.deleteById(blogId);
        return true;
    }
}
