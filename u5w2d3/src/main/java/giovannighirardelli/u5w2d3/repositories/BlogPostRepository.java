package giovannighirardelli.u5w2d3.repositories;

import giovannighirardelli.u5w2d3.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Integer> {
}