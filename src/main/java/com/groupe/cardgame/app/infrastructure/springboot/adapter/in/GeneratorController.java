package com.groupe.cardgame.app.infrastructure.springboot.adapter.in;

import com.groupe.cardgame.app.application.response.ApiResponse;
import com.groupe.cardgame.app.application.response.ApiResponseWithBody;
import com.groupe.cardgame.app.infrastructure.springboot.models.CardEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/generate")
public class GeneratorController {

     public GeneratorController() {
     }
     @PostMapping("/cards")
     public ApiResponse generateCards() {
          ApiResponse apiResponse = new ApiResponseWithBody<List<CardEntity>>(HttpStatus.OK,new ArrayList<>());
          return apiResponse;
     }

}