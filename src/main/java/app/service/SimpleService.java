package app.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {
    public Object getData() {
        return Map.of("top", Map.of("left", -1, "right", 1));
    }
}
