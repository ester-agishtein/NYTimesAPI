package agishtein.NYTimes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.swing.*;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URI;
import java.util.*;

public class ArticleController implements Callback<ArticleFeed>{

    private HashMap<String,String> articleUrlMap;
    private ArrayList<JButton> buttonsArray;
    private ArticleService service;
    private JButton urlButton;
    private JLabel articleName;
    private JLabel articleSumm;
    private JButton viewComments;

    public ArticleController(ArticleService service, ArrayList<JButton> buttonsArray, JButton urlButton, JLabel articleName, JLabel articleSumm,  JButton viewComments){
        this.service = service;
        this.buttonsArray = buttonsArray;
        this.urlButton =  urlButton;
        this.articleName = articleName;
        this.articleSumm = articleSumm;
        this.viewComments = viewComments;
    }

    public void getArticleData(){
        service.getArticles().enqueue(this);
    }

    @Override
    public void onResponse(Call<ArticleFeed> call, Response<ArticleFeed> response) {
        System.out.println("call = " + call);
        System.out.println("response = " + response);
        System.out.println("response.body() "+response.body());
        if(response.body() == null) System.out.println("null");
        System.out.println("response.body " + response.body().getFiveArticles());
        if(response.body() != null) {
            this.articleUrlMap = response.body().getFiveArticles();
            HashMap<String, String> titlesAbstracts = response.body().getTitleAbstract();
            Iterator hmIterator = articleUrlMap.entrySet().iterator();
            while (hmIterator.hasNext()) {
                for (int index = 0; index < buttonsArray.size(); index++) {
                    Map.Entry mapElement = (Map.Entry) hmIterator.next();
                    buttonsArray.get(index).setText((String) mapElement.getKey());

                    int finalIndex = index;
                    buttonsArray.get(index).addActionListener(action -> {
                        urlButton.setText((String) mapElement.getValue());
                        articleName.setText("Article Name: " + (String) mapElement.getKey());
                        articleSumm.setText("Article Abstract: " + titlesAbstracts.get((String) mapElement.getKey()));
                    });
                }
            }
            viewComments.addActionListener(event -> {

                CommentService commentService = new CommentServiceFactory().getInstance();
                CommentController commentController = new CommentController(commentService, urlButton.getText());
                commentController.getCommentsData();
            });

            urlButton.addActionListener(actionEvent -> {

                    try {
                        URL url = new URL(urlButton.getText());
                        openWebpage(url);

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                }
            });

        }
    }

    @Override
    public void onFailure(Call<ArticleFeed> call, Throwable t) {
        System.out.println("Article Controller failed.");
        t.printStackTrace();
    }

    public static boolean openWebpage(URI uri) {
//        System.out.println("uri = " + uri);
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean openWebpage(URL url) {
        try {
            return openWebpage(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return false;
    }
}
