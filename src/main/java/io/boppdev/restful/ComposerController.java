package io.boppdev.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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

    @GetMapping("/composers/{id}")
    public ResponseEntity<String> findOneComposer(@PathVariable("id") Integer id) {
        try {
            Composer _composer = composerRepository.getReferenceById(id);
            return new ResponseEntity<>(_composer.getFullName(), HttpStatus.FOUND);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
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

    @PutMapping("/composers/{id}")
    public ResponseEntity<Composer> findAndUpdateOneComposer(
            @PathVariable("id") Integer id,
            @RequestParam("firstname") String firstname
    ) {
        System.out.println(id);
        System.out.println(firstname);
        try {
            Composer _composer = composerRepository.findById(id).get().setFirstname(firstname);
            composerRepository.save(_composer);
            return new ResponseEntity<>(_composer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
