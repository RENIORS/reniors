package com.common.jmark.dto.JobOpening;

import com.common.jmark.domain.entity.JobOpening;
import com.common.jmark.domain.entity.category.JobChildCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobOpeningCompanyResponse {

    private Long id;
    private String title;
    private String jobChildCategoryName;
    private int applies;

    public static JobOpeningCompanyResponse response(JobOpening jobOpening){
        return new JobOpeningCompanyResponse(
                jobOpening.getId(),
                jobOpening.getTitle(),
                jobOpening.getJobChildCategory().getName(),
                jobOpening.getApplies().size()
        );
    }
}