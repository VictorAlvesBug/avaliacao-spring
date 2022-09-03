package br.com.fiap.credito.service

import br.com.fiap.credito.dto.AlunoDTO
import br.com.fiap.credito.dto.CreateUpdateAlunoDTO
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface AlunoService {
    fun create(createUpdateAlunoDTO: CreateUpdateAlunoDTO): Mono<AlunoDTO>
    fun update(idToUpdate: String, createUpdateAlunoDTO: CreateUpdateAlunoDTO): Mono<AlunoDTO>
    fun list(): Flux<AlunoDTO>
    fun delete(idToDelete: String)
}