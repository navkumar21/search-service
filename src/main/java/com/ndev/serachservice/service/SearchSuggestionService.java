package com.ndev.serachservice.service;

import com.ndev.serachservice.model.PrefixTree;
import com.ndev.serachservice.model.SearchSuggestionsResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchSuggestionService {

    private final SetupKeywordsService service;

    public SearchSuggestionService(SetupKeywordsService service) {
        this.service = service;
    }

    public SearchSuggestionsResponse getSearchSuggestions(String query){

        PrefixTree curr = service.getPrefixTree();

        SearchSuggestionsResponse response = new SearchSuggestionsResponse(query);

        for(char input: query.toCharArray()){
            if(curr.getChildNodes().containsKey(input)){
                curr = curr.getChildNodes().get(input);
            }else{
                return response;
            }
        }
        List<String> results = new ArrayList<>();
        results = getSearchSuggestions(curr, results);
        response.getSearchResults().addAll(results);
        response.setTotalSearchResults(results.size());
        return response;
    }

    private List<String> getSearchSuggestions(PrefixTree curr, List<String> results) {
        if(curr.isCompleted()){
            results.add(curr.getPrefix());
        }

        curr.getChildNodes().forEach((key, value) -> {
            getSearchSuggestions(value, results);
        });
        return results;
    }
}
