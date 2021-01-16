package ro.agilehub.javacourse.car.hire.rental.rental.controller.mapper;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.rental.api.model.CreateCarRequest;

@Mapper(componentModel = "spring")
public interface StatusEnumToString {


    default String map(CreateCarRequest.StatusEnum statusEnum) {

        return statusEnum.getValue();
    }
}
