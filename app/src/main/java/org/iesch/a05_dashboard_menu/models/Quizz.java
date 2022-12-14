package org.iesch.a05_dashboard_menu.models;

public class Quizz {

    private final String pregunta;
    private final String respuesta1;
    private final String respuesta2;
    private final int respuestaCorrecta;


    public Quizz(String pregunta, String respuesta1, String respuesta2, int respuestaCorrecta) {
        this.pregunta = pregunta;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }
}
