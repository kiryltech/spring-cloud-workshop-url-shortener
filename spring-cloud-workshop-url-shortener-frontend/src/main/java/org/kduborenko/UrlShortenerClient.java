package org.kduborenko;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author Kiryl Dubarenka
 */
@FeignClient(name = "url-shortener-backend")
public interface UrlShortenerClient extends UrlShortenerService {
}
