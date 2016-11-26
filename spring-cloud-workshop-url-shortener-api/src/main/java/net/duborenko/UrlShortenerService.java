package net.duborenko;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Kiryl Dubarenka
 */
public interface UrlShortenerService {

    @RequestMapping(method = RequestMethod.GET, value = "/resolve/{shortId}")
    String resolve(@PathVariable("shortId") String shortId);

    @RequestMapping(method = RequestMethod.PUT, value = "/create")
    String create(@RequestParam("url") String url);

}
