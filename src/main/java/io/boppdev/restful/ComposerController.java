package io.boppdev.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ComposerController {

    @Autowired
    private ComposerRepository composerRepository;

    @GetMapping("/composers")
    public List<Composer> listAll(Model model) {
        List<Composer> composerList = composerRepository.findAll();
        return composerList;
    }

    @PostMapping("/composers")
    public ResponseEntity<Composer> createComposer(@RequestBody Composer composer) {
        try {
            Composer _composer = composerRepository
                    .save(new Composer(composer.getFirstname(), composer.getLastname()));
            return new ResponseEntity<>(_composer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
