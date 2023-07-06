package LabTest1_try;

import java.util.ArrayList;

public abstract class Feature<T> {
    ArrayList<Data> listOfData;
    public Feature(ArrayList<Data> listOfData) {
        this.listOfData = listOfData;
    }
    public abstract T dataCleaning();
    

}
