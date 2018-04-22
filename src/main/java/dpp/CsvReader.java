package dpp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

public class CsvReader {
    public static List<Coordiante> LoadData(String nameOfFile) {
        BufferedReader br = null;
        String line = "";
        String separator = ";";
        List<Coordiante> listToReturn = new LinkedList<Coordiante>();
        try {
            br = new BufferedReader(new FileReader(nameOfFile));

            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split(separator);
                Coordiante buffor = new Coordiante();
                buffor.Name = splitLine[0];
                buffor.Latitude = Double.parseDouble(splitLine[1]);
                buffor.Longitude = Double.parseDouble(splitLine[2]);
                listToReturn.add(buffor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listToReturn;
    }
}
