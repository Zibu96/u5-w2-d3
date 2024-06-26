package giovannighirardelli.u5w2d3.servicies;

import giovannighirardelli.u5w2d3.entities.Autore;
import giovannighirardelli.u5w2d3.exceptions.NotFoundException;
import giovannighirardelli.u5w2d3.repositories.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class AutoreService {

    @Autowired
    private AutoreRepository autoreRepository;

    private List<Autore> autoreList = new ArrayList<>();

    public List<Autore> getAutoreList() {
        return this.autoreList;
    }

    public Autore saveAutore(Autore body) {
        Random rndm = new Random();
        body.setId(rndm.nextInt(1, 5000));
        body.setAvatar("https://ui-avatars.com/api/?name=" + body.getNome() + "+" + body.getCognome());
        this.autoreList.add(body);
        return body;

    }


    public Autore findById(int id) {
        Autore found = null;
        for (Autore autore : this.autoreList) {
            if (autore.getId() == id) found = autore;
        }
        if (found == null) throw new NotFoundException(id);
        else return found;
    }

    public Autore findByIdAndUpdate(int id, Autore updatedAutore) {
        Autore found = null;
        for (Autore autore : this.autoreList) {
            if (autore.getId() == id) { found = autore;
                found.setNome(updatedAutore.getNome());
                found.setCognome(updatedAutore.getCognome());
                found.setEmail(updatedAutore.getEmail());
                found.setDataNascita(updatedAutore.getDataNascita());
                found.setAvatar("https://ui-avatars.com/api/?name=" + updatedAutore.getNome() + "+" + updatedAutore.getCognome());
            }
        }
        if (found == null) throw new NotFoundException(id);
        else return found;
    }

    public void findByIdAndDelete(int id) {
        Iterator<Autore> iterator = this.autoreList.iterator();

        while (iterator.hasNext()) {
            Autore current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }


    }
}

