package org.myownstock.user.cities;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CityService {
    /**
     * Designated method to add a new city
     * @param City city
     * @return City
     */
    public City add(City city);
    public ResponseEntity<?> update(City city);
    public List<City> findAll();
    public ResponseEntity<?> remove(Long id);
}
