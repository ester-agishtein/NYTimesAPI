package agishtein.nytimes;
import javax.swing.*;
import java.awt.*;

public class CommentFrame extends JFrame{
    private JLabel comment;
    private JButton next;
    private JButton prev;

 //put into controller
    public CommentFrame(DisplayCommentController controller){
        setSize(800, 900);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setTitle("Comments");
        setLayout(new GridLayout(1,3));
        comment = new JLabel();
        next = new JButton("Next >");
        prev = new JButton("< Previous");
        this.setController(controller, comment, next, prev);
        add(prev);
        add(comment);
        add(next);

    }
    public void setController(DisplayCommentController controller, JLabel comment, JButton next, JButton prev ){
        controller.setComment(comment,next,prev);
    }
}
