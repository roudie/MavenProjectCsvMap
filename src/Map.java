import com.teamdev.jxmaps.*;
import com.teamdev.jxmaps.swing.MapView;

import dpp.Coordiante;
import dpp.CsvReader;

import javax.swing.*;
import java.awt.*;


public class Map extends MapView {
    public Map() {
        setOnMapReadyHandler(new MapReadyHandler() {

            public void onMapReady(MapStatus status) {
                if (status == MapStatus.MAP_STATUS_OK) {
                    final com.teamdev.jxmaps.Map map = getMap();
                    MapOptions options = new MapOptions(map);
                    MapTypeControlOptions controlOptions = new MapTypeControlOptions(map);
                    controlOptions.setPosition(ControlPosition.TOP_RIGHT);
                    options.setMapTypeControlOptions(controlOptions);
                    map.setOptions(options);
                    map.setCenter(new LatLng(map, 35.91466, 10.312499));
                    map.setZoom(2.0);
                    for(Coordiante coordiante : CsvReader.LoadData("data.csv")) {
                        Marker marker = new Marker(map);
                        LatLng latLng = new LatLng(coordiante.Latitude, coordiante.Longitude);
                        marker.setPosition(latLng);
                        marker.setTitle(coordiante.Name);
                        MarkerLabel markerLabel = new MarkerLabel();
                        markerLabel.setText(coordiante.Name);
                        marker.setLabel(markerLabel);
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        Map sample = new Map();
        
        JFrame frame = new JFrame("Map with markers");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(sample, BorderLayout.CENTER);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}