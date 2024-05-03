package team1.hackerton.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team1.hackerton.domain.Item;
import team1.hackerton.domain.Member;
import team1.hackerton.domain.MemberItem;

import java.util.List;

@Repository
public interface MemberItemRepository extends JpaRepository<MemberItem, Long> {

    MemberItem findByMemberAndItem(Member member, Item item);
}
