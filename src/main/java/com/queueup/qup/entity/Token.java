package com.queueup.qup.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_token", uniqueConstraints = {
        @UniqueConstraint(name = "unique_token_name", columnNames = "name"),
        @UniqueConstraint(name = "unique_token", columnNames = "token")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Token implements Serializable {
    @Id
    @SequenceGenerator(name="token_id_sequence", sequenceName = "token_id_sequence")
    @GeneratedValue(generator = "token_id_sequence", strategy = GenerationType.AUTO)
    private Integer token_id;

    @Column(name = "name", length=25)
    private String name;

    @Column(name = "token", length=25)
    private String token;

}
