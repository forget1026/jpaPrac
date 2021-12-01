package com.example.jpa.bookmanager.repository;

import com.example.jpa.bookmanager.domain.Gender;
import com.example.jpa.bookmanager.domain.User;
import com.example.jpa.bookmanager.domain.UserHistory;
import org.apache.tomcat.jni.Local;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Test
    void crud() {
//        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
//        users = userRepository.findAllById(Lists.newArrayList(1L, 2L, 5L));
//        users.forEach(System.out::println);
//        User user1 = new User("jack", "jack@test.com");
//        User user2 = new User("steve", "steve@test.com");
//
//        userRepository.saveAll(Lists.newArrayList(user1, user2));
//
//        List<User> users = userRepository.findAll();
//        users.forEach(System.out::println);
        // flush의 경우 DB 저장에서 처리 하는 거라 이후에서 확인
//        userRepository.saveAndFlush(new User("new test", "newTEST@test.com"));
//        userRepository.findAll().forEach(System.out::println);
//        Long count = userRepository.count();
//        System.out.println(count);
//        boolean exist = userRepository.existsById(1L);
//        System.out.println(exist);
//        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));
//        userRepository.deleteById(1L);
//        userRepository.deleteAll(); select 후 삭제
//        userRepository.deleteAllInBatch(); select 없이 바로 지움
//        Page<User> users = userRepository.findAll(PageRequest.of(1, 3));
//        System.out.println(users.getTotalElements());
//        System.out.println(users.getTotalPages());
//        System.out.println(users.getNumberOfElements());
//        System.out.println(users.getSort());
//        System.out.println(users.getSize());
//        users.getContent().forEach(System.out::println);
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withIgnorePaths("name")
//                .withMatcher("email", endsWith());
//        Example<User> example = Example.of(new User("ma", "test.com"), matcher);
//        userRepository.findAll(example).forEach(System.out::println);
//        복잡한 쿼리의 경우 QueryDSL 사용
//        이렇게 만드는 방법도 있다. 이렇게 알면 된다고 함.
//        User user = new User();
//        user.setEmail("nottest");
//        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("email", contains());
//        Example<User> example = Example.of(user, matcher);
//        userRepository.findAll(example).forEach(System.out::println);

        userRepository.save(new User("david", "david@test.com"));
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("david-update@test.com");
        userRepository.save(user);
    }

    @Test
    void select() {
//        System.out.println(userRepository.findByName("denis"));
//
//        System.out.println("findByEmail " + userRepository.findByEmail("test@test.com"));
//        System.out.println("getByEmail " + userRepository.getByEmail("test@test.com"));
//        System.out.println("readByEmail" + userRepository.readByEmail("test@test.com"));
//        System.out.println("queryByEmail" + userRepository.queryByEmail("test@test.com"));
//        System.out.println("searchByEmail" + userRepository.searchByEmail("test@test.com"));
//        System.out.println("streamByEmail" + userRepository.streamByEmail("test@test.com"));
//        System.out.println("findUserByEmail" + userRepository.findUserByEmail("test@test.com"));
//
//        System.out.println("findSomethingByEmail" + userRepository.findSomethingByEmail("test@test.com"));
//
//        System.out.println("findTop1ByName " + userRepository.findTop2ByName("test"));
//        System.out.println("findFirst1ByName " + userRepository.findFirst2ByName("test"));
//        System.out.println("findLast1ByName " + userRepository.findLast1ByName("test"));

        System.out.println("findByEmailAndName " + userRepository.findByEmailAndName("test@test.com", "test"));
        System.out.println("findByEmailOrName " + userRepository.findByEmailOrName("test@test.com", "denis"));

        System.out.println("findByCreatedAtAfter " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1)));
        System.out.println("findByIdAfter  " + userRepository.findByIdAfter(4L));
        System.out.println("findByCreatedAtGreaterThan  " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));

        System.out.println("findByCreatedAtGreaterThanEqual " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByCreatedAtBetween " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));

        System.out.println("findByIdBetween " + userRepository.findByIdBetween(1L, 3L));
        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 2L));

        System.out.println("findByIdIsNotNull" + userRepository.findByIdIsNotNull());

//        System.out.println("findByIdIsNotEmpty" + userRepository.findByAddressIsNotEmpty());

        System.out.println("findByNameIn " + userRepository.findByNameIn(Lists.newArrayList("test", "denis")));

        System.out.println("findByNameStartingWith " + userRepository.findByNameStartingWith("te"));
        System.out.println("findByNameEndingWith " + userRepository.findByNameEndingWith("st"));
        System.out.println("findByNameContains " + userRepository.findByNameContains("es"));

        System.out.println("findByNameLike" + userRepository.findByNameLike("%" + "es" + "%"));
    }

    @Test
    void pagingAndSortingTest() {
        System.out.println("findTop1ByName " + userRepository.findTop1ByName("test"));
        System.out.println("findLast1ByName " + userRepository.findLast1ByName("test"));
        System.out.println("findTop1ByNameOrderByIdDesc " + userRepository.findTop1ByNameOrderByIdDesc("test"));
        System.out.println("findFirstByNameOrderByIdDescEmailAsc " + userRepository.findFirstByNameOrderByIdDescEmailAsc("test"));
        System.out.println("findFirstByNameWithSordParams " + userRepository.findFirstByName("test", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
        System.out.println("findByNameWithPaging " + userRepository.findByName("test", PageRequest.of(1, 1, Sort.by(Sort.Order.desc("id")))).getTotalElements());
    }

    private Sort getSort() {
        return Sort.by(Sort.Order.desc("id"), Sort.Order.desc("email"), Sort.Order.desc("createdAt"), Sort.Order.desc("updatedAt"));
    }

    @Test
    void insertAndUpdateTest() {
        User user = new User();
        user.setName("test");
        user.setEmail("test2@test.com");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("teeeeeeeeeeeeeeeeest");

        userRepository.save(user2);
    }

    @Test
    void enumTest() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setGender(Gender.MALE);

        userRepository.save(user);

        userRepository.findAll().forEach(System.out::println);

        System.out.println(userRepository.findRawRecord().get("gender"));
    }

    @Test
    void listenerTest() {
        User user = new User();
        user.setEmail("test2@test.com");
        user.setName("test");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("teeeeeeeeest");

        userRepository.save(user2);

        userRepository.deleteById(4L);
    }

    @Test
    void prePersistTest() {
        User user = new User();
        user.setEmail("test2@test.com");
        user.setName("test2");

        userRepository.save(user);

        System.out.println(userRepository.findByEmail("test2@test.com"));
    }

    @Test
    void preUpdateTest() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        System.out.println("as-is : " + user);

        user.setName("test2");
        userRepository.save(user);

        System.out.println("to-be : " + userRepository.findAll().get(0));
    }

    @Test
    void userHistoryTest() {
        User user = new User();
        user.setEmail("test-new@test.com");
        user.setName("test-new");

        userRepository.save(user);

        user.setName("test-new-new");

        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);
    }

    @Test
    void userRelationTest() {
        User user = new User();
        user.setName("david");
        user.setEmail("david@test.com");
        user.setGender(Gender.MALE);

        userRepository.save(user);

        user.setName("daniel");;

        userRepository.save(user);

        user.setEmail("daniel@test.com");

        userRepository.save(user);

//        userHistoryRepository.findAll().forEach(System.out::println);

//        List<UserHistory> result = userHistoryRepository.findByUserId(
//                userRepository.findByEmail("daniel@test.com").getId()
//        );

        List<UserHistory> result = userRepository.findByEmail("daniel@test.com").getUserHistories();

        result.forEach(System.out::println);


    }
}