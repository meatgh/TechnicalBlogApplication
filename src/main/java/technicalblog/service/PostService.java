package technicalblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalblog.model.Post;
import technicalblog.repository.PostRepository;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    public PostService() {
        System.out.println("*** PostService ***");
    }

    @Autowired
    private PostRepository repository;
//    @PersistenceUnit(unitName = "techblog") // to tell the JPA - this is a persistence unit that interactcs with the data base, commented this out while doing the Repository video
//    private EntityManagerFactory emf;
    public List<Post> getAllPosts() {

        return repository.getAllPost();
//
//        ArrayList<Post> posts = new ArrayList<>();
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

//        return resultList;
    }

    public Post getOnePost() {

        return repository.getLatestPost();
        // removed all the below code during the Repository video
//        ArrayList<Post> posts = new ArrayList<>();
//
////        Post post1 = new Post();
////        post1.setTitle("This is your Post");
////        post1.setBody("This is your Post. It has some valid content");
////        post1.setDate(new Date());
////        posts.add(post1);
//        Connection connection=null;
//        try{
//            Class.forName("org.postgresql.Driver");
//
//             connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/technicalblog","postgres", "myself");
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("SELECT * FROM thirdtime WHERE ID=4");
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
//
//        return posts;

    }

    public void createPost(Post newPost){
        newPost.setDate(new Date());
        repository.createPost(newPost);
        System.out.println("New Post: "+newPost);
    }

    public Post getPost(Integer postId) {
        return repository.getPost(postId);
    }

    public void updatePost(Post updatedPost) {
        updatedPost.setDate(new Date());
        repository.updatePost(updatedPost);
    }

    public void deletePost(Integer postId) {
        repository.deletePost(postId);
    }


}
