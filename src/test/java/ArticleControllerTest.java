import org.junit.Test;
import static org.junit.Assert.*;
import retrofit2.Call;
import retrofit2.Response;
import static org.mockito.Mockito.*;

public class ArticleControllerTest {

    @Test
    public void getArticleData() {
        ArticleService service = mock(ArticleService.class);
        Call<ArticleFeed> call = mock(Call.class);
        doReturn(call).when(service).getArticles();
        ArticleController controller = new ArticleController(service);
        controller.getArticleData();
        verify(call).enqueue(controller);
    }

    @Test
    public void onResponse() {
        ArticleService service = mock(ArticleService.class);
        ArticleController controller = new ArticleController(service);

        Call<ArticleFeed> call = mock(Call.class);
        Response<ArticleFeed> response = mock(Response.class);

        ArticleFeed.Results results = new ArticleFeed.Results();
        ArticleFeed feed = mock(ArticleFeed.class);

        doReturn(results).when(feed).getFirstArticle();
        doReturn(feed).when(response).body();
        controller.onResponse(call,response);

    }

}