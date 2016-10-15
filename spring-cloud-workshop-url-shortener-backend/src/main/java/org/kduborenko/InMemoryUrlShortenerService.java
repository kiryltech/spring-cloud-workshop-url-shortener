package org.kduborenko;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kiryl Dubarenka
 */
@RestController
public class InMemoryUrlShortenerService implements UrlShortenerService {

    private final Map<String, String> mapping = new HashMap<>();

    public InMemoryUrlShortenerService() {
        mapping.put("goog", "https://google.com/");
    }

    @Override
    public String resolve(String shortId) {
        return mapping.get(shortId);
    }
}
