package agishtein.NYTimes;

import java.util.*;
public class CommentFeed {

    String status;
    Results results;

    public ArrayList<String> returnComments(){
        return results.returnComments();
    }
    static class Results{

        ArrayList<Comments> comments;

        private ArrayList<String> returnComments(){
            ArrayList<String> commentArray = new ArrayList<>();
            for(int index = 0; index < comments.size(); index++){
                commentArray.add(comments.get(index).commentBody);
            }
            return commentArray;
        }
    class Comments{
        String commentBody;

        }
    }


}
