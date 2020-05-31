package agishtein.NYTimes;

import javax.swing.*;
import java.awt.*;
import java.util.*;
public class Frame extends JFrame{

    JPanel articles;
    JPanel articleInfo;
    JPanel commentPanel;
    JLabel urlLabel;
    JLabel articleName;
    JLabel articleSumm;
    JButton urlButton;
    JButton viewComments;

    public Frame( ) {
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("NYTimes API");
        setLayout(new GridLayout(5,2));
        articles = new JPanel();
        articles.setLayout(new GridLayout(5,1));
        articleInfo = new JPanel();
        articleInfo.setLayout(new GridLayout(5,1));
        urlButton = new JButton("Article link.");
        articleName = new JLabel("Article Name: ");
        articleSumm = new JLabel("Article Abstract: ");
        ArrayList<JButton> buttonsArray = new ArrayList<>();
        commentPanel = new JPanel();
        viewComments = new JButton("Click to view comments: ");
        //create buttons array
        for(int index = 0; index<5; index++){
            JButton button = new JButton();
            buttonsArray.add(button);
        }

        //fill in buttons
        ArticleService articleService = new ArticleServiceFactory().getInstance();
        ArticleController articleController = new ArticleController(articleService,buttonsArray,urlButton,articleName,articleSumm, commentPanel, viewComments);
        articleController.getArticleData();

        //display buttons in frame
        for(int index = 0; index < buttonsArray.size(); index++)
        {
            articles.add(buttonsArray.get(index));
        }

        //display article data
        urlLabel = new JLabel();
        urlLabel.setText("URL: ");
        articleInfo.add(articleName);
        articleInfo.add(articleSumm);
        articleInfo.add(urlLabel);
        articleInfo.add(urlButton);
        articleInfo.add(viewComments);
        commentPanel.removeAll();
        add(articles);
        add(articleInfo);
        add(commentPanel);
    }

    public static void main(String[] args) {
        new Frame().setVisible(true);
    }
}
