package org.kduborenko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Kiryl Dubarenka
 */
@Controller
@RequestMapping("/")
public class HomePage {

    private final UrlShortenerClient urlShortener;

    public HomePage(@Autowired UrlShortenerClient urlShortener) {
        this.urlShortener = urlShortener;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{shortId}")
    public String forward(@PathVariable String shortId) {
        return String.format("redirect:%s", urlShortener.resolve(shortId));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String createPage() {
        return "home/create";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String create(@RequestParam("url") String url, Model model) {
        String shortId = urlShortener.create(url);
        model.addAttribute("shortUrl", "/" + shortId);
        return "home/create";
    }
}
