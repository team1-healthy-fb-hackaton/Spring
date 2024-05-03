package team1.hackerton.domain;

import jakarta.persistence.*;
import lombok.*;
import team1.hackerton.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Item extends BaseEntity {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    private String name;

    private int price;

    private String url;

    private String company;

    private String store;

    private String nutritionUrl;

    private String materials;

    private int likeCnt;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<Gradient> gradientList = new ArrayList<>();

    private String infoUrl;

    private boolean zeroSugar;

    private boolean zeroKcal;

}
