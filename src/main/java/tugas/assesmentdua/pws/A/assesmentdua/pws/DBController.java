package tugas.assesmentdua.pws.A.assesmentdua.pws;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ACHI
 */

@Controller
public class DBController {
   @CrossOrigin
    @GetMapping(value="/xml/datasepatu", produces ={
        MediaType.APPLICATION_XML_VALUE
        }
    )
    @ResponseBody
    public List<Sepatu> getSepatu(){
    
        List<Sepatu> spt = new ArrayList<>();
        
        SepatuJpaController controller = new SepatuJpaController();
        
        try {
            spt = controller.findSepatuEntities();
        }catch (Exception e) {}
        
        return spt;
    }
}
