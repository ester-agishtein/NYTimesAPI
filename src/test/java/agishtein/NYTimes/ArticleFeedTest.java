package agishtein.NYTimes;

import agishtein.NYTimes.ArticleFeed;
import agishtein.NYTimes.ArticleService;
import agishtein.NYTimes.ArticleServiceFactory;
import org.junit.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.junit.Assert.*;

public class ArticleFeedTest {

    public ArticleFeed setUp() throws IOException {
        ArticleService service = new ArticleServiceFactory().getInstance();
        Response<ArticleFeed> response = service.getArticles().execute();
        assertTrue(response.toString(), response.isSuccessful());
        ArticleFeed feed = response.body();
        return feed;
    }

    @Test
    public void getFirstArticle() throws IOException {
        ArticleFeed feed = this.setUp();
        assertNotNull(feed.getFirstArticle().body);
    }

    @Test
    public void getFiveArticles() throws IOException {
        ArticleFeed feed = this.setUp();
        assertNotNull(feed.getFiveArticles());
    }

    @Test
    public void getTitleAbstract() throws IOException{
        ArticleFeed feed = this.setUp();
        assertNotNull(feed.getTitleAbstract());
    }
}