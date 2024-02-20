package com.example.nnpiacv02.controller;

import org.springframework.web.bind.annotation.*;
//*Základní rozdíl spočívá v tom, že @RestController kombinuje funkce
// @Controller s @ResponseBody, což automaticky serializuje návratové
// hodnoty metod na formát, který je vhodný pro webové služby (např. JSON nebo XML),
// zatímco @Controller se obvykle používá pro webové aplikace,
// které generují zobrazení.*/

@RestController
public class HelloController {
    @GetMapping("")
    public String helloWorld() {
        return "Hello world from Spring Boot application.";
    }

    @GetMapping("/{param}")
    public String pathParamEndpoint(@PathVariable("param") String param) {
        return "Přijatý parametr z cesty: " + param;
    }

    @RequestMapping(value = "/myPath/{path}", method = RequestMethod.GET)
    public String requestParamEndpointGR(@PathVariable("path") String path) {
        return "Přijatý parametr z cesty pomocí RequestMapping: " + path;
    }

    @GetMapping("/query")
    public String helloQueryParam(@RequestParam("query") String query) {
        return "Přijatý parametr z query: " + query;
    }
}



/*
XML je značkovací jazyk, který je schopný reprezentovat hierarchická data pomocí značek.
Je to poměrně starší formát a je velmi rozšířený, zejména v kontextu webu a datových výměn.
XML je extrémně rozšiřitelný a umožňuje definovat vlastní značky a struktury pomocí XML schémat (XSD).


JSON je formát pro výměnu dat, který je založený na podmnožině JavaScriptu.
Je často používán pro výměnu dat mezi webovými službami a pro ukládání konfiguračních dat.
JSON je snadno čitelný a psaný jak strojem, tak i člověkem.
Má jednoduchou syntaxi, která obsahuje pole a hodnoty v párech klíč-hodnota.

YAML je lidsky čitelný formát pro serializaci dat.
Je často používán pro konfigurační soubory, metadatové popisy a další účely.
YAML má jednoduchou a intuitivní syntaxi založenou na odsazení.
Má schopnost reprezentovat seznamy, asociativní pole a skalární hodnoty s různými datovými typy.
*/
