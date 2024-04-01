package ma.enset.hopitale.web;

import lombok.AllArgsConstructor;
import ma.enset.hopitale.entities.Patient;
import ma.enset.hopitale.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientControler {
    private PatientRepository patientRepository;
    @GetMapping("/index")
    public String index(Model model, @RequestParam(name="page",defaultValue = "0")int page,
                                     @RequestParam(name="size",defaultValue = "4") int size){
        Page<Patient>pagepatients=patientRepository.findAll(PageRequest.of(page,size));
        model.addAttribute("listePatients",pagepatients.getContent());
        model.addAttribute("page",new int [pagepatients.getTotalPages()]);

        return "patients";
    }
}
