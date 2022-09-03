package br.com.fiap.credito.config

import br.com.fiap.credito.repository.AlunoRepository
import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.convert.MappingMongoConverter
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@Configuration
@EnableReactiveMongoRepositories(basePackageClasses = [AlunoRepository::class])
class MongoConfig : AbstractReactiveMongoConfiguration() {

   override fun getDatabaseName() = "mongoDatabase"

   override fun reactiveMongoClient(): MongoClient = mongoClient()

   @Bean
   fun mongoClient(): MongoClient = MongoClients.create()

 override fun reactiveMongoTemplate(
         databaseFactory: ReactiveMongoDatabaseFactory,
         mongoConverter: MappingMongoConverter) =
       ReactiveMongoTemplate(mongoClient(), databaseName)
}