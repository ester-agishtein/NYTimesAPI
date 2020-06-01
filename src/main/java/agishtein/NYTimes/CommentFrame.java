package agishtein.NYTimes;
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class CommentFrame extends JFrame{

    private JLabel comment;
    private JButton next;
    private JButton prev;
    int index = 0;

    public CommentFrame(ArrayList<String> results){
        setSize(800, 900);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setTitle("Comments");
        System.out.println("results in commentFrame = " + results);
        setLayout(new GridLayout(1,3));
        next = new JButton("Next >");
        comment = new JLabel("Comments ");
        prev = new JButton("< Previous");

        if(results.size() == 0)
        {
            comment.setText("This article has no comments.");
            add(comment);
        }
        else {
            String commentString = "<html><p>" + results.get(index) + "</p></html>";
            comment.setText(commentString);
            add(comment);
            add(next);
        }

        next.addActionListener(action -> {

            if (index < results.size())
            {
                index += 1;
                String commentString = "<html><p>" + results.get(index) + "</p></html>";
                comment.setText(commentString);
                this.updateFrame(comment, next, prev);
            }
            else {
                comment.setText("There are no more comments.");
                add(comment);
            }
        });

        prev.addActionListener(action -> {
            if(index > 0)
            {
                index -= 1;
                String commentString = "<html><p>" + results.get(index) + "</p></html>";
                comment.setText(commentString);
                this.updateFrame(comment, next, prev);
            }
            else {
                comment.setText("Please hit next to view the comments.");
                add(comment);
            }
        });

    }
    private void updateFrame(JLabel comment, JButton next, JButton prev){
        add(prev);
        add(comment);
        add(next);
    }

}
