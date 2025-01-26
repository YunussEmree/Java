package com.yunussemree.redisexample.country;

import com.yunussemree.redisexample.CacheNames;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService implements ICountryService {

    private final ICountryRepository countryRepository;

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Cacheable(CacheNames.COUNTRY_NAMES)
    @Override
    public List<String> getAllCountryNames() {
        System.out.println("Veritabanına Erişildi! Cache Mekanizması Kullanılmadı.");
        return countryRepository.findAllCountryNames();
    }

    @Caching(
            evict = {
                    @CacheEvict(value = CacheNames.COUNTRY_NAMES, allEntries = true, condition = "#country.code != null")
            }
    )
    @Override
    public List<Country> insertCountries(List<Country> countries) {
        return countryRepository.saveAll(countries);
    }
}
