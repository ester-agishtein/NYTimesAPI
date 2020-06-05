package agishtein.nytimes;

import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;

import javax.swing.*;

import static org.mockito.Mockito.*;
import java.util.*;
public class DisplayCommentControllerTest {

    @Test
    public void onResponse() {
        ArrayList<String> results = mock(ArrayList.class);
        Call<CommentFeed> call = mock(Call.class);
        Response<CommentFeed> response = mock(Response.class);
        CommentFeed feed = mock(CommentFeed.class);
        DisplayCommentController controller = new DisplayCommentController(results);
        controller.onResponse(call,response);

    }

    @Test
    public void setComment() {
        ArrayList<String> results = mock(ArrayList.class);
        JLabel comment = mock(JLabel.class);
        JButton next = mock(JButton.class);
        JButton prev = mock(JButton.class);
        DisplayCommentController controller = mock(DisplayCommentController.class);
        controller.setComment(comment,next,prev);
        verify(controller).setComment(comment,next,prev);
    }
}