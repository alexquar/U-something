package com.aquarrie.photoz;

import java.util.Collection;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

@RestController
public class PhotozController {
    private final PhotozService photozService;
    public PhotozController(PhotozService photozService) {
        this.photozService = photozService;
    }
    @GetMapping("/")
    public String hello() {
        return "Hello, World!";
    }
    @GetMapping("/photoz")
        public Collection<Photo> getPhotos() {
            return photozService.values();
        }
     @GetMapping("/photoz/{id}")
        public Photo getPhoto(@PathVariable String id) {
            Photo current = photozService.get(id);
            if (current == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
            return current;
        }
     @DeleteMapping("/photoz/{id}")
        public void deletePhoto(@PathVariable String id) {
            Photo current = photozService.remove(id);
            if (current == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        }
     @PostMapping("/photoz/")
        public Photo create(@RequestBody @Valid Photo photo) {
           photo.setId(UUID.randomUUID().toString());
           photozService.put(photo.getId(), photo);
           return photo;
        }
    @PatchMapping("/photoz/{id}")
        public Photo update(@PathVariable String id, @RequestBody @Valid Photo photo) {
            Photo current = photozService.get(id);
            if (current == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
            current.setFileName(photo.getFileName());
            return current;
        }
}
