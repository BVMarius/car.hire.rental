package ro.agilehub.javacourse.car.hire.rental.client.core.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.ErrorDTO;


@ControllerAdvice
public class ClientControllerAdvice {

    @ExceptionHandler(GlobalErrorDTO.class)
    public ResponseEntity<ErrorDTO> handleException(GlobalErrorDTO globalErrorDTO) {
        //impl
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCode(globalErrorDTO.getCode());
        errorDTO.setMessage(globalErrorDTO.getMessage());
        return new ResponseEntity<>(errorDTO,HttpStatus.NOT_FOUND);
    }
}
