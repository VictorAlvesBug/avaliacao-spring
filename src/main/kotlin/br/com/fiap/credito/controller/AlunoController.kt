package br.com.fiap.credito.controller

import br.com.fiap.credito.dto.CreateUpdateAlunoDTO
import br.com.fiap.credito.service.AlunoService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("alunos")
class AlunoController (
    val alunoService: AlunoService
) {

    @GetMapping(produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun list() = alunoService.list()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody createUpdateAlunoDTO: CreateUpdateAlunoDTO) =
            alunoService.create(createUpdateAlunoDTO)

    @PutMapping("{id}")
    fun update(@PathVariable id: String, @RequestBody createUpdateAlunoDTO: CreateUpdateAlunoDTO) =
            alunoService.update(id, createUpdateAlunoDTO)

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) =
            alunoService.delete(id)

}