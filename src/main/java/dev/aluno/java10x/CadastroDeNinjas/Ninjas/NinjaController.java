package dev.aluno.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Olá Mundo!";
    }

    // CRUD
    // Add ninja (Create)
    @PostMapping("/create")
    public String createNinja() {
        return "Ninja Created";
    }

    // Show all ninjas (Read)
    @GetMapping("/all")
    public String showAllNinjas(){
        return "Show all ninjas";
    }

    // Show all ninjas by ID (Read)
    @GetMapping("/allID")
    public String showNinjaByID(){
        return "Show all ninjas by ID";
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
