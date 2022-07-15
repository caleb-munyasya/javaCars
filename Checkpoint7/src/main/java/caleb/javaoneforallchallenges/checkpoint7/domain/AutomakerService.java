package caleb.javaoneforallchallenges.checkpoint7.domain;

public class AutomakerService {
    AutomakerRepository automakerRepository = new AutomakerRepository();

    public Automaker searchByName (String automakerName) {
        return automakerRepository.findByName(automakerName);
    }
    public void Save(Integer automakerID, String automakerName ) {
        automakerRepository.save(automakerID,automakerName);
    }
}
