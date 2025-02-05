package dev.aluno.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {
    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // List all ninjas
    public List<MissoesModel> showAllMissao(){
        return missoesRepository.findAll();
    }

    public MissoesModel showMissaoByID(Long id){
        Optional<MissoesModel> missoesById = missoesRepository.findById(id);
        return missoesById.orElse(null);
    }

    public MissoesModel createMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }

}
