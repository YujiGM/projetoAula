package com.fatec.projetoAula.projeto2025.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExercicioControler {
    
    @GetMapping("")
    public String HelloWorld(){
        return "Hello World";
    }

    @GetMapping("/get-idade/{idade}")
    public String RetornaIdade(@PathVariable Integer idade){
        try{
            if (idade < 0){
                throw new NumberFormatException();
            }
            if (idade < 12){
                return "Criança";
            }else if (idade <= 18){
                return "Adolescente";
            }else if (idade <= 60){
                return "Adulto";
            }else{
                return "Idoso";
            }
        } catch (NumberFormatException e){
            return "idade inválida";
        }    
    }

    @GetMapping("/get-par-impar/{n}")
    public String RetornaParImpar(@PathVariable Integer n){    
        boolean verifica = n instanceof Integer;
        if(verifica == true){
            if(n >= 0){
                if (n % 2 == 0){
                    return "O número "+ n + " é par";
                }else{
                    return "O número " + n + " é ímpar";
                }
            }
            else{
                return "Valor Negativo";
            }
        }else{
            return "Valor Inválido";
        }
    }

    @GetMapping("/get-imc/{peso}/{altura}")
    public String CalcIMC(@PathVariable Integer peso, @PathVariable Float altura){
        boolean verificaPeso = peso instanceof Integer;
        boolean verificaAltura = altura instanceof Float;
        if(verificaAltura && verificaPeso == true){  
            if(peso > 0 && altura > 0){     
                Float calc = peso / (altura*altura);
                if (calc < 18.5){
                    return "Abaixo do peso";
                }else if( calc >= 18.5 && calc < 24.9){
                    return "Peso normal";
                }else if( calc >= 25 && calc < 29.9){
                    return "Sobrepeso";
                }else if ( calc >= 30 && calc < 34.9){
                    return "Obesidade grau 1";
                }else if( calc >= 35 && calc < 39.9){
                    return "Obesidade grau 2";
                }else{
                    return "Obesidade grau 3";
                }
            }else{
                return "Dados negativos";
            }
        }else{
            return "Valor inválido";
        }
    }
}
