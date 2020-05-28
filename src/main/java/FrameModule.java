import com.google.inject.AbstractModule;
import com.google.inject.Provides;
public class FrameModule  extends AbstractModule{
    @Provides
    static ArticleService providesArticleService() {
        return new ArticleServiceFactory().getInstance();
    }
    @Provides
    static CommentService providesCommentService() {
        return new CommentServiceFactory().getInstance();
    }
}
