package ro.agilehub.javacourse.car.hire.rental.client.core.impl;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpClientErrorException;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.CarDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.CarApi;

import java.util.NoSuchElementException;

@FeignClient(name = "${car.name:car}", url = "${car.url:http://localhost:8080/api}")
public interface CarApiClient extends CarApi {

    String CORE = "core";

    @Override
    @CircuitBreaker(name = CORE, fallbackMethod = "coreFallback")
    @RateLimiter(name = CORE)
    @GetMapping(value = "/car/{id}")
    ResponseEntity<CarDTO> getCar(@PathVariable("id") Integer id);

    default ResponseEntity<CarDTO> coreFallback(Integer id, CallNotPermittedException exception) {
        throw new NoSuchElementException();
    }

    default ResponseEntity<CarDTO> coreFallback(Integer id, HttpClientErrorException.NotFound exception) {

        throw new RuntimeException();
    }


}
