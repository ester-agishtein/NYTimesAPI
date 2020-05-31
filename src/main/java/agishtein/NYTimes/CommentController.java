package agishtein.NYTimes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import javax.swing.*;
import java.util.*;

public class CommentController implements Callback<CommentFeed>{
    private CommentService service;
    private String url;
    private JPanel commentPanel;
    private JLabel comment;
    private JButton next;
    private JButton prev;
    int index = 0;

    public CommentController(CommentService service, String url, JPanel commentPanel){
        this.service = service;
        this.url = url;
        this.commentPanel = commentPanel;
    }
    public void getCommentsData(){
        service.getComments(this.url).enqueue(this);
    }
    @Override
    public void onResponse(Call<CommentFeed> call, Response<CommentFeed> response) {
//        assert response.body() != null;
        System.out.println("in commment controller: " + response.body().returnComments());
        ArrayList<String> results = response.body().returnComments();

        next = new JButton("Next");
        comment = new JLabel("Comment: ");
        prev = new JButton("Previous");
        if(results.size() == 0)
        {
            comment.setText("This article has no comments.");
            commentPanel.add(comment);
        }
        else {
            commentPanel.add(comment);
            commentPanel.add(next);
        }

        next.addActionListener(action -> {

            if (index < results.size())
            {
                index += 1;
                comment.setText("Comment: " + results.get(index));
                this.updateFrame(comment, next, prev);
            }
            else {
                comment.setText("There are no more comments.");
                commentPanel.add(comment);
            }
        });

        prev.addActionListener(action -> {
            if(index > 0)
            {
                index -= 1;
                comment.setText("Comment: " + results.get(index));
                this.updateFrame(comment, next, prev);
            }
            else {
                comment.setText("Please hit next to view the comments.");
                commentPanel.add(comment);
            }
        });

        }

    private void updateFrame(JLabel comment, JButton next, JButton prev){
        commentPanel.add(next);
        commentPanel.add(comment);
        commentPanel.add(prev);
    }
    @Override
    public void onFailure(Call<CommentFeed> call, Throwable t) {
        t.printStackTrace();
    }
}
