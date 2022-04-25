package ukim.finki.mk.lab2emt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ukim.finki.mk.lab2emt.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{
}
