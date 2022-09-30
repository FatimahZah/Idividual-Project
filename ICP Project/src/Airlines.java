import readCSV.ReadContent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Airlines implements ReadContent {


    private final String PATH = "src/databases/airlines.csv";

    /**
     * Instance variables
     */
    private String airlineID;
    private String name;
    private String Alias;
    private String IATA;
    private String ICAO;
    private String callsign;
    private String country;
    private double active;


    public Airlines() {
        this.airlineID = airlineID;
        this.name = name;
        this.Alias = Alias;
        this.IATA = IATA;
        this.ICAO = ICAO;
        this.callsign = callsign;
        this.country = country;
    }

    /**
     * setters for the airlines
     */
    public void setAirlineID(String airlineID) {
        this.airlineID = airlineID;
    }

    public void setAlias(String alias) {
        Alias = alias;
    }

    public void setActive(double active) {
        this.active = active;
    }

    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setIATA(String IATA) {
        this.IATA = IATA;
    }

    public void setICAO(String ICAO) {
        this.ICAO = ICAO;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * generating getters
     *
     * @return
     */
    public double getActive() {
        return active;
    }

    public String getAirlineID() {
        return airlineID;
    }

    public String getAlias() {
        return Alias;
    }

    public String getCallsign() {
        return callsign;
    }

    public String getCountry() {
        return country;
    }

    public String getIATA() {
        return IATA;
    }

    public String getICAO() {
        return ICAO;
    }

    public String getName() {
        return name;
    }

    @Override
    public void readFiles() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(PATH));
        String line;
        while ((line = br.readLine()) != null)   //returns a Boolean value
        {
            String[] airline = line.split(",");
            System.out.println(Arrays.toString(airline));
        }

    }

    public static void main(String[] args){
        Airlines a = new Airlines();
        try {
            a.readFiles();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(a.toString());
    }
}



