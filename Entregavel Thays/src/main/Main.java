package main;

import manager.DigitalHouseManager;
import modelos.*;

public class Main {

    public static void main(String[] args) {

        DigitalHouseManager gerenciador = new DigitalHouseManager();

        gerenciador.registrarProfessorTitular("Oswaldo","Miaira", 420,"Enrolar");
        gerenciador.registrarProfessorTitular("Newton","Spolaor", 123,"IDE C");
        gerenciador.registrarProfessorAdjunto("Rene","Maie", 421,6);
        gerenciador.registrarProfessorAdjunto("Kim","Lage",124,6);

        gerenciador.registrarCurso("Full Stack",20001,3);
        gerenciador.alocarProfessores(20001,420,421);
        gerenciador.registrarCurso("Mobile",20002,2);
        gerenciador.alocarProfessores(20002,123,124);

        gerenciador.matricularAluno("Thays","Spolaor",27);
        gerenciador.matricularAluno("Deise", "Freitas",29);
        gerenciador.matricularAluno("Giovana","Freitas",9);

        gerenciador.matricularAlunoNoCurso(29,20001);
        gerenciador.matricularAlunoNoCurso(9,20001);

        gerenciador.matricularAlunoNoCurso(27,20002);
        gerenciador.matricularAlunoNoCurso(9,20002);

        gerenciador.matricularAlunoNoCurso(27,20002);
        gerenciador.matricularAlunoNoCurso(9,20002);
        gerenciador.matricularAlunoNoCurso(29,20002);

        gerenciador.consultar(9);
    }
}
