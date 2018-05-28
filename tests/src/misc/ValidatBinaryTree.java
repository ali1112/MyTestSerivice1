package misc;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by msharafat on 4/22/17.
 */
/*public class ValidatBinaryTree {

    String [] tree ;

    public void validateTree(String s){

        List<Tupple> tupples = getTupples(s);
        HashMap<String , Integer> map = new HashMap<>();


    }


    public void insertNode(Tupple tupple, HashMap<String , Integer> map){

//        if(tree == null){
//            tree = new ArrayList<String>();
//            tree.add(tupple.getParent());
//        }
    }


    public List<Tupple> getTupples(String s){

        String [] tokens = s.split("\\)\\(");
        List<Tupple> tupples = new ArrayList<Tupple>();

        for(int i = 0 ; i < tokens.length ; i ++){
            String token = tokens[i];
            token = token.replace("\\)", "").replace("\\(", "");
            String [] nodes = token.split(" ");
            Tupple tupple = new Tupple(nodes[0], nodes[1]);
            tupples.add(tupple);

        }


    }
    private class Tupple{
        String parent;
        String child;

        public Tupple(String parent, String child){
            this.child = child;
            this.parent = parent;
        }

        public String getParent(){
            return this.parent;
        }

        public String getChild(){
            return this.child;
        }
    }
}*/
