package com.Team4.SmartTowns.testscripts;

import com.Team4.SmartTowns.checkpoints.model.Checkpoint;
import com.Team4.SmartTowns.checkpoints.service.CheckpointService;
import com.Team4.SmartTowns.medals.service.MedalService;
import com.Team4.SmartTowns.profile.model.Profile;
import com.Team4.SmartTowns.profile.service.ProfileService;
import com.Team4.SmartTowns.trails.model.Trail;
import com.Team4.SmartTowns.trails.service.TrailService;
import org.springframework.stereotype.Service;

import java.util.*;

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

        //Adding preset trails

        Trail trail1 = createTempTrail("Cardiff Castle to Queen Street", "Cardiff", "A serene town along the shore, blending cobblestone streets with beachside cafes and historic cottages.");
        //I added some preset checkpoints in order to show the map working, please don't delete - Gary
        createTempCheckpoint(trail1, 0,"Cardiff Castle", "A historic fortress in Cardiff, Wales, blending Roman, medieval, and Victorian architecture in the heart of the city.", 51.4822313, -3.1837516);
        createTempCheckpoint(trail1, 1, "Cardiff Market", "A bustling marketplace known for its vibrant atmosphere and local produce, offering a blend of Welsh culture and international goods.", 51.4803, -3.1805);
        createTempCheckpoint(trail1, 2, "Bute Park", "A vast expanse of landscaped gardens and parkland, stretching along the River Taff with recreational paths and historical monuments.", 51.4847, -3.1822);
        createTempCheckpoint(trail1, 3, "Principality Stadium", "Iconic sports venue hosting major events with a retractable roof, known for its electrifying atmosphere.", 51.4782, -3.1828);
        createTempCheckpoint(trail1, 4, "Cardiff Bay", "A picturesque waterfront with an array of dining and entertainment options, and home to the Wales Millennium Centre.", 51.4636, -3.1648);
        createTempCheckpoint(trail1, 5, "Millennium Walkway", "A scenic walking route alongside the River Taff, linking many of Cardiff's key attractions.", 51.4763, -3.1773);
        createTempCheckpoint(trail1, 6, "Llandaff Cathedral", "An architectural gem and a place of worship, with a history stretching back to the Normans.", 51.4995, -3.2184);
        createTempCheckpoint(trail1, 7, "Roath Park", "A classic Victorian park with a beautiful lake, conservatory, and botanical gardens.", 51.5017, -3.1651);
        createTempCheckpoint(trail1, 8, "St Fagans National Museum of History", "An open-air museum chronicling Welsh history, culture, and architecture.", 51.4868, -3.2727);
        createTempCheckpoint(trail1, 9, "Castell Coch", "A 19th-century Gothic Revival castle built above the village of Tongwynlais.", 51.5358, -3.2547);
        createTempCheckpoint(trail1, 10, "Cardiff University", "A prestigious and historic seat of learning, known for its distinctive architecture.", 51.4888, -3.1788);
        createTempCheckpoint(trail1, 11, "The Cardiff Story Museum", "A museum that tells the tale of the city's history, located in the old library building.", 51.4800, -3.1800);
        createTempCheckpoint(trail1, 12, "Mermaid Quay", "A bustling shopping and dining area on the waterfront of Cardiff Bay.", 51.4638, -3.1639);
        createTempCheckpoint(trail1, 13, "The Senedd", "The home of Welsh politics, with its innovative architecture and public galleries.", 51.4630, -3.1635);
        createTempCheckpoint(trail1, 14, "Cardiff International White Water", "An exciting, Olympic standard white water rafting centre in Cardiff Bay.", 51.4674, -3.1667);
        createTempCheckpoint(trail1, 15, "Pierhead Building", "An iconic red-brick building that stands as a symbol of Wales' commercial and industrial past.", 51.4631, -3.1646);
        createTempCheckpoint(trail1, 16, "Techniquest", "A hands-on science discovery centre, perfect for inquisitive minds of all ages.", 51.4645, -3.1645);
        createTempCheckpoint(trail1, 17, "Cardiff Helicopter Rides", "A unique way to see the city from above, offering breathtaking views.", 51.4651, -3.1475);
        createTempCheckpoint(trail1, 18, "Wales National Ice Rink", "An indoor rink providing a venue for ice sports and public skating sessions.", 51.4780, -3.1767);
        createTempCheckpoint(trail1, 19, "Cardiff City Hall", "An impressive Edwardian building, a center of local government and civic events.", 51.4818, -3.1767);
        trailService.createTrail(trail1);

        Trail trail2 = createTempTrail("Newport Castle to the Transporter Bridge", "Newport", "Newport, a historic town, showcases colonial charm with cobbled streets and well-preserved architecture. Situated along the river, it reflects a blend of heritage and modernity, making it a captivating destination in Wales.");
        createTempCheckpoint(trail2, 0, "Newport Castle", "A historic castle in Newport with a rich colonial history.", 51.5877, -2.9984);
        createTempCheckpoint(trail2, 1, "Riverfront Theatre and Arts Centre", "An iconic cultural venue hosting a variety of performances and exhibitions.", 0,0);
        createTempCheckpoint(trail2, 2, "Belle Vue Park", "A picturesque public park featuring formal gardens, a conservatory, and a cafe.", 0,0);
        createTempCheckpoint(trail2, 3, "St. Woolos Cathedral", "A magnificent cathedral with a history dating back to the 6th century.", 0,0);
        createTempCheckpoint(trail2, 4, "Friars Walk Shopping Centre", "A modern shopping destination with a range of retail stores and dining options.", 0,0);
        createTempCheckpoint(trail2, 5, "Newport Market", "A bustling indoor market offering a variety of fresh produce, local crafts, and more.", 0,0);
        createTempCheckpoint(trail2, 6, "The River Usk", "Enjoy a scenic walk along the banks of the River Usk with beautiful views.", 0,0);
        createTempCheckpoint(trail2, 7, "Victoria Park", "A charming park with green spaces, playgrounds, and recreational facilities.", 0,0);
        createTempCheckpoint(trail2, 8, "Transporter Bridge Visitors Centre", "Learn about the history of the iconic Transporter Bridge at the visitors center.", 0,0);
        createTempCheckpoint(trail2, 9, "Newport Wetlands Reserve", "Explore a nature reserve with diverse wildlife and birdwatching opportunities.", 0,0);
        createTempCheckpoint(trail2, 10, "George Street Bridge", "Cross the river via George Street Bridge and enjoy panoramic views.", 0,0);
        createTempCheckpoint(trail2, 11, "Newport Stadium", "A sports stadium hosting various events and activities.", 0,0);
        createTempCheckpoint(trail2, 12, "Tredegar House", "Visit a historic mansion surrounded by beautiful gardens and parkland.", 0,0);
        createTempCheckpoint(trail2, 13, "Ridgeway Golf Club", "Play a round of golf at this scenic golf club.", 0,0);
        createTempCheckpoint(trail2, 14, "Caerleon Roman Fortress and Baths", "Discover the well-preserved remains of a Roman fortress and baths.", 0,0);
        createTempCheckpoint(trail2, 15, "Caerleon Amphitheatre", "Explore the ancient amphitheater, once used for gladiator contests.", 0,0);
        createTempCheckpoint(trail2, 16, "Isca Augusta", "Visit the archaeological site of the Roman legionary fortress.", 0,0);
        createTempCheckpoint(trail2, 17, "Fourteen Locks Canal Centre", "Learn about the canal system and its historical significance.", 0,0);
        createTempCheckpoint(trail2, 18, "Rogerstone Railway Tunnel", "Walk or cycle through the historic railway tunnel.", 0,0);
        createTempCheckpoint(trail2, 19, "Newport Transporter Bridge", "Reach the final checkpoint and marvel at the engineering feat of the iconic Transporter Bridge.", 0,0);
        trailService.createTrail(trail2);


        Trail trail3 = createTempTrail("Swansea Mumbles to Gower", "Swansea", "Nestled along the scenic coastline, Swansea is a coastal haven known for its quaint beauty. With sandy beaches, a bustling marina, and a rich maritime history, the town offers a serene escape by the sea.");
        createTempCheckpoint(trail3, 0, "Mumbles", "A charming seaside district in Swansea.", 0, 0);
        createTempCheckpoint(trail3, 1, "Oystermouth Castle", "Explore the historic ruins of Oystermouth Castle, offering panoramic views of the coast.", 0, 0);
        createTempCheckpoint(trail3, 2, "Swansea Bay Promenade", "Take a leisurely stroll along the scenic promenade of Swansea Bay with breathtaking sea views.", 0, 0);
        createTempCheckpoint(trail3, 3, "Verdi's Cafe", "Enjoy a coffee or meal at Verdi's, a popular cafe overlooking the bay.", 0, 0);
        createTempCheckpoint(trail3, 4, "Mumbles Pier", "Visit Mumbles Pier, an iconic landmark with amusements and stunning views.", 0, 0);
        createTempCheckpoint(trail3, 5, "Bracelet Bay", "Relax at Bracelet Bay, a picturesque cove with rocky cliffs and tidal pools.", 0, 0);
        createTempCheckpoint(trail3, 6, "Langland Bay", "A beautiful sandy beach with excellent surfing conditions and coastal walks.", 0, 0);
        createTempCheckpoint(trail3, 7, "Caswell Bay", "Explore Caswell Bay, known for its golden sands and scenic surroundings.", 0, 0);
        createTempCheckpoint(trail3, 8, "Bishop's Wood", "Wander through Bishop's Wood, a tranquil woodland area with diverse flora.", 0, 0);
        createTempCheckpoint(trail3, 9, "Pennard Castle", "Discover the medieval ruins of Pennard Castle on the Gower Peninsula.", 0, 0);
        createTempCheckpoint(trail3, 10, "Three Cliffs Bay", "Visit the stunning Three Cliffs Bay, known for its three limestone cliffs and sandy shores.", 0, 0);
        createTempCheckpoint(trail3, 11, "Pobbles Bay", "A secluded beach with rugged cliffs, perfect for a quiet escape.", 0, 0);
        createTempCheckpoint(trail3, 12, "Culver Hole", "Explore Culver Hole, a mysterious stone structure built into the cliffs.", 0, 0);
        createTempCheckpoint(trail3, 13, "Rhossili Bay", "Enjoy the vast sandy expanse of Rhossili Bay, backed by dramatic cliffs.", 0, 0);
        createTempCheckpoint(trail3, 14, "Worm's Head", "Hike to Worm's Head, a tidal island with unique rock formations and wildlife.", 0, 0);
        createTempCheckpoint(trail3, 15, "National Trust Visitor Centre", "Learn about the Gower Peninsula's natural and cultural heritage at the Visitor Centre.", 0, 0);
        createTempCheckpoint(trail3, 16, "Llangennith Beach", "A popular beach for water sports enthusiasts and those seeking wide-open spaces.", 0, 0);
        createTempCheckpoint(trail3, 17, "Burry Holms", "Explore the ancient burial mound at Burry Holms with views of the surrounding coastline.", 0, 0);
        createTempCheckpoint(trail3, 18, "Whiteford Sands", "Relax at Whiteford Sands, a remote and unspoiled beach on the Gower Peninsula.", 0, 0);
        createTempCheckpoint(trail3, 19, "Weobley Castle", "Visit Weobley Castle, a medieval fortified manor house offering historic charm and panoramic views.", 0, 0);
        trailService.createTrail(trail3);


        Trail trail4 = createTempTrail("Cardiff Shopping Expedition", "Cardiff", "This trail takes you on a shopping adventure starting from Cardiff Central Railway Station, leading you to some of the best shopping destinations in the city. The journey combines a mix of high street stores, boutique shops, and unique finds, ensuring you have a delightful shopping experience.");
        createTempCheckpoint(trail4, 0,"Cardiff Central Railway Station", "As you exit the station, head northeast toward St. Mary Street.",0,0);
        createTempCheckpoint(trail4, 1, "St. David's Shopping Centre", "Walk along St. Mary Street and make your way to St. David's Shopping Centre, one of the largest shopping malls in the UK. Explore a variety of shops ranging from popular high street brands to specialty stores.",0,0);
        createTempCheckpoint(trail4, 2, "Queen Street", "Exit the shopping center onto Queen Street and continue east. Queen Street is lined with shops, department stores, and cafes. Take your time to explore the diverse range of stores.",0,0);
        createTempCheckpoint(trail4, 3, "The Royal Arcade", "Turn right onto The Hayes and enter The Royal Arcade. This charming Victorian shopping arcade is home to independent boutiques, vintage shops, and unique gift stores.",0,0);
        createTempCheckpoint(trail4, 4, "Cardiff Market", "Head south from The Royal Arcade to Cardiff Market. This historic market offers a vibrant atmosphere with stalls selling fresh produce, local crafts, and unique finds. It's a great place to pick up some local treats.",0,0);
        createTempCheckpoint(trail4, 5, "High Street Arcade", "From Cardiff Market, head west to St. John Street, and you'll find High Street Arcade. This hidden gem is filled with independent shops, fashion boutiques, and quirky stores.",0,0);
        createTempCheckpoint(trail4, 6, "Morgan Arcade", "Continue west to reach Morgan Arcade, another beautiful Victorian arcade. It houses a mix of vintage shops, independent retailers, and cozy cafes.",0,0);
        createTempCheckpoint(trail4, 7, "Capitol Shopping Centre", "Head northwest on St. Mary Street to Capitol Shopping Centre. Here, you'll find a range of shops, including fashion, electronics, and more.",0,0);
        createTempCheckpoint(trail4, 8, "Hayes Island Snack Bar", "Have a rest at Hayes Island Snack Bar, a local institution. Relax with a cup of tea or coffee and reflect on your shopping finds.",0,0);
        addMultipleCheckpointsToTrail(trail4, 9);
        trailService.createTrail(trail4);


    }

    public void addMultipleCheckpointsToTrail(Trail trail,int start) {
        for (int i = start; i < 20; i++) {
            int j = i+1;
            createTempCheckpoint(trail,i,"Checkpoint " + j, "(Description of checkpoint " + j + ")", 0, 0);
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
        // assign a random number of checkpoints to each user
        Random random = new Random();
        int checkpointsToAdd = random.nextInt(noOfCheckpoints) + 1; //random number of checkpoints to add
        List<Long> uniqueCheckpointIds = new ArrayList<>();
        for (int j = 0; j < checkpointsToAdd; j++) {
            Long checkpointId = (long) random.nextInt(noOfCheckpoints) + 1 ; // random checkpoint id
            if(!uniqueCheckpointIds.contains(checkpointId)){
                uniqueCheckpointIds.add(checkpointId);
            }
        }
        for (Long id : uniqueCheckpointIds) {
            checkpointService.addCheckpointToUser(id, username);
        }
        medalService.awardMedalToUser(username);
    }

    public Trail createTempTrail(String name, String location, String description) {
        // Method for helping create default trails
        Trail tempTrail = new Trail();
        tempTrail.setName(name);
        tempTrail.setLocation(location);
        tempTrail.setDescription(description);
        return tempTrail;
    }

    public void createTempCheckpoint(Trail trail, int pos, String name, String description, double latitude, double longitude) {
        Checkpoint temp = new Checkpoint();
        temp.setName(name);
        temp.setDescription(description);
        temp.setCoordinates(new double[]{latitude, longitude});

        List<Checkpoint> tempList = trail.getCheckpoints();
        tempList.set(pos, temp);
        trail.setCheckpoints(tempList);
    }

}
