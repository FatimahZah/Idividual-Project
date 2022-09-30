import readCSV.ReadContent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Airports implements ReadContent {
    /**
     * Instances variables or fields
     */

    private final String PATH = "src/databases/airports.csv";
    private String airportID;
    private String name;
    private  String city;
    private String country;
    private String IATA;
    private String ICAO;
    private double latitude;
    private double longitude;
    private double timezone;
    private  String DST;
    private  String TzDatabase;
    private  String type;
    private String source;


    public Airports(){
        this.airportID = airportID;
        this.name = name;
        this.city = city;
        this.country = country;
        this.IATA = IATA;
        this.ICAO = ICAO;
        this.latitude = latitude;
        this.longitude =longitude;
        this.timezone = timezone;
        this.DST = DST;
        this.TzDatabase =TzDatabase;
        this.type = type;
        this.source = source;
    }

    /**
     * Getters and setter
     */

    public String getAirportID() {
        return airportID;
    }

    public Airports setAirportID(String airportID) {
        this.airportID = airportID;
        return this;
    }

    public String getName() {
        return name;
    }

    public Airports setName(String name) {
        this.name = name;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Airports setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Airports setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getIATA() {
        return IATA;
    }

    public Airports setIATA(String IATA) {
        this.IATA = IATA;
        return this;
    }

    public String getICAO() {
        return ICAO;
    }

    public Airports setICAO(String ICAO) {
        this.ICAO = ICAO;
        return this;
    }

    public double getLatitude() {
        return latitude;
    }

    public Airports setLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public double getLongitude() {
        return longitude;
    }

    public Airports setLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }

    public double getTimezone() {
        return timezone;
    }

    public Airports setTimezone(double timezone) {
        this.timezone = timezone;
        return this;
    }

    public String getDST() {
        return DST;
    }

    public Airports setDST(String DST) {
        this.DST = DST;
        return this;
    }

    public String getTzDatabase() {
        return TzDatabase;
    }

    public Airports setTzDatabase(String tzDatabase) {
        TzDatabase = tzDatabase;
        return this;
    }

    public String getType() {
        return type;
    }

    public Airports setType(String type) {
        this.type = type;
        return this;
    }

    public String getSource() {
        return source;
    }

    public Airports setSource(String source) {
        this.source = source;
        return this;
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
        Airports p = new Airports();
        try {
            p.readFiles();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(p.toString());
    }
}
