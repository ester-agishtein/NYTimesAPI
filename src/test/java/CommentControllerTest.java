import org.junit.Test;
import static org.junit.Assert.*;
import retrofit2.Call;
import retrofit2.Response;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
public class CommentControllerTest {

    @Test
    public void getCommentsData() {

        CommentService service = mock(CommentService.class);
        Call<CommentFeed> call = mock(Call.class);
        String mockUrl = "https://www.nytimes.com/2020/05/25/us/politics/coronavirus-red-blue-states.html";
        doReturn(call).when(service).getComments(mockUrl);
        CommentController controller = new CommentController(service, mockUrl);
        controller.getCommentsData();
        verify(call).enqueue(controller);
    }

    @Test
    public void onResponse() {
        CommentService service = mock(CommentService.class);
        String mockUrl = "https://www.nytimes.com/2020/05/25/us/politics/coronavirus-red-blue-states.html";
        CommentController controller = new CommentController(service, mockUrl);

        Call<CommentFeed> call = mock(Call.class);
        Response<CommentFeed> response = mock(Response.class);

        CommentFeed feed = mock(CommentFeed.class);
        ArrayList<String> comments = new ArrayList<>();
        doReturn(comments).when(feed).returnComments();
        doReturn(feed).when(response).body();
        controller.onResponse(call,response);

    }
}