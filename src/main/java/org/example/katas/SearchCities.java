package org.example.katas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;

public class SearchCities {

    List<String> cityDatabase = Arrays.asList(new String[]{
            "Paris",
            "Budapest",
            "Skopje",
            "Rotterdam",
            "Valencia",
            "Vancouver",
            "Amsterdam",
            "Vienna",
            "Sydney",
            "New York City",
            "London",
            "Bangkok",
            "Hong Kong",
            "Dubai",
            "Rome",
            "Istanbul"});

    public List<String> search(String searchText) {
        List<String> searchResults = new ArrayList<>();
        if (searchText.equals("*")) {
            return cityDatabase;
        }
        if (searchText.length() >= 2) {
            searchResults = cityDatabase.stream()
                    .filter(city -> containsIgnoreCase(city, searchText))
                    .collect(Collectors.toList());
        }
        return searchResults;
    }
}
