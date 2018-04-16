package dpp.korniewicz;

public class Coordiante {
    public double Latitude;
    public double Longitude;
    public String Name;

    public String Display() {
        String describe = "";
        describe += "Name: " + Name;
        describe += "\tLatitude: " + Latitude;
        describe += "\tLongitude: " + Longitude;
        return  describe;
    }
}
