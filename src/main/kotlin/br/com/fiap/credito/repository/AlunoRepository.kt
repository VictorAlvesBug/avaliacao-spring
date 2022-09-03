package br.com.fiap.credito.repository

import br.com.fiap.credito.document.AlunoDocument
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface AlunoRepository : ReactiveMongoRepository<AlunoDocument, String>