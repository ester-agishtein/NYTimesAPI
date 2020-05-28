import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import javax.inject.Inject;
import java.util.*;
public class CommentController implements Callback<CommentFeed>{
    private CommentService service;
    private String url;
    @Inject
    public CommentController(CommentService service, String url){
        this.service = service;
        this.url = url;
    }
    public void getCommentsData(){
        service.getComments(this.url).enqueue(this);
    }
    @Override
    public void onResponse(Call<CommentFeed> call, Response<CommentFeed> response) {
        ArrayList<String> results = response.body().returnComments();
        System.out.println("Comments url = " + this.url);
    }

    @Override
    public void onFailure(Call<CommentFeed> call, Throwable t) {
        t.printStackTrace();

    }


}
