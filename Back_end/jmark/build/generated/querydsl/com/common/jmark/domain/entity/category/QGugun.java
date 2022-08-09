package com.common.jmark.domain.entity.category;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGugun is a Querydsl query type for Gugun
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGugun extends EntityPathBase<Gugun> {

    private static final long serialVersionUID = -661950640L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGugun gugun = new QGugun("gugun");

    public final NumberPath<Long> code = createNumber("code", Long.class);

    public final ListPath<com.common.jmark.domain.entity.HopeArea, com.common.jmark.domain.entity.QHopeArea> hopeAreas = this.<com.common.jmark.domain.entity.HopeArea, com.common.jmark.domain.entity.QHopeArea>createList("hopeAreas", com.common.jmark.domain.entity.HopeArea.class, com.common.jmark.domain.entity.QHopeArea.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<com.common.jmark.domain.entity.recommend.RecommendCondition, com.common.jmark.domain.entity.recommend.QRecommendCondition> recommendConditions = this.<com.common.jmark.domain.entity.recommend.RecommendCondition, com.common.jmark.domain.entity.recommend.QRecommendCondition>createList("recommendConditions", com.common.jmark.domain.entity.recommend.RecommendCondition.class, com.common.jmark.domain.entity.recommend.QRecommendCondition.class, PathInits.DIRECT2);

    public final QSido sido;

    public QGugun(String variable) {
        this(Gugun.class, forVariable(variable), INITS);
    }

    public QGugun(Path<? extends Gugun> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGugun(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGugun(PathMetadata metadata, PathInits inits) {
        this(Gugun.class, metadata, inits);
    }

    public QGugun(Class<? extends Gugun> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.sido = inits.isInitialized("sido") ? new QSido(forProperty("sido")) : null;
    }

}

