package agishtein.NYTimes;

import static org.junit.Assert.*;
import org.junit.Test;
import retrofit2.Call;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FrameTest {
@Test
    public void getArticles(){
    ArticleService service = mock(ArticleService.class);
    Call<ArticleFeed> call = mock(Call.class);
    doReturn(call).when(service).getArticles();
    Frame frame = new Frame(service);
    doReturn(call).when(service).getArticles();
    verify(service).getArticles();
}
}