package model;

import javafx.scene.paint.Color;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PaletteModel {
    private List<String> myColors = new ArrayList<>();

    public PaletteModel () {
        String[] vals = new String[] {"000000000", "255255255", "255000000","000255000", "000000255", "252144003", "252240003", "036133081",
                "163230218", "163178230", "025068209", "114066201", "242165225", "214060135"};
        myColors.addAll(Arrays.asList(vals));
    }

    public void addColor(double index, double r, double g, double b){
        int indexInt = (int) index;
        String element = cleanColorVals(r,g,b);
        myColors.set(indexInt, element);
    }

    public List<Double> getColor(double index){
        int indexInt = (int) index;
        String colorString = myColors.get(indexInt);
        return parseColor(colorString);
    }

    public double getIndex(List<Double> rgbVals){
        String color = cleanColorVals(rgbVals.get(0), rgbVals.get(1), rgbVals.get(2));
        return rgbVals.indexOf(color);
    }

    private String cleanColorVals(double  r, double g, double b){
        StringBuilder rString = new StringBuilder(Double.toString(r));
        StringBuilder gString = new StringBuilder(Double.toString(g));
        StringBuilder bString = new StringBuilder(Double.toString(b));
        StringBuilder answer = new StringBuilder();
        while(rString.length()!=3){
            rString.insert(0, "0");
        }
        while(gString.length()!=3){
            gString.insert(0, "0");
        }
        while(bString.length()!=3){
            bString.insert(0, "0");
        }
        answer.insert(0, bString);
        answer.insert(0, gString);
        answer.insert(0,rString);
        return answer.toString();
    }

    private List<Double> parseColor(String colorString){
        double r = Double.parseDouble(colorString.substring(0,3));
        double g = Double.parseDouble(colorString.substring(3,6));
        double b = Double.parseDouble(colorString.substring(6,9));
        return  Arrays.asList(r,g,b);
    }

}
