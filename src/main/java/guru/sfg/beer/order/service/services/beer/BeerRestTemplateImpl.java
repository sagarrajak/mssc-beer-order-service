package guru.sfg.beer.order.service.services.beer;

import sagar.springproject.models.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.UUID;

@Component
@ConfigurationProperties(prefix = "sfg.beer", ignoreUnknownFields = false)
public class BeerRestTemplateImpl implements BeerService {
    private RestTemplate restTemplate;

    private String beerServiceHost;

    private final String BEER_BY_ID = "/api/v1/beer/";
    private final String BEER_BY_UPC = "/api/v1/beer/beerUpc/";

    public void setBeerServiceHost(String beerServiceHost) {
        this.beerServiceHost = beerServiceHost;
    }

    public BeerRestTemplateImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Optional<BeerDto> getBeerById(UUID id) {
        return Optional.of(restTemplate.getForObject(beerServiceHost + BEER_BY_ID+id.toString(), BeerDto.class));
    }

    @Override
    public Optional<BeerDto> getBeerByUpc(String upc) {
        return Optional.of(restTemplate.getForObject(beerServiceHost + BEER_BY_UPC+upc, BeerDto.class));
    }
}
