package au.com.telstra.simcardactivator.model.request;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ActivationCreateRequest implements Serializable {
    private String iccid;
    private String customerEmail;
}
