package sagar.springproject.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto implements Serializable {
    private static final long serialVersionUID = 8097086126314990997L;
    private Integer version;
    private String beerName;
    private String beerStyle;
    private String upc;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal price;
    private Integer minOnHand;
    private UUID id;
}
