package com.example.demo;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class NumberingController {

    private final NumberingRepository numberingRepository;

    public NumberingController(NumberingRepository numberingRepository) {
        this.numberingRepository = numberingRepository;
    }

    @PostMapping("/configure")
    @CrossOrigin(origins = "http://localhost:4200")
    public Long configure(@RequestBody NumberingCriteria[] numberingCriterias, @RequestParam Long counter) {
        Numbering numbering = new Numbering(numberingCriterias, counter);
        return numberingRepository.save(numbering).getId();
    }

    @GetMapping("/getNumberingIds")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Long> getNumberingIds() {
        List<Long> numberingIds = new ArrayList<>();
        numberingRepository.findAll().forEach(numbering -> numberingIds.add(numbering.getId()));
        return numberingIds;
    }

    @PostMapping("/generate")
    @CrossOrigin(origins = "http://localhost:4200")
    public String generate(@RequestBody User user, @RequestParam Long numberingId) {
        Optional<Numbering> optionalNumbering = numberingRepository.findById(numberingId);
        if (optionalNumbering.isPresent()) {
            Numbering numbering = findAndIncrementCounter(numberingId);
            return numbering.generate(user);
        } else {
            throw new IllegalArgumentException("Numbering not found");
        }
    }

    @Transactional
    private Numbering findAndIncrementCounter(Long numberingId) {
        Optional<Numbering> optionalNumbering = numberingRepository.findById(numberingId);
        if (optionalNumbering.isPresent()) {
            Numbering numbering = optionalNumbering.get();
            numbering.incrementCounter();
            numberingRepository.save(numbering);
            return numbering;
        } else {
            throw new IllegalArgumentException("Numbering not found");
        }
    }
}