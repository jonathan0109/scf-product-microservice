package mx.unnamed.scf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.unnamed.scf.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
