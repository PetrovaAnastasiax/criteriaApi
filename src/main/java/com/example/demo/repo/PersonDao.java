package com.example.demo.repo;

import com.example.demo.dto.UserInfo;
import com.example.demo.model.Dpt;
import com.example.demo.model.Person;
import com.example.demo.model.Person_;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class PersonDao {

    @PersistenceContext
    private EntityManager em;

    public List<Person> findPersonsByNameLikeOrBirthDate(String dateBirth) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> criteria = cb.createQuery(Person.class);
        Root<Person> root = criteria.from(Person.class);

        Date myDate = parseDate(dateBirth);

        Predicate young = cb.greaterThan(root.get("birthDate"), myDate);
        Predicate namesWithT = cb.like(root.get("firstName"), "%t%");

        criteria.select(root).where(cb.equal(root.get(Person_.BIRTH_DATE), myDate));

        return em.createQuery(criteria).getResultList();
    }

    private Date parseDate(String date) {
        Date myDate = new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            myDate = sdf.parse(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return myDate;
    }

    public List<UserInfo> getUserInfo(Integer dptId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> criteria = cb.createQuery(Person.class);
        Root<Person> root = criteria.from(Person.class);
        Join<Person, Dpt> join = root.join("department", JoinType.INNER);
        join.on(cb.equal(join.get("idDpt"), dptId));

        criteria.select(root);

        List<Person> result = em.createQuery(criteria).getResultList();

        return result.stream()
                .map(person -> {
                    UserInfo userInfo = new UserInfo();
                    userInfo.setFirstName(person.getFirstName());
                    userInfo.setLastName(person.getLastName());
                    userInfo.setDptName(person.getDepartment() != null ? person.getDepartment().getNameDpt() : null);
                    return userInfo;
        }).collect(Collectors.toList());
    }
}
