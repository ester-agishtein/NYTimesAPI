import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.*;
import java.util.ArrayList;
public interface ArticleService {
    @GET("https://api.nytimes.com/svc/mostpopular/v2/viewed/1.json?api-key=YZydy5EILKWlG4wF6TqYQWG9EOSI1I4N")
    Call<ArticleFeed> getArticles();
}
