package au.com.telstra.simcardactivator.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class SimCardActivationDto {
    private Long id;
    private String iccid;
    private String customerEmail;
    private Boolean active;
}
