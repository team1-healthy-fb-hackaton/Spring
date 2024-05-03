package team1.hackerton.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team1.hackerton.domain.Gradient;
import team1.hackerton.domain.Item;

import java.util.List;

@Repository
public interface GradientRepository extends JpaRepository<Gradient, Long> {

    List<Gradient> findByItem(Item item);
}
