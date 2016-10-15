package org.kduborenko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Kiryl Dubarenka
 */
@Controller
public class HomePage {

    private final UrlShortenerClient urlShortener;

    public HomePage(@Autowired UrlShortenerClient urlShortener) {
        this.urlShortener = urlShortener;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{shortId}")
    public String forward(@PathVariable String shortId) {
        return String.format("redirect:%s", urlShortener.resolve(shortId));
    }
}
