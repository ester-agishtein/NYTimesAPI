package agishtein.nytimes;

import org.junit.Test;
import retrofit2.Call;

import static org.mockito.Mockito.*;

public class MainFrameTest {
    @Test
    public void getArticles() {
        ArticleService service = mock(ArticleService.class);
        Call<ArticleFeed> call = mock(Call.class);
        doReturn(call).when(service).getArticles();
        MainFrame frame = new MainFrame(service);
        verify(service).getArticles();
    }
}