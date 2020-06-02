package agishtein.NYTimes;

import javax.swing.*;
import java.awt.*;
import java.util.*;
public class Frame extends JFrame{

    JPanel articles;
    JPanel articleInfo;
    JLabel articleName;
    JLabel articleSumm;
    JButton urlButton;
    JButton viewComments;

    public Frame( ArticleService articleService) {
        setSize(1000, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("NYTimes API");
        setLayout(new GridLayout(1,2));
        articles = new JPanel();
        //buttons
        articles.setLayout(new GridLayout(5,1));
        articleInfo = new JPanel();
        articleInfo.setLayout(new GridLayout(5,1));
        urlButton = new JButton("Article link.");
        articleName = new JLabel("Article Name: ");
        articleSumm = new JLabel("Article Abstract: ");
        ArrayList<JButton> buttonsArray = new ArrayList<>();

        viewComments = new JButton("Click to view comments: ");
        //create buttons array
        for(int index = 0; index<5; index++){
            JButton button = new JButton();
            buttonsArray.add(button);
        }

        //fill in buttons
        ArticleController articleController = new ArticleController(articleService,buttonsArray,urlButton,articleName,articleSumm,  viewComments);
        articleController.getArticleData();

        //display buttons in frame
        for(int index = 0; index < buttonsArray.size(); index++)
        {
            articles.add(buttonsArray.get(index));
        }

        //display article data
        articleInfo.add(articleName);
        articleInfo.add(articleSumm);
        articleInfo.add(urlButton);
        articleInfo.add(viewComments);

        add(articles);
        add(articleInfo);

    }

    public static void main(String[] args)
    {
        ArticleService articleService = new ArticleServiceFactory().getInstance();


        new Frame(articleService).setVisible(true);
    }
}
