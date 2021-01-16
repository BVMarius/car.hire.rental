package ro.agilehub.javacourse.car.hire.rental.rental.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ro.agilehub.javacourse.car.hire.rental.api.model.CreateRentalRequest;
import ro.agilehub.javacourse.car.hire.rental.api.model.SuccessResponse;
import ro.agilehub.javacourse.car.hire.rental.api.specification.RentalApi;
import ro.agilehub.javacourse.car.hire.rental.rental.controller.mapper.RentalMapper;
import ro.agilehub.javacourse.car.hire.rental.rental.entity.RentalEntity;
import ro.agilehub.javacourse.car.hire.rental.rental.service.definition.RentalService;


@RestController
@RequiredArgsConstructor
public class RentalController implements RentalApi {

    private final RentalService rentalService;
    private final RentalMapper rentalMapper;

    @Override
    public ResponseEntity<SuccessResponse> createRental(CreateRentalRequest createRentalRequest) {

        RentalEntity rentalEntity =rentalService.createRental(rentalMapper.mapRequestToEntity(createRentalRequest));
        return new ResponseEntity<>(rentalMapper.carEntityToResponse(rentalEntity), HttpStatus.OK);
    }
}
