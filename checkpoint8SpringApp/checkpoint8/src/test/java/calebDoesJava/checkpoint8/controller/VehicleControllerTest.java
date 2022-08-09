package calebDoesJava.checkpoint8.controller;

import calebDoesJava.checkpoint8.domain.Vehicle;
import calebDoesJava.checkpoint8.service.VehicleService;
import calebDoesJava.checkpoint8.util.VehicleCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.nio.charset.StandardCharsets;
import java.util.List;

@ExtendWith(SpringExtension.class)
class VehicleControllerTest {

    @InjectMocks
    private VehicleController vehicleController;

    @Mock
    private VehicleService vehicleServiceMock;

    @BeforeEach
    public void setUp(){
        PageImpl<Vehicle> vehiclePage = new PageImpl<>(List.of(VehicleCreator.createVehicle()));
        BDDMockito.when(vehicleServiceMock.findAll(ArgumentMatchers.any()))
                .thenReturn(vehiclePage);
        List<Vehicle> vehicleList = (List.of(VehicleCreator.createVehicle()));
        BDDMockito.when(vehicleServiceMock.findByModel(ArgumentMatchers.any()))
                .thenReturn(vehicleList);
        List<Vehicle> vehicleList2 = (List.of(VehicleCreator.createVehicle()));
        BDDMockito.when(vehicleServiceMock.findByAutomaker(ArgumentMatchers.any()))
                .thenReturn(vehicleList);
        BDDMockito.when(vehicleServiceMock.saveToDatabase(ArgumentMatchers.any()))
                .thenReturn(VehicleCreator.createVehicle());
        BDDMockito.doNothing().when(vehicleServiceMock).deleteVehicle(ArgumentMatchers.anyInt());
    }

    @Test
    void findAll_generateReportOfAllVehicles_WhenSuccessful() {
        String expectedName = VehicleCreator.createVehicle().getModel();
        Page<Vehicle> vehiclePage = vehicleController.generateReportOfAllVehicles(null).getBody();

        Assertions.assertThat(vehiclePage).isNotNull();
        Assertions.assertThat(vehiclePage.toList()).isNotEmpty();
        Assertions.assertThat(vehiclePage.toList().get(0).getModel()).isEqualTo(expectedName);

    }

    @Test
    void findByModel_ReturnVehicleByModel_WhenSuccessful() {
        String expectedName = VehicleCreator.createVehicle().getModel();
        ResponseEntity<List<Vehicle>> vehicle = vehicleController.searchByModel(expectedName);

        Assertions.assertThat(vehicle.getBody().get(0).getModel()).isEqualTo(expectedName);


    }

    @Test
    void searchByAutomaker_ReturnsAVehicle_WhenSuccessful() {
        String expectedName = VehicleCreator.createVehicle().getAutomaker().getName();
        ResponseEntity<List<Vehicle>> vehicle = vehicleController.searchByModel(expectedName);

        Assertions.assertThat(vehicle.getBody().get(0).getAutomaker().getName().equals(expectedName));
    }

    @Test
    void save_addNewVehicle_WhenSuccesssful() {
        Integer expectedID = VehicleCreator.createVehicle().getId();

        Vehicle vehicleToBeSaved = VehicleCreator.createVehicle();
        Vehicle vehicle = vehicleController.addNewVehicle(vehicleToBeSaved).getBody();
        Assertions.assertThat(vehicle.getId()).isEqualTo(expectedID);

    }

    @Test
    void update_saveUpdatedVehicle_WhenSuccessful() {
        Vehicle validUpdatedAnime = VehicleCreator.createUpdatedVehicle();

        String expectModel = validUpdatedAnime.getModel();

        Vehicle vehicle = vehicleController.addNewVehicle(VehicleCreator.createVehicle()).getBody();

        Assertions.assertThat(vehicle).isNotNull();
        Assertions.assertThat(vehicle.getId()).isNotNull();
        Assertions.assertThat(vehicle.getModel()).isEqualTo(expectModel);
    }

    @Test
    void deleteVehicleById_DetletesVehicleByID_WhenSuccessful() {
        ResponseEntity<Void> responseEntity = vehicleController.deleteVehicleById(1);

        Assertions.assertThat(responseEntity).isNotNull();
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        Assertions.assertThat(responseEntity.getBody()).isNull();
    }
}