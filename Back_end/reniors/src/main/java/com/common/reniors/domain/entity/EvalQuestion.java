package com.common.reniors.domain.entity;

import com.common.reniors.dto.eval.EvalQuestionCreateRequest;
import com.common.reniors.dto.eval.EvalQuestionUpdateRequest;
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
public class EvalQuestion {
    @Id
    @GeneratedValue
    @Column(name = "eval_question_id")
    private Long id;

    @NotNull
    @Column(length = 500)
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eval_id")
    Eval eval;

    @OneToMany(mappedBy = "evalQuestion")
    private List<UserEval> userEvals = new ArrayList<>();

    public EvalQuestion(EvalQuestionCreateRequest evalQuestionCreateRequest, Eval eval) {
        this.contents = evalQuestionCreateRequest.getContents();
        this.eval = eval;
    }

    public void update(EvalQuestionUpdateRequest evalQuestionUpdateRequest) {
        this.contents = evalQuestionUpdateRequest.getContents();
    }
}