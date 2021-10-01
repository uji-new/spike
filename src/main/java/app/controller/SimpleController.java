package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import app.service.SimpleService;
import app.service.WeatherService;

@RestController
public class SimpleController {
    @Autowired
    protected SimpleService service;

    @GetMapping(path = "/url")
    public Object request() {
        return service.getData();
    }

    @Autowired
    protected WeatherService weather;

    @GetMapping(path = "/api")
    public Object requestApi() {
        return weather.getData();
    }
}