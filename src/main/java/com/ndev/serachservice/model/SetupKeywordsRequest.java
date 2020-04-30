package com.ndev.serachservice.model;

import java.util.ArrayList;
import java.util.List;

public class SetupKeywordsRequest {

    final List<String> keywords = new ArrayList<>();

    public List<String> getKeywords() {
        return keywords;
    }
}
