package ma.enset.hopitale.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.enset.hopitale.entities.Patient;
import ma.enset.hopitale.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientControler {
    private PatientRepository patientRepository;
    @GetMapping("/index")
    public String index(Model model, @RequestParam(name="page",defaultValue = "0")int p,
                                     @RequestParam(name="size",defaultValue = "4") int s,
                                     @RequestParam(name="keyword",defaultValue = "")String Kw)
    {
        Page<Patient>pagePatients=patientRepository.findByNomContains(Kw,PageRequest.of(p,s));
        model.addAttribute("listPatients",pagePatients.getContent());
        model.addAttribute("pages",new int [pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",p);
        model.addAttribute("keyword",Kw);
        return "patients";
    }
    @GetMapping("/delete")
    public String delete(Long id,String keyword,int page){
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/formPatients")
    public String formPatients(Model model){
        model.addAttribute("patient",new Patient());
        return "formPatients";

    }
    @PostMapping ("/save")
    public String save(Model model, @Valid Patient patient, BindingResult bindingResult,@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String keyword){
        if(bindingResult.hasErrors()) return "formpatients";
        patientRepository.save(patient);
        return "redirect:/index?page="+page+"&keyword="+keyword;

    }
    @GetMapping("/editpatients")
    public String editPatients(Model model,Long id ,String keyword,int page){
        Patient patient=patientRepository.findById(id).orElse(null);
        if(patient==null) throw new RuntimeException("Patient introuvable");
        model.addAttribute("patient",patient );
        model.addAttribute("page",page);
        model.addAttribute("keyword",keyword);

        return "editpatients";

    }
}
