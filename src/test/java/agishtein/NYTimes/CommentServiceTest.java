package agishtein.NYTimes;

import agishtein.NYTimes.CommentFeed;
import agishtein.NYTimes.CommentService;
import agishtein.NYTimes.CommentServiceFactory;
import org.junit.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.junit.Assert.*;

public class CommentServiceTest {

    @Test
    public void getComments()  throws IOException  {

            CommentService service = new CommentServiceFactory().getInstance();
            Response<CommentFeed> response = service.getComments("https://www.nytimes.com/2020/05/18/health/coronavirus-vaccine-moderna.html").execute();
            assertTrue(response.toString(), response.isSuccessful());
            CommentFeed feed = response.body();
            assertNotNull(feed);
            assertNotNull(feed.status);

            for(int index = 0; index < feed.results.comments.size(); index++){
                assertNotNull(feed.results.comments.get(index).commentBody);
            }

    }


}