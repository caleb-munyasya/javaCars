package calebDoesJava.checkpoint8.utils;

import calebDoesJava.checkpoint8.domain.Vehicle;
import calebDoesJava.checkpoint8.exception.ResourceNotFoundException;
import calebDoesJava.checkpoint8.repository.VehicleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class Utils {
    public Vehicle findVehicleOrThrowNotFound(int id, VehicleRepository vehicleRepository) {
        return vehicleRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle Not Found"));
    }
}
