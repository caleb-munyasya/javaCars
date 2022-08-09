package calebDoesJava.checkpoint8.repository;

import calebDoesJava.checkpoint8.domain.Vehicle;
import calebDoesJava.checkpoint8.util.VehicleCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
//@SpringBootTest
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase
@DisplayName("Unit Tests")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class VehicleRepositoryTest {

    @Autowired
    private VehicleRepository vehicleRepository;
    private VehicleCreator vehicleCreator;

    @Test
    public void save_PersistVehicle_WhenSuccessfulTest(){
        Vehicle vehicle = vehicleCreator.createVehicle();
        Vehicle savedVehicle = this.vehicleRepository.save(vehicle);
        Assertions.assertThat(savedVehicle.getId()).isNotNull();
        Assertions.assertThat(savedVehicle.getColor()).isNotNull();
        Assertions.assertThat(savedVehicle.getYear()).isNotNull();
        Assertions.assertThat(savedVehicle.getAutomaker().getAutomakerID()).isNotNull();
        Assertions.assertThat(savedVehicle.getAutomaker().getName()).isNotNull();
        Assertions.assertThat(savedVehicle.getVehicleSort().getVehicleSortID()).isNotNull();
        Assertions.assertThat(savedVehicle.getVehicleSort().getVehicleSort()).isNotNull();
        Assertions.assertThat(savedVehicle.getModified()).isNotNull();
        Assertions.assertThat(savedVehicle.getModel()).isNotNull();
    }

    @Test
    public void update_UpdateVehicle_WhenSuccessful(){
        Vehicle vehicle = vehicleCreator.createVehicle();
        Vehicle savedVehicle = this.vehicleRepository.save(vehicle);
        savedVehicle.setModel("F430");
        Vehicle updatedVehicle = this.vehicleRepository.save(savedVehicle);
        Assertions.assertThat(savedVehicle.getModel().equals(updatedVehicle.getModel()));
    }

    @Test
    public void delete_RemoveVehicle_WhenSuccessful(){
        Vehicle vehicle = vehicleCreator.createVehicle();
        Vehicle savedVehicle = this.vehicleRepository.save(vehicle);
        this.vehicleRepository.delete(vehicle);

        Optional<Vehicle> optionalVehicle = this.vehicleRepository.findById(savedVehicle.getId());
        Assertions.assertThat(optionalVehicle.isEmpty()).isTrue();
    }

    @Test
    public void findByModel_PersistVehicle_WhenSuccessful(){
        Vehicle vehicle = vehicleCreator.createVehicle();
        Vehicle savedVehicle = this.vehicleRepository.save(vehicle);
        Assertions.assertThat(vehicleRepository.findByModel(savedVehicle.getModel()).equals(vehicle.getModel()));
    }
    @Test
    public void findByAutomakerName_PersistVehicle_WhenSuccessful(){
        Vehicle vehicle = vehicleCreator.createVehicle();
        Vehicle savedVehicle = this.vehicleRepository.save(vehicle);
        Assertions.assertThat(vehicleRepository.findByAutomakerName(savedVehicle.getAutomaker().getName()).contains(savedVehicle));
    }
}