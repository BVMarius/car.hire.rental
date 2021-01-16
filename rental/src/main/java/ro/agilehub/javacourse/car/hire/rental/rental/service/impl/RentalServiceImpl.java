package ro.agilehub.javacourse.car.hire.rental.rental.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.agilehub.javacourse.car.hire.rental.api.model.RentalResponse;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.UserApi;
import ro.agilehub.javacourse.car.hire.rental.rental.entity.RentalEntity;
import ro.agilehub.javacourse.car.hire.rental.rental.service.definition.RentalService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {
    private final UserApi userApi;


    @Override
    public RentalEntity createRental(RentalEntity rentalEntity) {
        var UserResponse = userApi.getUser(rentalEntity.getConsumerId());
        return rentalEntity;
    }

    @Override
    public void deleteRental(int rentalId) {

    }

    @Override
    public RentalEntity getRentalById(int rentalId) {
        return null;
    }

    @Override
    public List<RentalResponse> listRental() {
        return null;
    }
}
