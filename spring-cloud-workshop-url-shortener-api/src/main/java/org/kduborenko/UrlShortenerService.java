package org.kduborenko;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Kiryl Dubarenka
 */
public interface UrlShortenerService {

    @RequestMapping(method = RequestMethod.GET, value = "/resolve/{shortId}")
    String resolve(@PathVariable("shortId") String shortId);

}
