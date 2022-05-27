package sn.aicha.pacientspring.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sn.aicha.pacientspring.dao.PacientRepository;
import sn.aicha.pacientspring.entities.Patient;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
private PacientRepository PacientRepository;

    @GetMapping(path = "/index")
    public String patients(Model model){
        List<Patient> patients = PacientRepository.findAll();
        model.addAttribute("listePatients",patients);
        return "patients";
    }
    @GetMapping(path = "/formPatient")
    public String formPatient(Model model){
        model.addAttribute("patient", new Patient());
        return "formPatient";
    }
    @PostMapping(path = "/save")
    public String save(Model model, Patient patient ){

        PacientRepository.save(patient);
        return "redirect:/index";
    }

    @GetMapping(path = "/updatePatient")
    public String updatePatient(Model model, Long id ){
        Patient patient= PacientRepository.findById(id).orElse(null);
        if (patient==null) throw new RuntimeException("patient non trouve");
        model.addAttribute("patient" ,patient);
        return "updatePatient";
    }
    @GetMapping(path = "/delete")
    public String delete(long id){
        PacientRepository.deleteById(id);
        return "redirect:/index";
    }

}
