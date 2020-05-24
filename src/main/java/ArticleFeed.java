import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
public class ArticleFeed {
    String status;
    @SerializedName("num_results")
    String numResults;
    ArrayList<Results> results;

    class Results {
        String url;
        @SerializedName("published_date")
        String publishedDate;
        String title;
        @SerializedName("abstract")
        String body;
    }
}
