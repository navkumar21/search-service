package com.ndev.serachservice.model;

import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionsResponse {

    private String searchKey;
    private int totalSearchResults;
    private final List<String> searchResults = new ArrayList<>();


    public SearchSuggestionsResponse(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public int getTotalSearchResults() {
        return totalSearchResults;
    }

    public void setTotalSearchResults(int totalSearchResults) {
        this.totalSearchResults = totalSearchResults;
    }

    public List<String> getSearchResults() {
        return searchResults;
    }
}
