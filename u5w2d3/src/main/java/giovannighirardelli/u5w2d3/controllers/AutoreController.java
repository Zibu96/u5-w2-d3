package giovannighirardelli.u5w2d3.controllers;

import giovannighirardelli.u5w2d3.entities.Autore;
import giovannighirardelli.u5w2d3.servicies.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autore")
public class AutoreController {
    @Autowired
    private AutoreService autoreService;


    @GetMapping
    public Page<Autore> getAutore(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "10") int size,
                                  @RequestParam(defaultValue = "id") String sortBy) {
        return this.autoreService.getAutore(page, size, sortBy);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autore saveAutore(@RequestBody Autore body){
        return this.autoreService.saveAutore(body);
    }

    @GetMapping("/{autoreId}")
    public Autore findById(@PathVariable int autoreId){
        return this.autoreService.findById(autoreId);
    }

    @PutMapping("/{autoreId}")
    public Autore findByIdAndUpdate(@PathVariable int autoreId, @RequestBody Autore body){
        return this.autoreService.findByIdAndUpdate(autoreId, body);

    }

    @DeleteMapping("/{autoreId}")
    public void findByIdAndDelete(@PathVariable int autoreId){
        this.autoreService.findByIdAndDelete(autoreId);
    }


}
