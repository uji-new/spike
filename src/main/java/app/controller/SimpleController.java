package app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.service.DataService;
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

    @Autowired
    protected DataService data;

    @GetMapping(path = "/load")
    public Object requestLoad() {
        return data.load();
    }

    @GetMapping(path = "/save")
    public Object requestSave(@RequestParam int value) {
        data.save(value);
        return Map.of();
    }
}