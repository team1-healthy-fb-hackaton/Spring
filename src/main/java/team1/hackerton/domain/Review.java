package team1.hackerton.domain;

import jakarta.persistence.*;
import lombok.*;
import team1.hackerton.domain.common.BaseEntity;
import team1.hackerton.domain.enums.Rate;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @Column(name = "review_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String content;

    private Rate rate;

    private boolean tag1;

    private boolean tag2;

    public Review(Item item, Member member, String content, Rate rate, boolean tag1, boolean tag2) {
        this.item = item;
        this.member = member;
        this.content = content;
        this.rate = rate;
        this.tag1 = tag1;
        this.tag2 = tag2;
    }
}
