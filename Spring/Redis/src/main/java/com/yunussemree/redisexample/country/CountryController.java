package com.yunussemree.redisexample.country;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/countries")
public class CountryController {

    private final ICountryService countryService;

    @GetMapping
    public List<Country> getAllCountries(){
        return countryService.getAllCountries();
    }

    @PostMapping
    public ResponseEntity<CountryDTO> insertCountry(@RequestBody CountryDTO countryDto){
        Country newCountry = new Country(countryDto.getName(),countryDto.getCapital());
        Country country = countryService.insertCountries(List.of(newCountry)).get(0);

        return ResponseEntity.ok(countryDto);
    }

    @GetMapping()
    public List<String> getAllCountryNames(){
        return countryService.getAllCountryNames();
    }

    @PostMapping()
    public List<Country> insertCountries(@RequestBody List<Country> countries){
        return countryService.insertCountries(countries);
    }

}
