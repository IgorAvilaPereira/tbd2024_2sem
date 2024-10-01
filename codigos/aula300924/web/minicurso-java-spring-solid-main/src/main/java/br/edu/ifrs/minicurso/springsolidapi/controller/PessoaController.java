/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifrs.minicurso.springsolidapi.controller;

import br.edu.ifrs.minicurso.springsolidapi.model.Pessoa;
import br.edu.ifrs.minicurso.springsolidapi.repository.PessoaRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public ResponseEntity<List<Pessoa>> getAll() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        return ResponseEntity.ok().body(pessoas);
    }

    @GetMapping("/html")
    public ModelAndView getAllHtml() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        Map<String, Object> template = new HashMap<String, Object>();
        template.put("vet", pessoas);
        return new ModelAndView("index", template);
    }

}