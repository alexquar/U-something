package com.aquarrie.photoz;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class PhotozService {
        private Map <String, Photo> db = new HashMap<>() {{
        put("1", new Photo("1", "photo1.jpg"));
        put("2", new Photo("2", "photo2.jpg"));
        put("3", new Photo("3" ,"photo3.jpg"));
    }};

    public Photo get(String id) {
        return db.get(id);
    }
    public Photo remove(String id) {
        return db.remove(id);
    }
    public Collection<Photo> values() {
        return db.values();
    }

    void put(String id, Photo photo) {
        db.put(id, photo);
    }
}
