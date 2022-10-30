package guru.sfg.beer.order.service.services.beer;

import sagar.springproject.models.BeerDto;

import java.util.Optional;
import java.util.UUID;

public interface BeerService {
    Optional<BeerDto> getBeerById(UUID id);

    Optional<BeerDto> getBeerByUpc(String upc);
}
