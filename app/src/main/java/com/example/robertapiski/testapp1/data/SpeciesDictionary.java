package com.example.robertapiski.testapp1.data;

import java.util.List;

/**
 * Created by Robert Łapiński on 2017-06-28.
 */

public class SpeciesDictionary {
    private List<Species> speciesList;
    private String name;

    public List<Species> getSpeciesList() {
        return speciesList;
    }

    public void setSpeciesList(List<Species> speciesList) {
        this.speciesList = speciesList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
