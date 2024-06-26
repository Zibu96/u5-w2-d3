package giovannighirardelli.u5w2d3.servicies;

import giovannighirardelli.u5w2d3.entities.Autore;
import giovannighirardelli.u5w2d3.entities.BlogPost;
import giovannighirardelli.u5w2d3.exceptions.NotFoundException;
import giovannighirardelli.u5w2d3.payloads.BlogPostPayload;
import giovannighirardelli.u5w2d3.repositories.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Random;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;
    @Autowired
    private AutoreService autoreService;


    public Page<BlogPost> getBlogPosts(int pageNumber, int pageSize, String sortBy){
        if (pageSize > 20) pageSize = 20;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        return blogPostRepository.findAll(pageable);
    }

    public BlogPost saveBlogPost(BlogPostPayload body){
        Autore autore = autoreService.findById(body.getAutoreId());

        BlogPost blogPost = new BlogPost(body.getCategoria(), "cover", body.getContenuto(), body.getTempoLettura(), autore);

        return this.blogPostRepository.save(blogPost);
    }

    public BlogPost findById(int id){

     return this.blogPostRepository.findById(id).orElseThrow(() -> new NotFoundException(id));

    }

    public BlogPost findByIdAndUpdate(int id, BlogPost updatedBlogPost){
      BlogPost found = this.blogPostRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
            found.setCategoria(updatedBlogPost.getCategoria());
            found.setContenuto(updatedBlogPost.getContenuto());
            found.setCover(updatedBlogPost.getCover());
            found.setTempoLettura(updatedBlogPost.getTempoLettura());

       return this.blogPostRepository.save(found);

    }
    public void findByIdAndDelete(int id){

        BlogPost found = this.findById(id);
        this.blogPostRepository.delete(found);
        }

}
