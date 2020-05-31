package agishtein.NYTimes;

import retrofit2.Call;
import retrofit2.http.*;

public interface CommentService {
    @GET("community/v3/user-content/url.json?api-key=YZydy5EILKWlG4wF6TqYQWG9EOSI1I4N&offset=0&")
        Call<CommentFeed> getComments(@Query("url") String url);
}
