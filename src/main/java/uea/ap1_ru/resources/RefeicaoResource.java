package uea.ap1_ru.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uea.ap1_ru.models.Refeicao;
import uea.ap1_ru.services.RefeicaoService;

@RestController
@RequestMapping("/refeicoes")
public class RefeicaoResource {
	@Autowired
	private RefeicaoService refeicaoService;
	
	@PostMapping
	public ResponseEntity<Refeicao> criar(@RequestBody Refeicao refeicao){
		Refeicao novaRefeicao = refeicaoService.criar(refeicao);
		return ResponseEntity.ok().body(novaRefeicao);
	}
	
	@DeleteMapping(value = "/{codigo}")
	public ResponseEntity<Refeicao> deletar(@PathVariable Long codigo){
		refeicaoService.deletar(codigo);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Refeicao>> listar(){
		List<Refeicao> refeicoes = refeicaoService.listar();
		return ResponseEntity.ok().body(refeicoes);
	}
}
