package agishtein.NYTimes;

import agishtein.NYTimes.ArticleFeed;
import agishtein.NYTimes.ArticleService;
import agishtein.NYTimes.ArticleServiceFactory;
import org.junit.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.junit.Assert.*;

public class ArticleFeedTest {

    @Test
    public void getFirstArticle() throws IOException {
        ArticleService service = new ArticleServiceFactory().getInstance();
        Response<ArticleFeed> response = service.getArticles().execute();
        assertTrue(response.toString(), response.isSuccessful());
        ArticleFeed feed = response.body();
        System.out.println("First article: " + feed.getFirstArticle().body);
        assertNotNull(feed.getFirstArticle().body);
    }

    @Test
    public void getFiveArticles() throws IOException {
        ArticleService service = new ArticleServiceFactory().getInstance();
        Response<ArticleFeed> response = service.getArticles().execute();
        assertTrue(response.toString(), response.isSuccessful());
        ArticleFeed feed = response.body();
//        System.out.println("First article: " + feed.getFiveArticles().toString());
        assertNotNull(feed.getFiveArticles());
    }
}