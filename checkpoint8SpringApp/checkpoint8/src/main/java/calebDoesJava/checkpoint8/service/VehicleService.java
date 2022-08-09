package calebDoesJava.checkpoint8.service;

import calebDoesJava.checkpoint8.domain.Vehicle;
import calebDoesJava.checkpoint8.repository.VehicleRepository;
import calebDoesJava.checkpoint8.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final Utils utils;

    public List<Vehicle> findByAutomaker(String automakerName) {
        return vehicleRepository.findByAutomakerName(automakerName);
    }

    public Page<Vehicle> findAll(Pageable pageable) {
        return vehicleRepository.findAll(pageable);
    }


    public List<Vehicle> findByModel(String model) {
        return vehicleRepository.findByModel(model);
    }

    @Transactional
    public void replaceVehicle(Vehicle vehicle) {
        boolean vehicleIsInDatabase = !vehicleRepository.findById(vehicle.getId()).isEmpty();
        Optional<Vehicle> vehicleToDelete = vehicleRepository.findById(vehicle.getId());
        if(vehicleIsInDatabase && vehicleToDelete.isPresent()) {
            vehicleRepository.delete(vehicleToDelete.get());
            vehicleRepository.save(vehicle);
        }
    }

    @Transactional
    public Vehicle saveToDatabase(Vehicle newVehicle) {
        return vehicleRepository.save(newVehicle);
    }

    @Transactional
    public void deleteVehicle(int id) {
        vehicleRepository.delete(utils.findVehicleOrThrowNotFound(id, vehicleRepository));
    }
}
