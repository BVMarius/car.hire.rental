package ro.agilehub.javacourse.car.hire.rental.rental.service.definition;

import ro.agilehub.javacourse.car.hire.rental.api.model.RentalResponse;
import ro.agilehub.javacourse.car.hire.rental.rental.entity.RentalEntity;

import java.util.List;

public interface RentalService {

    RentalEntity createRental(RentalEntity rentalEntity);

    void deleteRental(int rentalId);

    RentalEntity getRentalById(int rentalId);

    List<RentalResponse> listRental();
}
