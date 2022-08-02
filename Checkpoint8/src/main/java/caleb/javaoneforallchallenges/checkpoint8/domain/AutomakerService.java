package caleb.javaoneforallchallenges.checkpoint8.domain;

import java.util.List;

public class AutomakerService {
    AutomakerRepository automakerRepository = new AutomakerRepository();

    public Automaker searchByName (String automakerName) {
        return automakerRepository.findByName(automakerName);
    }
    public void Save(Integer automakerID, String automakerName ) {
        automakerRepository.save(automakerID,automakerName);
    }
    public List<Automaker> findAllAutomakers () {
        return automakerRepository.findAll();
    }
}
