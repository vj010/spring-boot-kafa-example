package com.urlanalytics.webservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/url")
public class UrlAccessController {

    @GetMapping(value = "getUrl/{shortUrl}")
    public Mono<String> getRealUrl(@PathVariable("shortUrl") String shortUrl) {
        return Mono.just(shortUrl);
    }

}
