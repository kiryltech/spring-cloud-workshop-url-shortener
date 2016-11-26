package net.duborenko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Kiryl Dubarenka
 */
@RestController
public class RedisUrlShortenerService implements UrlShortenerService {

    private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private final BoundHashOperations<String, String, String> shortIdOps;

    @Autowired
    public RedisUrlShortenerService(RedisTemplate<String, String> template) {
        shortIdOps = template.boundHashOps("short-id");
    }

    @Override
    public String resolve(@PathVariable("shortId") String shortId) {
        return shortIdOps.get(shortId);
    }

    @Override
    public String create(@RequestParam("url") String url) {
        String shortId = generateShortId();
        shortIdOps.put(shortId, url);
        return shortId;
    }

    private String generateShortId() {
        Random random = new Random();
        return IntStream.range(0, 7)
                .mapToObj(i -> String.valueOf(CHARS.charAt(random.nextInt(CHARS.length()))))
                .collect(Collectors.joining(""));
    }

}
