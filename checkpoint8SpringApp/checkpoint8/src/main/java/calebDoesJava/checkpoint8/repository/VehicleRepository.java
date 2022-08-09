package calebDoesJava.checkpoint8.repository;

import calebDoesJava.checkpoint8.domain.Automaker;
import calebDoesJava.checkpoint8.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    List<Vehicle> findByModel(String model);
    List<Vehicle> findByAutomakerName(String automakerName);
}
