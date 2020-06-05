package agishtein.nytimes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.*;

public class CommentController implements Callback<CommentFeed> {
    private CommentService service;
    private String url;


    public CommentController(CommentService service, String url) {
        this.service = service;
        this.url = url;
    }

    public void getCommentsData() {
        service.getComments(this.url).enqueue(this);
    }

    @Override
    public void onResponse(Call<CommentFeed> call, Response<CommentFeed> response) {
        if (response.body() == null) {
            return;
        } else {
            ArrayList<String> results = response.body().returnComments();
            DisplayCommentController controller = new DisplayCommentController(results);
            new CommentFrame(controller).setVisible(true);
        }
    }


    @Override
    public void onFailure(Call<CommentFeed> call, Throwable t) {
        t.printStackTrace();
    }
}


