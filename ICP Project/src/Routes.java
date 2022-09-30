import readCSV.ReadContent;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Routes implements ReadContent {
    /**
     * Instances of varibles
     */

    private static final HashMap<String, ArrayList<String>> allPossibleRoutes = new HashMap<>();

    private final String PATH = "src/databases/routes.csv";
    private String airline;
    private String airlineID;
    private String sourceAirport;
    private String sourceAirportID;
    private String DestinationAirport;
    private String codeshare;
    private int stops;
    private String equipment;

    Routes(){}
    public Routes(String airline, String airlineID, String sourceAirport,String sourceAirportID,
                  String DestinationAirport,String codeshare, int stops,String equipment){
        this.airline = airline;
        this.airlineID = airlineID;
        this.sourceAirport = sourceAirport;
        this.sourceAirportID = sourceAirportID;
        this.DestinationAirport = DestinationAirport;
        this.codeshare = codeshare;
        this.stops = stops;
        this.equipment = equipment;
    }

    /**
     * getters and setters
     */
    public String getAirline() {
        return airline;
    }

    public Routes setAirline(String airline) {
        this.airline = airline;
        return this;
    }

    public String getAirlineID() {
        return airlineID;
    }

    public Routes setAirlineID(String airlineID) {
        this.airlineID = airlineID;
        return this;
    }

    public String getSourceAirport() {
        return sourceAirport;
    }

    public Routes setSourceAirport(String sourceAirport) {
        this.sourceAirport = sourceAirport;
        return this;
    }

    public String getSourceAirportID() {
        return sourceAirportID;
    }

    public Routes setSourceAirportID(String sourceAirportID) {
        this.sourceAirportID = sourceAirportID;
        return this;
    }

    public String getDestinationAirport() {
        return DestinationAirport;
    }

    public Routes setDestinationAirport(String destinationAirport) {
        DestinationAirport = destinationAirport;
        return this;
    }

    public String getCodeshare() {
        return codeshare;
    }

    public Routes setCodeshare(String codeshare) {
        this.codeshare = codeshare;
        return this;
    }

    public int getStops() {
        return stops;
    }

    public Routes setStops(int stops) {
        this.stops = stops;
        return this;
    }

    public String getEquipment() {
        return equipment;
    }

    public Routes setEquipment(String equipment) {
        this.equipment = equipment;
        return this;
    }


    @Override
    public void readFiles() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(PATH));
        String line;
        while ((line = br.readLine()) != null)   //returns a Boolean value
        {
            String[] airline = line.split(",");
            //System.out.println(Arrays.toString(airline));
            if (!allPossibleRoutes.containsKey(airline[2])){
                allPossibleRoutes.put(airline[2], new ArrayList<String>());
            }
            allPossibleRoutes.get(airline[2]).add(airline[4]);
        }
    }
     //  provides the string representation of the object allPossibleRoutes
    public String toString(){
        return allPossibleRoutes.toString();
    }

    // A method to show all the possible valid routes given a source and a destination
    public void showValidRoutes(String source, String destination){
        HashMap<String, Boolean> visited = new HashMap<>();
        ArrayList<String> routes = new ArrayList<>();

        //if the route is part of the airline, add, else skip
        routes.add(source);

        showAllRoutesFromSource(source,destination,visited, routes);
    }

    private void showAllRoutesFromSource(String source, String destination, HashMap<String, Boolean> visited, ArrayList<String> routes){
        if (source.equals(destination)){
            System.out.println(routes);
        }

        visited.put(source, true);

        for (String r : allPossibleRoutes.keySet()){
            if (visited.get(r) == null){
             routes.add(r);
             showAllRoutesFromSource(r, destination, visited, routes);
             routes.remove(r);
            }
        }

        visited.put(source, null);

    }
     // main method to test the program
    public static void main(String[] args) {
        Routes r = new Routes();

        try {
            r.readFiles();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //System.out.println(r.toString());

        r.showValidRoutes("ACC", "LHR");

    }


}

