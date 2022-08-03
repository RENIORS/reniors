package com.common.jmark.domain.entity;

import com.common.jmark.dto.CompanyDto;
import com.common.jmark.dto.EvalDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Eval {
    @Id
    @GeneratedValue
    @Column(name = "eval_id")
    private Long id;

    @NotNull
    @Column(length = 50)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    Company company;

    @OneToMany(mappedBy = "eval")
    private List<EvalQuestion> evalQuestions = new ArrayList<>();

    public Eval(EvalDto evalDto, Company company) {
        this.id = evalDto.getId();
        this.name = evalDto.getName();
        this.company = company;
    }

    public void update(EvalDto evalDto, Company company) {
        this.name = evalDto.getName();
        this.company = company;
    }
}
