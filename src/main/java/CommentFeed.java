import java.util.*;
import com.google.gson.annotations.SerializedName;
public class CommentFeed {
    String status;
    Results results;

    class Results{
        ArrayList<Comments> comments;
    }
    class Comments{
        String commentBody;
    }
}
