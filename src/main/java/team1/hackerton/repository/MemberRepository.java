package team1.hackerton.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team1.hackerton.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
