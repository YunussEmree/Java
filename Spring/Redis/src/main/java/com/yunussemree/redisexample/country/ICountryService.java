package com.yunussemree.redisexample.country;

import java.util.List;

public interface ICountryService {
    List<Country> getAllCountries();
    List<String> getAllCountryNames();
    List<Country> insertCountries(List<Country> countries);

}
