package com.fundamentos.repository;

import com.fundamentos.dto.UserDTO;
import com.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //JPQL
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findByUserEmail(String email);

    @Query("SELECT u FROM User u WHERE u.name like %?1%")
    List<User> findAndSort(String name, Sort sort);

    @Query("SELECT new com.fundamentos.dto.UserDTO(u.id, u.name, u.birthDate) " +
            "FROM User u " +
            "WHERE u.birthDate =:parameterFecha AND " +
            "u.email=:parameterEmail")
    Optional<UserDTO> getAllByBirthDateAndEmail(@Param("parameterFecha") LocalDate birthDate,
                                                @Param("parameterEmail") String email);

    //Query Methods
    List<User> findByName(String name);

    Optional<User> findByNameAndEmail(String name, String email);

    List<User> findByNameLike(String name);

    List<User> findByNameOrEmail(String name, String email);

    List<User> findByBirthDateBetween(LocalDate begin, LocalDate end);

    List<User> findByNameLikeOrderByIdDesc(String name);
}
