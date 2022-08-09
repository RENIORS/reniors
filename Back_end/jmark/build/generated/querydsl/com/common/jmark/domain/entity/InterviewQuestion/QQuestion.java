package com.common.jmark.domain.entity.InterviewQuestion;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQuestion is a Querydsl query type for Question
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQuestion extends EntityPathBase<Question> {

    private static final long serialVersionUID = -1908971653L;

    public static final QQuestion question1 = new QQuestion("question1");

    public final ListPath<Answer, QAnswer> answers = this.<Answer, QAnswer>createList("answers", Answer.class, QAnswer.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath question = createString("question");

    public QQuestion(String variable) {
        super(Question.class, forVariable(variable));
    }

    public QQuestion(Path<? extends Question> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQuestion(PathMetadata metadata) {
        super(Question.class, metadata);
    }

}

