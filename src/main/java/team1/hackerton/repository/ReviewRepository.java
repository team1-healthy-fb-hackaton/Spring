package team1.hackerton.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import team1.hackerton.domain.Item;
import team1.hackerton.domain.Member;
import team1.hackerton.domain.Review;
import team1.hackerton.domain.enums.Rate;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByItemOrderByCreatedAtDesc(Item item);

    @Query("SELECT COUNT(r) FROM Review r WHERE r.item = :item AND r.tag1 =:tag1")
    int findCountTag1(@Param(value = "item") Item item, @Param(value = "tag1") Boolean tag1);
    @Query("SELECT COUNT(r) FROM Review r WHERE r.item = :item AND r.tag2 =:tag2")
    int findCountTab2(@Param(value = "item") Item item, @Param(value = "tag2") Boolean tag2);

    @Query("SELECT COUNT(r) FROM Review r WHERE r.item = :item AND r.rate = :rate")
    int findRateCnt(@Param(value = "item") Item item, @Param(value = "rate") Rate rate);

    List<Review> findByMember(Member member);



}
