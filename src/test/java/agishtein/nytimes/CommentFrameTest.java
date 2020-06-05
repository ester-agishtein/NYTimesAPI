package agishtein.nytimes;


import org.junit.Test;
import retrofit2.Call;

import javax.swing.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.*;
public class CommentFrameTest {
    String url = "https://www.nytimes.com/2020/05/25/us/politics/coronavirus-red-blue-states.html";
    ArrayList<String> results = new ArrayList<>();
    @Test
    public void getComments(){
        //Ensures the results array is passed to the displayCommentController
        CommentService service = mock(CommentService.class);
        Call<CommentFeed> call = mock(Call.class);
        doReturn(call).when(service).getComments(url);
        CommentController controller = mock(CommentController.class);
        DisplayCommentController displayCommentController = new DisplayCommentController(results);
        CommentFrame frame = new CommentFrame(displayCommentController);
        frame.setController(displayCommentController, new JLabel(), new JButton(), new JButton());
        assertNotNull(displayCommentController.getResults(results));
    }

}