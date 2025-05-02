package com.goormthonuniv.hoseo.hochi.global.util;

import com.goormthonuniv.hoseo.hochi.global.entity.TimeRecordedEntity;
import com.goormthonuniv.hoseo.hochi.global.exception.NotFoundExceptionInterface;
import com.goormthonuniv.hoseo.hochi.global.util.exception.ParamNullPointedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.List;

/**
 * 전역적으로 CRUD 작업을 단순화하고 표준화하기 위한 유틸리티 클래스.
 * - CRUD Service는 이 유틸을 기반으로 DB에 대한 단순 조작만 수행합니다.
 * - Business Service나 Facade 계층은 이 유틸을 통해 엔티티 접근을 일관되게 수행할 수 있습니다.
 *
 * ✅ 공통 특징
 * - Optional 처리 생략 가능
 * - 예외 던지기 자동화
 * - soft delete 자동 처리
 */
@Slf4j
public class GlobalCrudUtil {

    /**
     * ✅ 단일 필드 기반 단건 조회
     * ex) userRepository.findById(id)
     *
     * @param finderFunction Optional<T>을 반환하는 함수 (ex: repo::findById)
     * @param parameter 조회할 파라미터
     * @param exceptionSupplier 값이 없을 경우 던질 예외
     * @return 조회된 엔티티
     */
    public static <T, P> T findByField(Function<P, Optional<T>> finderFunction, P parameter, Supplier<? extends NotFoundExceptionInterface> exceptionSupplier) {
        validateParam(parameter);
        return finderFunction.apply(parameter)
                .orElseThrow(exceptionSupplier);
    }

    /**
     * ✅ 2개의 필드 기반 단건 조회
     * ex) userRepository.findByEmailAndNickname(email, nickname)
     */
    public static <T, P1, P2> T findByTwoFields(BiFunction<P1, P2, Optional<T>> finderFunction, P1 param1, P2 param2, Supplier<? extends NotFoundExceptionInterface> exceptionSupplier) {
        validateParam(param1);
        validateParam(param2);
        return finderFunction.apply(param1, param2)
                .orElseThrow(exceptionSupplier);
    }

    /**
     * ✅ 단일 필드 기반 다건 조회
     * ex) userFavoritePlaceRepository.findByUserId(userId)
     *
     * @throws NotFoundExceptionInterface 리스트가 null 또는 비어있을 경우
     */
    public static <T, P> List<T> findListByOneField(Function<P, List<T>> finderFunction, P parameter, Supplier<? extends NotFoundExceptionInterface> exceptionSupplier) {
        validateParam(parameter);
        List<T> result = finderFunction.apply(parameter);
        if (result == null || result.isEmpty()) {
            throw exceptionSupplier.get();
        }
        return result;
    }

    /**
     * ✅ 2개의 필드 기반 다건 조회
     * ex) userFavoritePlaceRepository.findByUserIdAndCategory(userId, category)
     */
    public static <T, P1, P2> List<T> findListByTwoFields(BiFunction<P1, P2, List<T>> finderFunction, P1 param1, P2 param2, Supplier<? extends NotFoundExceptionInterface> exceptionSupplier) {
        validateParam(param1);
        validateParam(param2);
        List<T> result = finderFunction.apply(param1, param2);
        if (result == null || result.isEmpty()) {
            throw exceptionSupplier.get();
        }
        return result;
    }

    /**
     * ✅ 저장 (단순 저장 + 제약 조건 예외 처리)
     * ex) userRepository.save(user)
     *
     * @throws RuntimeException (ex: 이메일 중복, 제약 조건 위반 등)
     */
    public static <T> T saveEntity(CrudRepository<T, ?> repository, T entity, Supplier<? extends RuntimeException> exceptionSupplier) {
        try {
            return repository.save(entity);
        } catch (DataIntegrityViolationException e) {
            throw exceptionSupplier.get();
        }
    }

    /**
     * ✅ 존재 여부 확인 (단일 필드)
     * Optional 반환 함수로 존재 여부만 판단
     */
    public static <T, P> boolean entityExistsByField(Function<P, Optional<T>> finderFunction, P parameter) {
        validateParam(parameter);
        return finderFunction.apply(parameter).isPresent();
    }

    /**
     * ✅ 단일 필드 기반 삭제 (soft/hard delete 자동 감지)
     * - soft delete가 필요한 엔티티는 TimeRecordedEntity 상속
     * - 아니면 그냥 delete(entity)
     *
     * @throws NotFoundExceptionInterface: 삭제할 대상이 없을 때
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
     * ✅ 전체 조회 (주의: 대용량 시 비추천)
     */
    public static <T> Iterable<T> findAll(CrudRepository<T, ?> repository) {
        return repository.findAll();
    }

    /**
     * ✅ 내부 파라미터 null 방지 체크
     * null이면 예외 던짐
     */
    private static <ID> void validateParam(ID id) {
        if (id == null) {
            throw new ParamNullPointedException("Param은 null이 될 수 없습니다.");
        }
    }

}

