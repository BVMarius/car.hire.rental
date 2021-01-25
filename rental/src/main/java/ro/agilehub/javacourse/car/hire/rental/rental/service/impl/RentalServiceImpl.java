package ro.agilehub.javacourse.car.hire.rental.rental.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.agilehub.javacourse.car.hire.rental.api.model.CarStatus;
import ro.agilehub.javacourse.car.hire.rental.api.model.RentalResponse;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.CarApi;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.UserApi;
import ro.agilehub.javacourse.car.hire.rental.rental.entity.RentalEntity;
import ro.agilehub.javacourse.car.hire.rental.rental.repository.RentalRepository;
import ro.agilehub.javacourse.car.hire.rental.rental.service.definition.RentalService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {
    private final UserApi userApi;
    private final CarApi carApi;
    private final RentalRepository rentalRepository;


    @Override
    public RentalEntity createRental(RentalEntity rentalEntity) {
        var userResponse = userApi.getUser(rentalEntity.getConsumerId());
        var carResponse = carApi.getCar(rentalEntity.getCarId());
        rentalEntity.setStatus(CarStatus.ACTIVE.name());
        return rentalRepository.save(rentalEntity);
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
