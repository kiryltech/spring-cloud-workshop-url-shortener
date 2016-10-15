package org.kduborenko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kiryl Dubarenka
 */
@RestController
public class RedisUrlShortenerService implements UrlShortenerService {

    private final BoundHashOperations<String, String, String> shortIdOps;

    @Autowired
    public RedisUrlShortenerService(RedisTemplate<String, String> template) {
        shortIdOps = template.boundHashOps("short-id");
    }

    @Override
    public String resolve(@PathVariable("shortId") String shortId) {
        return shortIdOps.get(shortId);
    }

}
