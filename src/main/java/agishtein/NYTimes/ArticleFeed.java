package agishtein.NYTimes;

import com.google.gson.annotations.SerializedName;
import java.util.*;
public class ArticleFeed {
    String status;


    @SerializedName("num_results")
    String numResults;
    ArrayList<Results> results;

    static class Results {
        String url;
        @SerializedName("published_date")
        String publishedDate;
        String title;
        @SerializedName("abstract")
        String body;
    }

    public Results getFirstArticle(){
        return results.get(0);
    }

    public HashMap<String,String> getFiveArticles(){
        HashMap<String,String> namesUrlMap = new HashMap<>();
        for(int index = 0; index < 5; index++){
            String name = results.get(index).title;
            String url = results.get(index).url;
            namesUrlMap.put(name,url);
        }
        return namesUrlMap;
    }

    public HashMap<String, String> getTitleAbstract(){
        HashMap<String,String> titlesAbstracts = this.getFiveArticles();
        int topFive = 5;
        for (int ix = 0; ix < topFive; ix++) {
            titlesAbstracts.put(results.get(ix).title, results.get(ix).body);
        }
        return titlesAbstracts;
    }
}

