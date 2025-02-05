package dev.aluno.java10x.CadastroDeNinjas.Missoes;

// Controllers are for creating routes to the user.

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mission")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // CRUD
    // Add missao (Create)
    @PostMapping("/create")
    public String createMissao() {
        return "Mission Created";
    }

    // Show all ninjas (Read)
    @GetMapping("/all")
    public List<MissoesModel> showAllMissao(){
        return missoesService.showAllMissao();
    }

    // Show all ninjas by ID (Read)
    @GetMapping("/allID")
    public String showMissaoByID(){
        return "Show all Missions by ID";
    }
    // Update Ninja by ID (Update)
    @PutMapping("/updateID")
    public String updateMissao(){
        return "Update Mission by ID";
    }

    // Delete Ninja (Delete)
    @DeleteMapping("/deleteID")
    public String deleteMissaoByID(){
        return "Delete Mission by ID";
    }

}
