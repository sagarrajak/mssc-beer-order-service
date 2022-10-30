package guru.sfg.beer.order.service.web.mappers;

import guru.sfg.beer.order.service.domain.BeerOrderLine;
import guru.sfg.beer.order.service.services.beer.BeerService;
import sagar.springproject.models.BeerDto;
import sagar.springproject.models.BeerOrderLineDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public abstract class BeerOrderLineMapperDecorator implements BeerOrderLineMapper {
    @Autowired
    BeerService beerService;

    @Autowired
    BeerOrderLineMapper beerOrderLineMapper;

    @Override
    public BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line) {
        BeerOrderLineDto beerOrderLineDto = this.beerOrderLineMapper.beerOrderLineToDto(line);
        Optional<BeerDto> beerByUpc = beerService.getBeerByUpc(line.getUpc());
        beerByUpc.ifPresent(beerDto -> {
            beerOrderLineDto.setBeerName(beerDto.getBeerName());
            beerOrderLineDto.setPrice(beerDto.getPrice());
            beerOrderLineDto.setBeerStyle(beerDto.getBeerStyle());
            beerOrderLineDto.setVersion(beerDto.getVersion());
            beerOrderLineDto.setBeerId(beerDto.getId());
        });
        return beerOrderLineDto;
    }
}
