package team1.hackerton.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team1.hackerton.domain.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
