package com.yunussemree.redisexample.cache;

import com.yunussemree.redisexample.CacheNames;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("!prod")
@RestController
@RequiredArgsConstructor
@RequestMapping("/cache")
public class CacheController {

    private final ICacheService cacheService;

    @DeleteMapping("/country-names")
    public Boolean evictCountryNamesCache() {
        cacheService.evictCacheValues(CacheNames.COUNTRY_NAMES);
        return true;
    }
}
