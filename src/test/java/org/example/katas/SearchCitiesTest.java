package org.example.katas;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchCitiesTest {

    // Phases of TDD:
    // 1- write a test.
    // 2- make it compile.
    // 3- run to see that it fails. (RED)
    // 4- make it run. (GREEN)
    // 5- eliminate duplication (REFACTOR)

    @Test
    public void testSearchTextFewerThanTwoCharacters() {
        SearchCities searchCities = new SearchCities();
        List<String> searchResults = searchCities.search("l");
        assertEquals(searchResults.size(), 0);
    }

    @Test
    public void testSearchTextEqualOrMoreThanTwoCharacters() {
        SearchCities searchCities = new SearchCities();
        List<String> searchResults = searchCities.search("Va");
        assertThat(searchResults, containsInAnyOrder("Valencia", "Vancouver"));
    }

    @Test
    public void testSearchCaseInsensitive() {
        SearchCities searchCities = new SearchCities();
        List<String> searchResults = searchCities.search("istanbul");
        assertThat(searchResults, contains("Istanbul"));
        searchResults = searchCities.search("va");
        assertThat(searchResults, containsInAnyOrder("Valencia", "Vancouver"));
    }

    @Test
    public void testSearchTextIsAnyPartOfCityName() {
        SearchCities searchCities = new SearchCities();
        List<String> searchResults = searchCities.search("ape");
        assertThat(searchResults, contains("Budapest"));
    }

    @Test
    public void testSearchTextIsAnAsterisk () {
        SearchCities searchCities = new SearchCities();
        List<String> searchResults = searchCities.search("*");
        assertThat(searchResults.size(), equalTo(16));
    }

}
