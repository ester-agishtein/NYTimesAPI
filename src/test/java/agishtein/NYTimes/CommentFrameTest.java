package agishtein.NYTimes;


import static org.junit.Assert.*;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;

import javax.swing.*;
import javax.xml.stream.events.Comment;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.*;
public class CommentFrameTest {
    String url = "https://www.nytimes.com/2020/05/25/us/politics/coronavirus-red-blue-states.html";
    ArrayList<String> results = new ArrayList<>();
    @Test
    public void getComments(){
        //this test dose not work.
        CommentService service = mock(CommentService.class);
        Call<CommentFeed> call = mock(Call.class);
        doReturn(call).when(service).getComments(url);
        DisplayCommentController controller = mock(DisplayCommentController.class);
        CommentFrame frame = new CommentFrame(controller);
//        verify(controller).testCheck();
    }

}