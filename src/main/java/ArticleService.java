import retrofit2.Call;
import retrofit2.http.*;

public interface ArticleService {
    @GET("https://api.nytimes.com/svc/mostpopular/v2/viewed/1.json?api-key=YZydy5EILKWlG4wF6TqYQWG9EOSI1I4N")
    Call<ArticleFeed> getArticles();
}
