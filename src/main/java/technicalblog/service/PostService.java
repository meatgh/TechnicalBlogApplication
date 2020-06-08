package technicalblog.service;

import org.springframework.stereotype.Service;
import technicalblog.model.Post;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    public PostService() {
        System.out.println("*** PostService ***");
    }

    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory emf;
    public List<Post> getAllPosts() {


//
        ArrayList<Post> posts = new ArrayList<>();
//
//        Post post1 = new Post();
//        post1.setTitle("Post 1");
//        post1.setBody("Post Body 1");
//        post1.setDate(new Date());
//
//        Post post2 = new Post();
//        post2.setTitle("Post 2");
//        post2.setBody("Post Body 2");
//        post2.setDate(new Date());
//
//        Post post3 = new Post();
//        post3.setTitle("Post 3");
//        post3.setBody("Post Body 3");
//        post3.setDate(new Date());
//
//        posts.add(post1);
//        posts.add(post2);
//        posts.add(post3);

        EntityManager em = emf.createEntityManager();
        TypedQuery<Post> query = em.createQuery("SELECT p from Post p", Post.class);
        List<Post> resultList = query.getResultList();

//        Connection connection=null;
//        try{
//            Class.forName("org.postgresql.Driver");
//
//            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/technicalblog","postgres", "myself");
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("SELECT * FROM thirdtime");
//            while(rs.next()){
//                Post post = new Post();
//                post.setTitle(rs.getString("title"));
//                post.setBody(rs.getString("body"));
//                posts.add(post);
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }finally{
//            try{
//                connection.close();
//            }catch(SQLException e){
//                e.printStackTrace();
//            }
//        }

        return resultList;
    }

    public ArrayList<Post> getOnePost() {
        ArrayList<Post> posts = new ArrayList<>();

//        Post post1 = new Post();
//        post1.setTitle("This is your Post");
//        post1.setBody("This is your Post. It has some valid content");
//        post1.setDate(new Date());
//        posts.add(post1);
        Connection connection=null;
        try{
            Class.forName("org.postgresql.Driver");

             connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/technicalblog","postgres", "myself");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM thirdtime WHERE ID=4");
            while(rs.next()){
                Post post = new Post();
                post.setTitle(rs.getString("title"));
                post.setBody(rs.getString("body"));
                posts.add(post);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally{
            try{
                connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }

        return posts;

    }

    public void createPost(Post newPost){

    }


}
