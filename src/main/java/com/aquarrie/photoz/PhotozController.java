package com.aquarrie.photoz;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PhotozController {
    private Map <String, Photo> db = new HashMap<>() {{
        put("1", new Photo("1", "photo1.jpg"));
        put("2", new Photo("2", "photo2.jpg"));
        put("3", new Photo("3" ,"photo3.jpg"));
    }};
    @GetMapping("/")
    public String hello() {
        return "Hello, World!";
    }
    @GetMapping("/photoz")
        public Collection<Photo> getPhotos() {
            return db.values();
        }
     @GetMapping("/photoz/{id}")
        public Photo getPhoto(@PathVariable String id) {
            Photo current = db.get(id);
            if (current == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
            return current;
        }
     @DeleteMapping("/photoz/{id}")
        public void deletePhoto(@PathVariable String id) {
            Photo current = db.remove(id);
            if (current == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        }
}
