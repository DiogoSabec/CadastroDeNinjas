package dev.aluno.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;

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
}
