package agishtein.NYTimes;

import agishtein.NYTimes.ArticleController;
import agishtein.NYTimes.ArticleFeed;
import agishtein.NYTimes.ArticleService;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import retrofit2.Call;
import retrofit2.Response;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import static org.mockito.Mockito.*;

public class ArticleControllerTest {
    @SuppressWarnings( "unchecked" )
     ArrayList<JButton> buttonsArray = mock(ArrayList.class);
     JButton urlButton = mock(JButton.class);
     JLabel articleName = mock(JLabel.class);
     JLabel articleSumm = mock(JLabel.class);
     JPanel commentPanel = mock(JPanel.class);
     JButton viewComments = mock(JButton.class);
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void getArticleData() {
        ArticleService service = mock(ArticleService.class);
        Call<ArticleFeed> call = mock(Call.class);
        doReturn(call).when(service).getArticles();
        ArticleController controller = new ArticleController(service, buttonsArray, urlButton, articleName, articleSumm, commentPanel, viewComments);
        controller.getArticleData();
        verify(call).enqueue(controller);
    }

    @Test
    public void onResponse() {
        ArticleService service = mock(ArticleService.class);

        ArticleController controller = new ArticleController(service, buttonsArray, urlButton, articleName, articleSumm, commentPanel, viewComments);

        Call<ArticleFeed> call = mock(Call.class);
        Response<ArticleFeed> response = mock(Response.class);

        ArticleFeed.Results results = new ArticleFeed.Results();
        ArticleFeed feed = mock(ArticleFeed.class);
        HashMap<String, String> hmap = new HashMap<>();
        doReturn(hmap).when(feed).getFiveArticles();
        doReturn(results).when(feed).getFirstArticle();
        doReturn(feed).when(response).body();
        controller.onResponse(call,response);

    }

}