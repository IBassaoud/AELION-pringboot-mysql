package org.myownstock.user.cities.Impl;

import org.apache.coyote.Response;
import org.myownstock.user.cities.City;
import org.myownstock.user.cities.CityService;
import org.myownstock.user.cities.ICity;
import org.myownstock.user.cities.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private ICity repository;
    @Override
    public City add(City city) {
        return repository.save(city);
    }

    /**
     * Designated method to upate a well known city
     * @param City city
     * @return ResponseEntity
     */
    @Override
    public ResponseEntity<?> update(City city) {
        return repository.findById(city.getId())
                .map(existingCity -> {
                    return ResponseEntity.ok(repository.save(city));
                })
                .orElseThrow( ()-> new ResourceNotFoundException("City not exist with the ID provided: " + city.getId()));
    }

    @Override
    public List<City> findAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<?> remove(Long id) {
        City existingCity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("City not exist with the ID provided: " + id));

        repository.delete(existingCity);
        return ResponseEntity.ok().build();
    }

}
