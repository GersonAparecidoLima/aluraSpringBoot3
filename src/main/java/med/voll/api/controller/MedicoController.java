package med.voll.api.controller;

import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;      // IMPORT QUE FALTAVA
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault; // Dica extra abaixo

import med.voll.api.medico.DadosAtualizacaoMedico;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;

//Paginação
// http://localhost:8080/medicos?size=1&page=0

//Ordenação
//http://localhost:8080/medicos?sort=nome
//Por padrão, a ordenação acontece de maneira crescente. Mas é possível inverter isso, ordenando por ordem decrescente. Para isso, basta adicionar ,desc à URL.
//http://localhost8080/medicos?sort=crm,desc&size=2&page=1

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired 
    private MedicoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemMedico::new);
    }
    //lista(@PageableDefault(size = 10, sort = {"nome"})
    //o novo padrão será a exibição de 10 resultados por página, ordenados a partir do nome.
    
    /*
     *@PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosCadastroMedico dados) {

    }
     * */
    
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosAtualizacaoMedico dados) {
    	var medico  = repository.getReferenceById(dados.id());
    	medico.atualizarInformacoes(dados);
    }
    
    //Para levar o ID, Vamos abrir parênteses e aspas após e anotação e passar o complemento da URL. 
    //Para que seja um parâmetro dinâmico, passaremos ("/{id}")
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
    	repository.deleteById(id);    	
    }
    
}