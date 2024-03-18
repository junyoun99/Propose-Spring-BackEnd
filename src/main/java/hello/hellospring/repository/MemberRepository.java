package hello.hellospring.repository;

import hello.hellospring.controller.AddPoint;
import hello.hellospring.controller.CheckPoint;
import hello.hellospring.controller.CreatePoint;
import hello.hellospring.controller.DateCheck;
import hello.hellospring.domain.Member;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member) throws SQLException;
    Optional<Member> findById(String id);
    Optional<Member> findByLogin(String id, String pass);

    DateCheck checkDate(String id) throws SQLException;

    CheckPoint checkPoint(String id) throws SQLException;

    AddPoint addPoint(String id, String sort, String point) throws SQLException;

    CreatePoint createPoint(String id) throws SQLException;

//    Optional<Member> findByName(String name);
    List<Member> findAll();
}
