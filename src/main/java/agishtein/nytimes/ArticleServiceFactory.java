package agishtein.nytimes;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ArticleServiceFactory {
    public ArticleService getInstance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nytimes.com/svc/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ArticleService service = retrofit.create(ArticleService.class);
        return service;
    }
}
