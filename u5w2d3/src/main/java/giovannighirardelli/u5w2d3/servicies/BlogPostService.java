package giovannighirardelli.u5w2d3.servicies;

import giovannighirardelli.u5w2d3.entities.BlogPost;
import giovannighirardelli.u5w2d3.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostService {
    private List<BlogPost> blogPostsList = new ArrayList<>();

    public List<BlogPost> getBlogPostsList(){
        return this.blogPostsList;
    }

    public BlogPost saveBlogPost(BlogPost body){
        Random rndm = new Random();
        body.setId(rndm.nextInt(1, 5000));
        this.blogPostsList.add(body);
        return body;
    }

    public BlogPost findById(int id){
        BlogPost found= null;
        for (BlogPost blogPost: this.blogPostsList){
            if (blogPost.getId() == id) found = blogPost;
        }
        if (found == null) throw new NotFoundException(id);
            else return found;

    }

    public BlogPost findByIdAndUpdate(int id, BlogPost updatedBlogPost){
        BlogPost found= null;
        for (BlogPost blogPost: this.blogPostsList){
            if (blogPost.getId() == id) found = blogPost;
            found.setCategoria(updatedBlogPost.getCategoria());
            found.setContenuto(updatedBlogPost.getContenuto());
            found.setCover(updatedBlogPost.getCover());
            found.setTempoLettura(updatedBlogPost.getTempoLettura());
        }
        if (found == null) throw new NotFoundException(id);
        else return found;

    }
    public void findByIdAndDelete(int id){
        Iterator<BlogPost> iterator = this.blogPostsList.iterator();

        while (iterator.hasNext()){
            BlogPost current = iterator.next();
            if (current.getId() == id){
                iterator.remove();
            }
        }
    }
}
