package agishtein.NYTimes;


import static org.junit.Assert.*;
import org.junit.Test;
import retrofit2.Call;

import javax.xml.stream.events.Comment;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.*;
public class CommentFrameTest {
    String url = "https://www.nytimes.com/2020/05/25/us/politics/coronavirus-red-blue-states.html";
    ArrayList<String> results = new ArrayList<>();
    @Test
    public void getComments(){
        CommentService service = mock(CommentService.class);
        Call<CommentFeed> call = mock(Call.class);
        DisplayCommentController controller = mock(DisplayCommentController.class);
        doReturn(call).when(service).getComments(url);
        CommentFrame frame = new CommentFrame(controller);
        verify(service).getComments(url);
    }

}