package br.com.fiap.credito.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class AlunoDocument (

        @Id
        val id: String? = null,

        val nome: String

)