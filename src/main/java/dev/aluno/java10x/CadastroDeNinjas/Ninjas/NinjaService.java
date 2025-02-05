package dev.aluno.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // List all ninjas
    public List<NinjaModel> showAllNinjas(){
        return ninjaRepository.findAll();
    }

    // List Ninja by ID
    public NinjaModel showNinjaByID(Long id){
        Optional<NinjaModel> ninjaById = ninjaRepository.findById(id);
        return ninjaById.orElse(null);
    }

    // Create new Ninja
    public NinjaModel createNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    // Delete ninja by ID, must be a VOID
    public void deleteNinjaByID(Long id){
        ninjaRepository.deleteById(id);
    }


}
