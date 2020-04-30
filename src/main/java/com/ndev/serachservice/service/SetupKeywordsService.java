package com.ndev.serachservice.service;

import com.ndev.serachservice.model.PrefixTree;
import com.ndev.serachservice.model.SetupKeywordsRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetupKeywordsService {

    private PrefixTree prefixTree = new PrefixTree("");

    public void setupPrefixTree(SetupKeywordsRequest request){
        List<String> keywords = request.getKeywords();
        keywords.forEach(this::setupData);
    }

    private void setupData(String input){
        char[] inputChars = input.toCharArray();
        PrefixTree curr = prefixTree;
        for(int i=0; i<inputChars.length; i++){
            if(!curr.getChildNodes().containsKey(inputChars[i])){
                PrefixTree node = new PrefixTree(input.substring(0, i+1));
                curr.getChildNodes().put(inputChars[i],node);
            }
            curr = curr.getChildNodes().get(inputChars[i]);

            if(i == inputChars.length-1){
                curr.setCompleted(true);
            }
        }
    }

    public PrefixTree getPrefixTree() {
        return prefixTree;
    }
}
