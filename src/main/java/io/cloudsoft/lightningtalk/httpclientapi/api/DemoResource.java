package io.cloudsoft.lightningtalk.httpclientapi.api;

import io.cloudsoft.lightningtalk.httpclientapi.api.model.User;
import io.cloudsoft.lightningtalk.httpclientapi.persistence.Storage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;

@RestController
public class DemoResource implements DemoAPI {

    private final Storage<User, Integer> storage;

    DemoResource(Storage<User, Integer> storage) {
        this.storage = storage;
    }

    @Override
    public List<User> list() {
        return storage.listAll();
    }

    @Override
    public ResponseEntity details(int userId) {
        User user = storage.read(userId);
        return ResponseEntity.ok().body(user);
    }

    @Override
    public ResponseEntity create(User newUser) throws URISyntaxException {
        User user = storage.save(newUser);
        return ResponseEntity.ok().body(user);
    }

    @Override
    public ResponseEntity modify(User newUser) {
        storage.update(newUser);
        return ResponseEntity.ok().build();
    }
}
