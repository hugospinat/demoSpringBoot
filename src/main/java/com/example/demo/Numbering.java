package com.example.demo;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.text.SimpleDateFormat;
import java.util.*;


@Entity
public class Numbering {

    @ElementCollection
    private List<NumberingCriteria> criteria;
    private Long counter;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Numbering(NumberingCriteria[] numberingCriterias, Long counter) {
        this.criteria = Arrays.asList(numberingCriterias);
        int i = 0;
        for (NumberingCriteria c : criteria) {
            c.setOrder(i);
            i++;
        }
        this.counter = counter;
    }

    public Numbering() {
        this.criteria = new ArrayList<>();
        counter = 0L;
    }

    public String generate(User user) {
        criteria.sort(Comparator.comparingInt(NumberingCriteria::getOrder));
        StringBuilder sb = new StringBuilder();
        for (NumberingCriteria c : criteria) {
            switch (c.getType()) {
                case "name":
                    sb.append(format(user.getName(), c));
                    break;
                case "firstName":
                    sb.append(format(user.getFirstName(), c));
                    break;
                case "birthDate":
                    sb.append(format(new SimpleDateFormat("yyyy").format(user.getBirthDate()), c));
                    break;
                case "counter":
                    sb.append(format(String.format("%05d", this.counter), c)); // change this line to have variable number of chars
                    break;
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    private String format(String value, NumberingCriteria c) {
        return c.getPrefix() + value.substring(0, Math.min(value.length(), c.getLength())) + c.getSuffix();
    }

    public Long incrementCounter() {
        counter = counter + 1;
        return counter;
    }

    public Long getId() {
        return id;
    }
}

