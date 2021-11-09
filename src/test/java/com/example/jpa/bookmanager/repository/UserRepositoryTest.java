package com.example.jpa.bookmanager.repository;

import com.example.jpa.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

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

//        userRepository.save(new User("david", "david@test.com"));
//        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
//        user.setEmail("david-update@test.com");
//        userRepository.save(user);
    }
}