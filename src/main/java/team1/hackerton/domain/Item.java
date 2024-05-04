package team1.hackerton.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;
import team1.hackerton.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Builder
@Setter
@NoArgsConstructor
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

    private int zeroSugar;

    private int zeroKcal;


    public Item(int likeCnt, int price, int zeroKcal, int zeroSugar, Category category, String company) {
        super();
        this.likeCnt = likeCnt;
        this.price = price;
        this.zeroKcal = zeroKcal;
        this.zeroSugar = zeroSugar;
        this.category = category;
        this.company = company;
    }
}
