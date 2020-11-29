package br.com.asw.si.oauth;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Controller
public class CepController {

	RestTemplate restTemplate;
	private String endpoint = "https://viacep.com.br/ws/";
	
	@GetMapping(path="/consultaCep/{cep}")
	public ResponseEntity<EnderecoApi> consultaCep(@PathVariable String cep) {
		restTemplate = new RestTemplate();
		final EnderecoApi responseBody = restTemplate.getForObject(
				endpoint + cep + "/json", EnderecoApi.class);
		return ResponseEntity.ok().body(responseBody);
	}
}
