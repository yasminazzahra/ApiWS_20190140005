package tugas.assesmentdua.pws.A.assesmentdua.pws;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACHI
 */

@CrossOrigin
@RestController
@RequestMapping("/datasepatu")
public class DBController {
  @Autowired
  private SepatuRepo sepatu;
 
  @GetMapping("/sepatu")
  public List<Sepatu> getAllsepatu(){
      return sepatu.findAll();
  }
   @GetMapping ("/sepatu/{id}")
    public Sepatu getSepatuById(@PathVariable Long id){
        return sepatu.findById(id).get();
    }
    
    @PostMapping ("/sepatu")
    public Sepatu savesepatuDetails(@RequestBody Sepatu s){
        return sepatu.save(s);
    }
    
    @PutMapping("/sepatu")
    public Sepatu updateOushop(@RequestBody Sepatu s){
        return sepatu.save(s);
    }
    
    @DeleteMapping("/sepatu/{id}")
    public ResponseEntity<HttpStatus> deleteSepatuById(@PathVariable Long id){
        sepatu.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
