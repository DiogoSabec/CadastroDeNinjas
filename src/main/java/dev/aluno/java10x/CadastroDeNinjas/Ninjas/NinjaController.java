package dev.aluno.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Olá Mundo!";
    }

    // CRUD
    // Add ninja (Create)
    @PostMapping("/create")
    public NinjaModel createNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.createNinja(ninja);
    }

    // Show all ninjas (Read)
    @GetMapping("/list")
    public List<NinjaModel> showAllNinjas(){
        return ninjaService.showAllNinjas();
    }

    // Show all ninjas by ID (Read)
    @GetMapping("/list/{id}")
    public NinjaModel showNinjaByID(@PathVariable Long id){
        return ninjaService.showNinjaByID(id);
    }

    // Update Ninja by ID (Update)
    @PutMapping("/updateID")
    public String updateNinja(){
        return "Update Ninja by ID";
    }

    // Delete Ninja (Delete)
    @DeleteMapping("/deleteID")
    public String deleteNinjaByID(){
        return "Delete ninja by ID";
    }

}
