package com.groupe.cardgame.app.infrastructure.springboot.adapter.in;

import com.groupe.cardgame.app.application.response.ApiResponse;
import com.groupe.cardgame.app.application.response.ApiResponseWithBody;
import com.groupe.cardgame.app.domain.model.Hero;
import com.groupe.cardgame.app.domain.model.HeroFactory;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.out.HeroRepository;
import com.groupe.cardgame.app.infrastructure.springboot.models.HeroEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/generate")
public class GeneratorController {

     private final HeroRepository heroRepository;
     private final HeroEntityMapper heroEntityMapper;

     @Autowired
     public GeneratorController(HeroRepository heroRepository, HeroEntityMapper heroEntityMapper) {
          this.heroRepository = heroRepository;
          this.heroEntityMapper = heroEntityMapper;
     }

     @PostMapping("/hero")
     public ApiResponse generateHero() {
          Hero hero = HeroFactory.createRandomHero();
          HeroEntity heroEntity = heroEntityMapper.toEntity(hero);
          heroRepository.save(heroEntity);
          List<HeroEntity> heroList = new ArrayList<>();
          heroList.add(heroEntity);
          return new ApiResponseWithBody<>(HttpStatus.OK, heroList);
     }

     @PostMapping("/heroes")
     public ApiResponse generateHeroes(@RequestParam int numberOfHeroes) {
          List<Hero> heroes = HeroFactory.createRandomHeroes(numberOfHeroes);
          List<HeroEntity> heroEntities = heroEntityMapper.toEntity(heroes);
          heroRepository.saveAll(heroEntities);
          return new ApiResponseWithBody<>(HttpStatus.OK, heroEntities);
     }

}