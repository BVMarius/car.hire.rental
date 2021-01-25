package ro.agilehub.javacourse.car.hire.rental.client.core.error;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GlobalErrorDTO extends RuntimeException{

    private final String code;

    private final String message;

}
