import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import javax.inject.Inject;
import java.util.*;

public class ArticleController implements Callback<ArticleFeed>{
    private ArticleService service;

    @Inject
    public ArticleController(ArticleService service){

        this.service = service;
    }
    public void getArticleData(){
        service.getArticles().enqueue(this);
    }

    @Override
    public void onResponse(Call<ArticleFeed> call, Response<ArticleFeed> response) {
        ArticleFeed.Results results = response.body().getFirstArticle();


//        public static boolean openWebpage(URI uri) {
//            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
//            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
//                try {
//                    desktop.browse(uri);
//                    return true;
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//            return false;
//        }
//
//        public static boolean openWebpage(URL url) {
//            try {
//                return openWebpage(url.toURI());
//            } catch (URISyntaxException e) {
//                e.printStackTrace();
//            }
//            return false;
//        }
    }

    @Override
    public void onFailure(Call<ArticleFeed> call, Throwable t) {
        System.out.println("Article Controller failed.");
        t.printStackTrace();
    }
}
