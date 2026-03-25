package dev.aluno.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
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
    public NinjaDTO createNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = new NinjaMapper.map(ninjaDTO);
        ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    // Delete ninja by ID, must be a VOID
    public void deleteNinjaByID(Long id){
        ninjaRepository.deleteById(id);
    }

    // Update ninja
    public NinjaModel updateNinja(Long id, NinjaModel updatedNinja){
        if (ninjaRepository.existsById(id)){
            updatedNinja.setId(id);
            return ninjaRepository.save(updatedNinja);
        } else {
            return null;
        }
    }


}
