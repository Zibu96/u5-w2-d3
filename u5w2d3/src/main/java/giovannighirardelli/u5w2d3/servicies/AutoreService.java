package giovannighirardelli.u5w2d3.servicies;

import giovannighirardelli.u5w2d3.entities.Autore;
import giovannighirardelli.u5w2d3.exceptions.BadRequestException;
import giovannighirardelli.u5w2d3.exceptions.NotFoundException;
import giovannighirardelli.u5w2d3.repositories.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class AutoreService {

    @Autowired
    private AutoreRepository autoreRepository;



    public Page<Autore> getAutore(int pageNumber, int pageSize, String sortBy){
        if (pageSize > 20) pageSize = 20;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        return autoreRepository.findAll(pageable);
    }

    public Autore saveAutore(Autore body) {
        if (this.autoreRepository.existsByNomeAndCognome(body.getNome(), body.getCognome())) throw new BadRequestException("L'autore " + body.getNome() + " esiste già");
        body.setAvatar("https://ui-avatars.com/api/?name=" + body.getNome() + "+" + body.getCognome());

        return this.autoreRepository.save(body);

    }


    public Autore findById(int id) {
       return this.autoreRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Autore findByIdAndUpdate(int id, Autore updatedAutore) {
        Autore found = this.findById(id);

        found.setNome(updatedAutore.getNome());
        found.setCognome(updatedAutore.getCognome());
        found.setEmail(updatedAutore.getEmail());
        found.setDataNascita(updatedAutore.getDataNascita());
        found.setAvatar("https://ui-avatars.com/api/?name=" + updatedAutore.getNome() + "+" + updatedAutore.getCognome());

        return this.autoreRepository.save(updatedAutore);

    }

    public void findByIdAndDelete(int id) {
       Autore found = this.findById(id);
       this.autoreRepository.delete(found);

    }
}

