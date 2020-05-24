import org.junit.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.junit.Assert.*;

public class ArticleServiceTest {

    @Test
    public void getArticles() throws IOException {
        ArticleService service = new ArticleServiceFactory().getInstance();
        Response<ArticleFeed> response = service.getArticles().execute();
        System.out.println("Article response = " + response);
        assertTrue(response.toString(), response.isSuccessful());
        ArticleFeed feed = response.body();
//        System.out.println("feed.numRes = " + feed.numResults);
//        System.out.println("url = " + feed.results.get(0).url);
//        System.out.println("published = " + feed.results.get(0).publishedDate);
//        System.out.println("title = " + feed.results.get(0).title);
//        System.out.println("body = " + feed.results.get(0).body);
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