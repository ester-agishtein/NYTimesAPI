package agishtein.NYTimes;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class CommentServiceFactory {
    public CommentService getInstance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nytimes.com/svc/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CommentService service = retrofit.create(CommentService.class);
        return service;
    }

}
