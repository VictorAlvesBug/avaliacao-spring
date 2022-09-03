package br.com.fiap.credito.service

import br.com.fiap.credito.document.AlunoDocument
import br.com.fiap.credito.dto.AlunoDTO
import br.com.fiap.credito.dto.CreateUpdateAlunoDTO
import br.com.fiap.credito.repository.AlunoRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class AlunoServiceImpl (
    val alunoRepository: AlunoRepository
) : AlunoService {
    override fun create(createUpdateAlunoDTO: CreateUpdateAlunoDTO) = Mono.just(createUpdateAlunoDTO)
            .map { AlunoDocument(nome = it.nome) }
            .flatMap { alunoRepository.save(it) }
            .map { AlunoDTO(id = it.id ?: throw Exception(), nome = it.nome) }

    override fun update(idToUpdate: String, createUpdateAlunoDTO: CreateUpdateAlunoDTO) = Mono.just(createUpdateAlunoDTO)
            .map { AlunoDocument(id = idToUpdate, nome = createUpdateAlunoDTO.nome) }
            .flatMap { alunoRepository.save(it) }
            .map { AlunoDTO(id = it.id ?: throw Exception(), nome = it.nome) }

    override fun list() = alunoRepository.findAll()
            .map { AlunoDTO(id = it.id ?: throw Exception(), nome = it.nome) }

    override fun delete(idToDelete: String) {
        alunoRepository.deleteById(idToDelete)
    }
}