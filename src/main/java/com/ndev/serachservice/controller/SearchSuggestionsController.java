package com.ndev.serachservice.controller;

import com.ndev.serachservice.model.SearchSuggestionsResponse;
import com.ndev.serachservice.model.SetupKeywordsRequest;
import com.ndev.serachservice.service.SearchSuggestionService;
import com.ndev.serachservice.service.SetupKeywordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/search")
public class SearchSuggestionsController {

    @Autowired
    private SearchSuggestionService searchSuggestionService;

    @Autowired
    private SetupKeywordsService setupKeywordsService;

    @GetMapping()
    public SearchSuggestionsResponse getSuggestions(@RequestParam(name = "query") String input){
        return searchSuggestionService.getSearchSuggestions(input);
    }

    @PostMapping("/setupdata")
    public void setupDataForSearch(@RequestBody SetupKeywordsRequest setupKeywordsRequest){
        setupKeywordsService.setupPrefixTree(setupKeywordsRequest);
    }
}
