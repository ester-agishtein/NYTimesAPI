package agishtein.NYTimes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DisplayCommentController implements Callback<CommentFeed>{
    private ArrayList<String> results;
    int index = 0;

    public DisplayCommentController(ArrayList<String> results){
        this.results = results;
    }

    public void testCheck(){return;}
    @Override
    public void onResponse(Call<CommentFeed> call, Response<CommentFeed> response) {
        return;
    }
    @Override
    public void onFailure(Call<CommentFeed> call, Throwable t) {
        t.printStackTrace();
    }

    public void setComment(JLabel comment, JButton next, JButton prev) {
        if (results.size() == 0) {
            comment.setText("This article has no comments.");
        } else {
            String commentString = "<html><p>" + results.get(index) + "</p></html>";
            comment.setText(commentString);
        }

        next.addActionListener(action -> {
            if (index < results.size()) {
                index += 1;
                String commentString = "<html><p>" + results.get(index) + "</p></html>";
                comment.setText(commentString);
            } else {
                comment.setText("There are no more comments.");
            }
        });

        prev.addActionListener(action -> {
            if (index > 0) {
                index -= 1;
                String commentString = "<html><p>" + results.get(index) + "</p></html>";
                comment.setText(commentString);

            } else {
                comment.setText("Please hit next to view the comments.");

            }
        });
    }
}


