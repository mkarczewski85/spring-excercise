package com.sda.springjavapoz4.service;

import org.springframework.stereotype.Component;

@Component
public class CalcService {

    public int sum(int a, int b) {

        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

//1. zaimplementowac metody
//2. utworzyc w kontekscie springa obiekt typu CalcService
//3. Wstrzyknac go do NOWEGO controllera - CalcController
//4. Wykorzystać tego beana w metodach @GetMapping("/calc/add")
//                  oraz @GetMapping("/calc/multiply")
//5. Liczby wygenerowac losowo za pomoca klasy RandomNumbersGeneratorService
//6. Wyswietlamy wynik za pomocą System.out.println