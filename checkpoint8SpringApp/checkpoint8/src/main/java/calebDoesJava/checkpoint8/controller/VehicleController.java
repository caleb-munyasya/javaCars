package calebDoesJava.checkpoint8.controller;

import calebDoesJava.checkpoint8.domain.Vehicle;
import calebDoesJava.checkpoint8.service.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Operation(summary = "List all vehicle paginated and sorted", description = "You may make use of pagination and sorting"
            ,tags = "GET" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successful Operation"),
            @ApiResponse(responseCode = "404", description = "No Vehicles found")
    })
    public ResponseEntity<Page<Vehicle>> generateReportOfAllVehicles (@Parameter(hidden = true) Pageable pageable) {
        return ResponseEntity.ok(vehicleService.findAll(pageable));
    }

    @GetMapping(path = "/find")
    @Operation(summary = "List all vehicles found with by model name", description = "Will return a list of all models with the same name"
        , tags = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successful Operation"),
            @ApiResponse(responseCode = "404", description = "Vehicle found")
    })
    public ResponseEntity<List<Vehicle>> searchByModel (@RequestParam(value = "model") String model) {
        return ResponseEntity.ok(vehicleService.findByModel(model));
    }

    @GetMapping(path = "/automakers/find")
    @Operation(summary = "List all vehicles found by Automaker name", description = "Returns a list of all vehicles in the" +
            "database that have the same name", tags = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successful Operation"),
            @ApiResponse(responseCode = "404", description = "No Vehicles found")
    })
    public ResponseEntity<List<Vehicle>> searchByAutomaker (@RequestParam(value = "automakerName") String automakerName) {
        return ResponseEntity.ok(vehicleService.findByAutomaker(automakerName));
    }

    @PostMapping(path = "/admin")
    @Operation(summary = "Add a new Vehicle to the Database", description = "Inserts a new Vehicle in the databtase",
    tags = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successful Operation"),
    })
    public ResponseEntity<Vehicle> addNewVehicle(@RequestBody @Valid Vehicle vehicle) {
        return ResponseEntity.ok(vehicleService.saveToDatabase(vehicle));
    }

    @PutMapping(path = "/admin")
    @Operation(summary = "Update the data of a vehicle", description = "Replaces a vehicle already in the database " +
            "with another one with the passed data", tags = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successful Operation"),
            @ApiResponse(responseCode = "404", description = "No Vehicles found to update")
    })
    public ResponseEntity<Void> updateVehicle (@RequestBody Vehicle vehicle) {
        vehicleService.replaceVehicle(vehicle);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/admin/{id}")
    @Operation(summary = "Delete a vehicle from the database", description = "Removes a vehicle from the database" +
            "if it is found if vehicleID is found", tags = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successful Operation"),
            @ApiResponse(responseCode = "404", description = "No Vehicle found to delete")
    })
    public ResponseEntity<Void> deleteVehicleById (@PathVariable int id) {
        vehicleService.deleteVehicle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
