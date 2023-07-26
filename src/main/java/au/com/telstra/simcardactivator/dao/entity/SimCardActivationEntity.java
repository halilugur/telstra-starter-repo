package au.com.telstra.simcardactivator.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Builder
@ToString
@Table(name = "sim_card_activations")
@NoArgsConstructor
@AllArgsConstructor
public class SimCardActivationEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String iccid;
    private String customerEmail;
    private Boolean active;
}
