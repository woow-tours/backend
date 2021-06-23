package com.woow.tours.adapter.controller.DTO;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
@Builder
public class ResponseDTO {

    private Page page;
    private Object content;
    
}
