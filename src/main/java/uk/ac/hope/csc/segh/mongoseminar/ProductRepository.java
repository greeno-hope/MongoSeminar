package uk.ac.hope.csc.segh.mongoseminar;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, Long> {
    Optional<Product> findByName(String name);
}