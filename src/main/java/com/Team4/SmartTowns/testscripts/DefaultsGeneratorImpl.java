package com.Team4.SmartTowns.testscripts;

import com.Team4.SmartTowns.checkpoints.model.Checkpoint;
import com.Team4.SmartTowns.checkpoints.service.CheckpointService;
import com.Team4.SmartTowns.medals.service.MedalService;
import com.Team4.SmartTowns.profile.model.Profile;
import com.Team4.SmartTowns.profile.service.ProfileService;
import com.Team4.SmartTowns.trails.model.Trail;
import com.Team4.SmartTowns.trails.service.TrailService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DefaultsGeneratorImpl implements DefaultsGenerator {
    private TrailService trailService;
    private CheckpointService checkpointService;
    private ProfileService profileService;
    private MedalService medalService;

    public DefaultsGeneratorImpl(TrailService trailService, CheckpointService checkpointService, ProfileService profileService, MedalService medalService) {
        this.trailService = trailService;
        this.checkpointService = checkpointService;
        this.profileService = profileService;
        this.medalService = medalService;
    }

    @Override
    public void generateTrailsAndUsers(){
        generateTrails();
        generateUsers();
    }

    public void generateTrails() {
        Trail trail1 = createTempTrail("Cardiff Castle to Queen Street", "Cardiff", "A serene town along the shore, blending cobblestone streets with beachside cafes and historic cottages.");
        createTempCheckpoint(trail1, 0,"Cardiff Castle", "A historic fortress in Cardiff, Wales, blending Roman, medieval, and Victorian architecture in the heart of the city.");
        createTempCheckpoint(trail1, 1, "Checkpoint 2", "(Description of checkpoint 2)");
        addMultipleCheckpointsToTrail(trail1, 2);
        trailService.createTrail(trail1);

        Trail trail2 = createTempTrail("Newport Castle to the Transporter Bridge", "Newport", "Newport, a historic town, showcases colonial charm with cobbled streets and well-preserved architecture. Situated along the river, it reflects a blend of heritage and modernity, making it a captivating destination in Wales.");
        createTempCheckpoint(trail2, 0,"Newport Castle", "(Description of checkpoint 1)");
        addMultipleCheckpointsToTrail(trail2, 1);
        trailService.createTrail(trail2);

        Trail trail3 = createTempTrail("Swansea Mumbles to Gower", "Swansea", "Nestled along the scenic coastline, Swansea is a coastal haven known for its quaint beauty. With sandy beaches, a bustling marina, and a rich maritime history, the town offers a serene escape by the sea.");
        createTempCheckpoint(trail3, 0,"Mumbles", "(Description of checkpoint 1)");
        addMultipleCheckpointsToTrail(trail3, 1);
        trailService.createTrail(trail3);

    }

    private void addMultipleCheckpointsToTrail(Trail trail,int start) {
        for (int i = start; i < 20; i++) {
            int j = i+1;
            createTempCheckpoint(trail, i,"Checkpoint " + j, "(Description of checkpoint " + j + ")");
        }
    }

    public void generateUsers() {
        int noOfCheckpoints = checkpointService.getAllCheckpoints().size();
        createUserWithCheckpoints(noOfCheckpoints, "john", "john", "john@example.com", "1 High Street", "Flat 4B", "London", "SW1A 1AA");
        createUserWithCheckpoints(noOfCheckpoints, "alice", "alice", "alice@example.com", "15 Elm Avenue", "Apt 7C", "Manchester", "M1 2NE");
        createUserWithCheckpoints(noOfCheckpoints, "bob", "bob", "bob@example.com", "28 Oak Crescent", "Unit 12", "Birmingham", "B1 1AA");
        createUserWithCheckpoints(noOfCheckpoints, "susan", "susan", "susan@example.com", "42 Pine Terrace", "Flat 15D", "Glasgow", "G1 2AA");
        createUserWithCheckpoints(noOfCheckpoints, "david", "david", "david@example.com", "57 Birch Close", "Suite 22A", "Edinburgh", "EH1 1AA");
        createUserWithCheckpoints(noOfCheckpoints, "emily", "emily", "emily@example.com", "69 Maple Court", "Unit 31B", "Belfast", "BT1 1AA");
        createUserWithCheckpoints(noOfCheckpoints, "ryan", "ryan", "ryan@example.com", "83 Willow Lane", "Apt 40C", "Cardiff", "CF1 1AA");
        createUserWithCheckpoints(noOfCheckpoints, "olivia", "olivia", "olivia@example.com", "99 Cedar Road", "Suite 51D", "Edinburgh", "EH2 2AA");
        createUserWithCheckpoints(noOfCheckpoints, "michael", "michael", "michael@example.com", "114 Birch Avenue", "Unit 60A", "Glasgow", "G2 2AA");
        createUserWithCheckpoints(noOfCheckpoints, "emma", "emma", "emma@example.com", "130 Oak Street", "Apt 75B", "Manchester", "M2 2AA");
    }

    private void createUserWithCheckpoints(int noOfCheckpoints, String userName, String password, String email, String address, String address2, String city, String zipCode) {
        Profile tempProfile = new Profile(userName, password, email, address, address2, city, zipCode, new ArrayList<>());
        String username = profileService.addProfile(tempProfile);
        Random random = new Random();
        int checkpointsToAdd = random.nextInt(noOfCheckpoints) + 1;
        for (int j = 0; j < checkpointsToAdd; j++) {
            Long checkpointId = random.nextLong(noOfCheckpoints) + 1;
            checkpointService.addCheckpointToUser(checkpointId, username);
        }
        medalService.awardMedalToUser(username);
    }

    private Trail createTempTrail(String name, String location, String description) {
        // Method for helping create default trails
        Trail tempTrail = new Trail();
        tempTrail.setName(name);
        tempTrail.setLocation(location);
        tempTrail.setDescription(description);
        return tempTrail;
    }

    private Trail createTempCheckpoint(Trail trail, int pos, String name, String description) {
        // Method to help create default trails checkpoint
        List<Checkpoint> checkpoints = trail.getCheckpoints();
        Checkpoint temp = checkpoints.get(pos);
        temp.setName(name);
        temp.setDescription(description);
        trail.setCheckpoints(checkpoints);
        return trail;
    }
}
