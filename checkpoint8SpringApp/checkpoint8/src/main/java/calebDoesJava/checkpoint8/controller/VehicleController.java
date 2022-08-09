package calebDoesJava.checkpoint8.controller;

import calebDoesJava.checkpoint8.domain.Vehicle;
import calebDoesJava.checkpoint8.service.VehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("vehicles")
@Slf4j
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<Page<Vehicle>> generateReportOfAllVehicles (Pageable pageable) {
        return ResponseEntity.ok(vehicleService.findAll(pageable));
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<Vehicle>> searchByModel (@RequestParam(value = "model") String model) {
        return ResponseEntity.ok(vehicleService.findByModel(model));
    }

    @GetMapping(path = "/automakers/find")
    public ResponseEntity<List<Vehicle>> searchByAutomaker (@RequestParam(value = "automakerName") String automakerName) {
        return ResponseEntity.ok(vehicleService.findByAutomaker(automakerName));
    }

    @PostMapping
    public ResponseEntity<Vehicle> addNewVehicle(@RequestBody @Valid Vehicle vehicle) {
        return ResponseEntity.ok(vehicleService.saveToDatabase(vehicle));
    }

    @PutMapping
    public ResponseEntity<Void> updateVehicle (@RequestBody Vehicle vehicle) {
        vehicleService.replaceVehicle(vehicle);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> deleteVehicleById (@PathVariable int id) {
        vehicleService.deleteVehicle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
