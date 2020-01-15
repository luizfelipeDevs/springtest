package com.tsunami.sitetsunami.resources;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsunami.sitetsunami.repository.ClienteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.tsunami.sitetsunami.models.Cliente;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Cadastro")//Nome da aplicação comentario
@CrossOrigin(origins="*")//Os dominios que podem acessar minha api.No caso todos.

public class ClienteResource {
	
	@Autowired //Metódo para chamar as interfaces com os metodos criados no repository
	ClienteRepository clienteRepository;
	
	@GetMapping("/cliente")
	@ApiOperation(value="Retorna uma lista de clientes")//Metodo para explicar o que o metodo faz.
	public List<Cliente> listaClientes(){
		return clienteRepository.findAll();
	}
	
	@GetMapping("/cliente/{id}")
	@ApiOperation(value="Retorna unico clientes")
	public Cliente listaClientesUnico(@PathVariable(value="id") long id ){
		return clienteRepository.findById(id);
	}
	
	@PostMapping("/cliente")
	@ApiOperation(value="Cadastra um  clientes")
	public Cliente cadastarCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@DeleteMapping("/cliente")
	@ApiOperation(value="Deleta um cliente passando todas informações via JSON")
	public void deletarCliente(@RequestBody Cliente cliente) {
		 clienteRepository.delete(cliente);
	}
	
	@DeleteMapping("/cliente/{id}")
	@ApiOperation(value="Deleta um cliente pelo id")
	public void deletarClienteUnico(@PathVariable(value="id") long id) {
		 clienteRepository.deleteById(id);
	}
	
	@PutMapping("/cliente")
	@ApiOperation(value="Atualiza um cliente")
	public Cliente atualizarCliente(@RequestBody Cliente cliente) {
		 return clienteRepository.save(cliente);
	}
	
	
	
}
