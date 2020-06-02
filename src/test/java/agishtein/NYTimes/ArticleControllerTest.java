package agishtein.NYTimes;

import agishtein.NYTimes.ArticleController;
import agishtein.NYTimes.ArticleFeed;
import agishtein.NYTimes.ArticleService;
import org.junit.Test;

import retrofit2.Call;
import retrofit2.Response;

import javax.swing.*;
import java.util.*;
import static org.mockito.Mockito.*;

public class ArticleControllerTest {

     ArrayList<JButton> buttonsArray = mock(ArrayList.class);
     JButton urlButton = mock(JButton.class);
     JLabel articleName = mock(JLabel.class);
     JLabel articleSumm = mock(JLabel.class);
     JButton viewComments = mock(JButton.class);

    @Test
    public void getArticleData() {
        ArticleService service = mock(ArticleService.class);
        Call<ArticleFeed> call = mock(Call.class);
        doReturn(call).when(service).getArticles();
        ArticleController controller = new ArticleController(service, buttonsArray, urlButton, articleName, articleSumm, viewComments);
        controller.getArticleData();
        verify(call).enqueue(controller);
    }

    @Test
    public void onResponse() {
        ArticleService service = mock(ArticleService.class);
        ArticleController controller = new ArticleController(service, buttonsArray, urlButton, articleName, articleSumm, viewComments);
        Call<ArticleFeed> call = mock(Call.class);
        Response<ArticleFeed> response = mock(Response.class);
        ArticleFeed feed = mock(ArticleFeed.class);
        HashMap<String,String> hmap = mock(HashMap.class);
        doReturn(hmap).when(feed).getFiveArticles();
        doReturn(feed).when(response).body();
        controller.onResponse(call,response);

    }

}