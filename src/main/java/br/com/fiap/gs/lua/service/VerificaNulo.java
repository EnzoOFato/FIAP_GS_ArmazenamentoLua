package br.com.fiap.gs.lua.service;

import java.lang.reflect.Field;

public class VerificaNulo {
    // Retorna verdadeiro caso haja um campo nulo
    public static <T> boolean verificaAtributoNulo(T objeto) {
        if (objeto == null) return true;

        for (Field atributo : objeto.getClass().getFields()) {
            atributo.setAccessible(true);
            try {
                if (atributo.get(objeto) == null) {
                    return false;
                }
            }  catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }
}
