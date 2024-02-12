package com.example.demo.repo;

import com.example.demo.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
@AllArgsConstructor
public class PersonDao {

    @PersistenceContext
    private EntityManager em;

    public List<Person> findPersonsByNameLikeOrBirthDate() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> criteria = cb.createQuery(Person.class);
        Root<Person> root = criteria.from(Person.class);

        Date myDate = parseDate("1999-01-01");

        Predicate young = cb.greaterThan(root.get("birthDate"), myDate);
        Predicate namesWithT = cb.like(root.get("firstName"), "%t%");

        criteria.select(root).where(cb.or(young, namesWithT)).orderBy(cb.desc(root.get("birthDate")));

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
}
