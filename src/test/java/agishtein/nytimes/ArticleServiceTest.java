package agishtein.nytimes;

import org.junit.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.junit.Assert.*;

public class ArticleServiceTest {

    @Test
    public void getArticles() throws IOException {
        ArticleService service = new ArticleServiceFactory().getInstance();
        Response<ArticleFeed> response = service.getArticles().execute();
        assertTrue(response.toString(), response.isSuccessful());
        ArticleFeed feed = response.body();
        assertNotNull(feed);
        assertNotNull(feed.numResults);
        assertNotNull(feed.results.get(0).url);
        assertNotNull(feed.results.get(0).publishedDate);
        assertNotNull(feed.results.get(0).title);
        for(int index = 0; index < feed.results.size(); index++){
            assertNotNull(feed.results.get(index).body);
        }

    }
}