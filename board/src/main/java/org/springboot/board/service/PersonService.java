package org.springboot.board.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springboot.board.domain.Person;
import org.springboot.board.domain.QAddress;
import org.springboot.board.domain.QPerson;
import org.springboot.board.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final JPAQueryFactory queryFactory;

    @Transactional
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Transactional(readOnly = true)
    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Transactional
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Person> findPersonsLivingInCity(String city) {
        QPerson person = QPerson.person;
        QAddress address = QAddress.address;

        BooleanExpression inCity = JPAExpressions.selectOne()
                .from(address)
                .where(address.city.eq(city)
                        .and(address.person.id.eq(person.id)))
                .exists();

        return queryFactory.selectFrom(person)
                .where(inCity)
                .fetch();
    }

}
