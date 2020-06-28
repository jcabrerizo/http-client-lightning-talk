package io.cloudsoft.lightningtalk.httpclientapi.persistence;

import com.google.common.collect.ImmutableList;
import io.cloudsoft.lightningtalk.httpclientapi.api.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
@Slf4j
public class InMemoryStorage implements Storage<User, Integer> {

    private final Map<Integer, User> storage = new LinkedHashMap<>();
    private Integer codeCounter = 0;

    @Override
    public User save(User item) {
        item.setCode(++codeCounter);
        item.setCreationDate(new Date());
        storage.put(item.getCode(), item);
        log.info("Saved {}. Total: {}",item, storage.size());
        return item;
    }

    @Override
    public User read(Integer id) {
        if (storage.containsKey(id)){
            return storage.get(id);
        } else {
            throw new UserNotFoundException(id);
        }
    }

    @Override
    public void update(User item) {
        if (storage.containsKey(item.getCode())) {
            storage.put(item.getCode(), item);
            log.debug("Updated {}. Total: {}",item, storage.size());
        } else {
            throw new UserNotFoundException(item.getCode());
        }
    }

    @Override
    public void delete(Integer id) {
        if (storage.containsKey(id)){
            storage.remove(id);
            log.debug("Deleted code {}. Total: {}",id, storage.size());
        } else {
            throw new UserNotFoundException(id);
        }
    }

    @Override
    public List<User> listAll() {
        return ImmutableList.copyOf(storage.values());
    }
}
