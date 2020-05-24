import org.junit.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.junit.Assert.*;

public class CommentServiceTest {

    @Test
    public void getComments()  throws IOException  {

            CommentService service = new CommentServiceFactory().getInstance();
//            System.out.println("service = " + service);
            // when
            Response<CommentFeed> response = service.getComments("https://www.nytimes.com/2020/05/18/health/coronavirus-vaccine-moderna.html").execute();

            // then
//            System.out.println("response.toString() = " + response.toString());

            assertTrue(response.toString(), response.isSuccessful());
            CommentFeed feed = response.body();
//            System.out.println("Status  = " + feed.status);
//            System.out.println("results.callerID = " + feed.results.callerID);
//            System.out.println("commentBody = " + feed.results.comments.get(0).commentBody);

            assertNotNull(feed);
            assertNotNull(feed.status);

            for(int index = 0; index < feed.results.comments.size(); index++){
                assertNotNull(feed.results.comments.get(index).commentBody);
            }

    }


}