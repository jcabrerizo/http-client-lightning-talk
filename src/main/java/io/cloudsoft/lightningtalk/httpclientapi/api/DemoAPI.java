package io.cloudsoft.lightningtalk.httpclientapi.api;

import io.cloudsoft.lightningtalk.httpclientapi.api.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RequestMapping("/")
public interface DemoAPI {

    @GetMapping
    @ResponseBody
    List<User> list();

    @GetMapping("/{userId}")
    @ResponseBody
    ResponseEntity<Object> details(
            @PathVariable int userId);

    @PostMapping
    ResponseEntity create(
            @RequestBody User newUser) throws URISyntaxException;

    @PatchMapping
    ResponseEntity modify(
            @RequestBody User newUser);


}
