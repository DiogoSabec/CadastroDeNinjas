package dev.aluno.java10x.CadastroDeNinjas.Missoes;

// Controllers are for creating routes to the user.

import dev.aluno.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missions")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // CRUD
    // Add missao (Create)
    @PostMapping("/create")
    public MissoesModel createMissao(@RequestBody MissoesModel missao) {
        return missoesService.createMissao(missao);
    }

    // Show all ninjas (Read)
    @GetMapping("/list")
    public List<MissoesModel> showAllMissao(){
        return missoesService.showAllMissao();
    }

    // Show all ninjas by ID (Read)
    @GetMapping("/list/{id}")
    public MissoesModel showMissaoByID(@PathVariable Long id){
        return missoesService.showMissaoByID(id);
    }
    // Update Ninja by ID (Update)
    @PutMapping("/updateID")
    public String updateMissao(){
        return "Update Mission by ID";
    }

    // Delete Ninja (Delete)
    @DeleteMapping("/delete/{id}")
    public void deleteMissaoByID(@PathVariable Long id){
        missoesService.deleteMissaoByID(id);
    }

}
