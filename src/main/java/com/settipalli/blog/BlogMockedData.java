package com.settipalli.blog;

import java.util.ArrayList;
import java.util.List;

public enum BlogMockedData {
    INSTANCE;

    private List<BlogItem> blogs;

    BlogMockedData() {
        blogs = new ArrayList<>();
        blogs.add(new BlogItem(1, "Introducing Sign In with Apple",
                "Sign In with Apple is the fast, easy way for people to sign in to apps using the Apple IDs" +
                        "they already have. Learn how easy it is to add a Sign In with Apple button to your app or" +
                        "website to acquire new customers and benefit from the built-in security, antifraud, and" +
                        "privacy that Sign In with Apple provides."
        ));
        blogs.add(new BlogItem(2, "Stop ads in your network",
                "Install and configure Pi-Hole. Here's why it's so cool. If you disable the DHCP server on" +
                        "your router, and let the Pi-Hole become your primary DHCP server, you get automatic DNS" +
                        "based blocking of ads for every single device on your network. It's kind of scary how" +
                        "powerful DNS can be, isn't it?"));
        blogs.add(new BlogItem(3, "Cloud is just someone else's computer",
                "That's $2,044 for three years of hosting. How can we do on Digital Ocean? Per their current" +
                        "pricing page: $160 × 12 × 3 = $5,760. As you can see, you pay almost three times as much for" +
                        "a cloud server. If you just need to spin up a quick server or two for testing and" +
                        "experimentation, there's absolutely no way you need to go to the trouble and up-front cost" +
                        "of building and then racking colocated mini-pcs."));
    }

    public List<BlogItem> returnAllBlogs() {
        return blogs;
    }

    public BlogItem getBlogById(int id) {
        for (BlogItem blog : blogs) {
            if (blog.getId() == id) return blog;
        }
        return null;
    }

    public List<BlogItem> searchBlogByText(String searchKey) {
        List<BlogItem> searchedBlogs = new ArrayList<>();
        for (BlogItem b : blogs) {
            if (b.getTitle().toLowerCase().contains(searchKey) ||
                    b.getContent().toLowerCase().contains(searchKey)) {
                searchedBlogs.add(b);
            }
        }
        return searchedBlogs;
    }

    public BlogItem createBlog(String title, String content) {
        int blogId = blogs.size() + 1;
        BlogItem newBlog = new BlogItem(blogId, title, content);
        blogs.add(newBlog);
        return newBlog;
    }

    public BlogItem updateBlog(int id, String title, String content) {
        for (BlogItem blog : blogs) {
            if (blog.getId() == id) {
                int blogIndex = blogs.indexOf(blog);
                blog.setTitle(title);
                blog.setContent(content);
                blogs.set(blogIndex, blog);
                return blog;
            }
        }
        return null;
    }

    public boolean deleteBlog(int id) {
        int blogIndex = -1;
        for (BlogItem blog : blogs) {
            if (blog.getId() == id) {
                blogIndex = blogs.indexOf(blog);
                continue;
            }
        }
        if (blogIndex > -1) {
            blogs.remove(blogIndex);
        }
        return true;
    }
}
