package au.com.telstra.simcardactivator.mapper;

import au.com.telstra.simcardactivator.dao.entity.SimCardActivationEntity;
import au.com.telstra.simcardactivator.model.dto.SimCardActivationDto;
import au.com.telstra.simcardactivator.model.request.ActivationCreateRequest;
import au.com.telstra.simcardactivator.model.response.ActivatorResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimCardActivationMapper {
    public static SimCardActivationDto toDto(SimCardActivationEntity entity) {
        return SimCardActivationDto.builder()
                .id(entity.getId())
                .iccid(entity.getIccid())
                .customerEmail(entity.getCustomerEmail())
                .active(entity.getActive())
                .build();
    }

    public static SimCardActivationEntity toDto(ActivationCreateRequest request, ActivatorResponse response) {
        return SimCardActivationEntity.builder()
                .iccid(request.getIccid())
                .customerEmail(request.getCustomerEmail())
                .active(response.getSuccess())
                .build();
    }
}
