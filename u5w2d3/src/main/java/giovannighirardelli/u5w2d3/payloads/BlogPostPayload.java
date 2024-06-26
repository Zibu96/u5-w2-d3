package giovannighirardelli.u5w2d3.payloads;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BlogPostPayload {
    private String categoria;
    private String cover;
    private String contenuto;
    private int autoreId;

}
