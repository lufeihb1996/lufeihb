package com.example.demo.blog;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = "*")
public class PostController {
    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public List<Post> all() {
        return service.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> one(@PathVariable Long id) {
        Post post = service.getById(id);
        return post != null ? ResponseEntity.ok(post) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Post create(@RequestBody Post post) {
        service.save(post);
        return post;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> update(@PathVariable Long id, @RequestBody Post post) {
        Post existing = service.getById(id);
        if (existing != null) {
            existing.setTitle(post.getTitle());
            existing.setContent(post.getContent());
            service.updateById(existing);
            return ResponseEntity.ok(existing);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.removeById(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
