package com.goormthonuniv.hoseo.hochi.global.util;

import com.goormthonuniv.hoseo.hochi.global.entity.TimeRecordedEntity;
import com.goormthonuniv.hoseo.hochi.global.exception.NotFoundExceptionInterface;
import com.goormthonuniv.hoseo.hochi.global.util.exception.ParamNullPointedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 전역적으로 CRUD 작업을 단순화하고 표준화하기 위한 유틸리티 클래스.
 * (Business Service 혹은 Facade는 복잡한 로직 처리, CRUD Service는 단순 DB 조작만 담당)
 * JPA에서 제공하는 기본 CRUD 예외 자동처리
 */
@Slf4j
public class GlobalCrudUtil {

    /**
     * 1개의 필드 기반 조회 (예 : id)
     */
    public static <T, P> T findByField(Function<P, Optional<T>> finderFunction, P parameter, Supplier<? extends NotFoundExceptionInterface> exceptionSupplier) {
        validateParam(parameter);
        return finderFunction.apply(parameter)
                .orElseThrow(exceptionSupplier);
    }

    /**
     * 2개의 필드 기반 조회 (예: email + nickname)
     */
    public static <T, P1, P2> T findByTwoFields(BiFunction<P1, P2, Optional<T>> finderFunction, P1 param1, P2 param2, Supplier<? extends NotFoundExceptionInterface> exceptionSupplier) {
        validateParam(param1);
        validateParam(param2);
        return finderFunction.apply(param1, param2)
                .orElseThrow(exceptionSupplier);
    }

    /**
     * 엔티티를 저장한다.
     * (별도 검증 없이 단순 저장만 수행)
     */
    public static <T> T entitySave(CrudRepository<T, ?> repository, T entity) {
        return repository.save(entity);
    }

    /**
     * 주어진 ID가 존재하는지 확인한다.
     * (ID가 null일 경우 예외 발생)
     */
    /**
     * 필드 기반으로 엔티티 존재 여부를 확인한다.
     * 존재하면 true, 없으면 false 반환.
     */
    public static <T, P> boolean entityExistsByField(Function<P, Optional<T>> finderFunction, P parameter) {
        validateParam(parameter);
        return finderFunction.apply(parameter).isPresent();
    }

    /**
     * 필드 기반으로 엔티티를 삭제한다.
     * 존재하지 않으면 제공된 예외를 발생시킨다.
     * TimeRecordedEntity를 상속하는 경우 soft delete 처리한다.
     */
    public static <T, P> void deleteByField(Function<P, Optional<T>> finderFunction, P parameter, Supplier<? extends NotFoundExceptionInterface> exceptionSupplier, CrudRepository<T, ?> repository) {
        validateParam(parameter);

        T entity = finderFunction.apply(parameter)
                .orElseThrow(exceptionSupplier);

        if (entity instanceof TimeRecordedEntity deletableEntity) {
            deletableEntity.markDeleted();
            repository.save(entity); // soft delete
        } else {
            repository.delete(entity); // 하드 delete
        }
    }


    /**
     * 모든 엔티티를 조회한다.
     */
    public static <T> Iterable<T> findAll(CrudRepository<T, ?> repository) {
        return repository.findAll();
    }

    /**
     * ID가 null인지 검증한다.
     * null일 경우 예외를 발생시킨다.
     */
    private static <ID> void validateParam(ID id) {
        if (id == null) {
            throw new ParamNullPointedException("Param은 null이 될 수 없습니다.");
        }
    }

}
