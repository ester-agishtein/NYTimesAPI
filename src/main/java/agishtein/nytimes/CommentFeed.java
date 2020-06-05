package agishtein.nytimes;

import java.util.*;

public class CommentFeed {

    String status;
    Results results;

    public ArrayList<String> returnComments() {
        return results.returnComments();
    }

    static class Results {

        ArrayList<Comments> comments;

        private ArrayList<String> returnComments() {
            ArrayList<String> commentArray = new ArrayList<>();
            for(Comments comment : comments){

                commentArray.add(comment.commentBody);
            }
            return commentArray;
        }

        class Comments {
            String commentBody;

        }
    }


}
