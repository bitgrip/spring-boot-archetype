package ${package}.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ${package}.domain.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, UUID>{

}
