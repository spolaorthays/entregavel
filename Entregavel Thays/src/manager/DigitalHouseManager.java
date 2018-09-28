package manager;

import modelos.*;

import java.util.ArrayList;
import java.util.List;

public class DigitalHouseManager {

    private List<Aluno> listaDeAlunos = new ArrayList<>();

    private List<Professor> listaDeProfessores = new ArrayList<>();

    private List<Curso> listaDeCursos = new ArrayList<>();

    private List<Matricula> listaDeMatricula = new ArrayList<>();

    public void registrarCurso(String nome, Integer codigoCurso, Integer quantidadeMaximaDeAlunos){

        Curso curso = new Curso();
        curso.setNomeCurso(nome);
        curso.setCodigoCurso(codigoCurso);
        curso.setQuantidadeMaximaAlunos(quantidadeMaximaDeAlunos);
        listaDeCursos.add(curso);
        System.out.println("O curso "+nome+", com código "+codigoCurso+" e que possui a quantidade máxima de vagas de "
                    +quantidadeMaximaDeAlunos+" alunos, foi registrado.");
    }

    public void excluirCurso(Integer codigoCurso){
        // Este metodo tem um bug, independente do codigoCurso enviado,
        // todos os curso estao sendo removidos da lista. Faltou um if
        for (Curso curso : listaDeCursos) {
            // if(curso.getCodigoCurso() == codigoCurso) --> alguma coisa assim
            listaDeCursos.remove(curso);
            System.out.println("O curso com código "+codigoCurso+" foi removido do sistema.");
        }
    }

    public void registrarProfessorAdjunto(String nome, String sobrenome, Integer codigoProf, Integer quantidadeHorasMonitoria){
        Integer tempoDeCasa = 0;
        ProfessorAdjunto profAdjunto = new ProfessorAdjunto();
        profAdjunto.setNomeProf(nome);
        profAdjunto.setSobrenomeProf(sobrenome);
        profAdjunto.setCodigoProf(codigoProf);
        profAdjunto.setQuantidadeHorasMonitoria(quantidadeHorasMonitoria);
        profAdjunto.setTempoDeCasa(tempoDeCasa);
        listaDeProfessores.add(profAdjunto);
            System.out.println("O professor adjunto "+nome+" "+sobrenome+", com código "+codigoProf+", possui "
                    +quantidadeHorasMonitoria+" horas de monitoria disponíveis e foi adicionado à lista de professores");
    }


    public void registrarProfessorTitular(String nome, String sobrenome, Integer codigoProf, String especialidade){
        Integer tempoDeCasa = 0; // aqui o tempoDeCasa foi criado e nao foi utilizado. Geralmente é melhor deletar quando for assim
        ProfessorTitular profTitular = new ProfessorTitular(nome,sobrenome,codigoProf,especialidade);
        listaDeProfessores.add(profTitular);
            System.out.println("O professor titular "+nome+" "+sobrenome+", com código "+codigoProf+", possui a " +
                    "especialidade de "+especialidade+" e foi adicionado à lista de professores");
    }

    public void excluirProfessor(Integer codigoProf){
        // Este remover tem o mesmo problema do excluir curso
        for (Professor professor : listaDeProfessores) {
            listaDeProfessores.remove(professor);
            System.out.println("O professor com código "+codigoProf+" foi excluído da lista de professores.");
        }
    }

    public void matricularAluno(String nome, String sobrenome, Integer matricula){
            Aluno aluno = new Aluno();
            aluno.setNome(nome);
            aluno.setSobrenome(sobrenome);
            aluno.setMatricula(matricula);
            listaDeAlunos.add(aluno);
            System.out.println("O aluno "+nome+" "+sobrenome+", com matricula "+matricula+", foi registrado à lista de alunos.");
    }


    public Aluno buscarAluno(Integer matricula){
        for (Aluno alunoProcurado : listaDeAlunos) {
            if(alunoProcurado.getMatricula().equals(matricula)){
             return alunoProcurado;
            }
        }
        return null;
    }

    public Curso  buscarCurso (Integer codigoCurso){
        for (Curso cursoProcurado : listaDeCursos) {
            if(cursoProcurado.getCodigoCurso().equals(codigoCurso)){
                return cursoProcurado;
            }
        }
        return null;
    }

    public void matricularAlunoNoCurso(Integer matricula, Integer codigoCurso){
        Aluno aluno = buscarAluno(matricula);
        // Ao inves de fazer esse for, poderia chamar o metodo buscarCurso
        // Curso curso = buscarCurso(codigoCurso)
        // curso.adicionarUmAluno(aluno)
        for (Curso curso : listaDeCursos) {
            if(curso.getCodigoCurso().equals(codigoCurso)){
                curso.adicionarUmAluno(aluno);
            }
        }

        /*if(curso != null && curso.adicionarUmAluno(aluno)){
            Matricula matricula1 = new Matricula();
            matricula1.setAluno(aluno);
            matricula1.setCurso(curso);
            listaDeMatricula.add(matricula1);*/

    }

    public ProfessorTitular buscarTitular(Integer codigoProfTitular){
        for (Professor prof : listaDeProfessores) {
            if(prof.getCodigoProf().equals(codigoProfTitular)){
                // Neste caso, não é necessário criar um new ProfessorTitular()
                // poderia apenas retornar o professo encontrado
                // return prof;
                ProfessorTitular professorTitular = new ProfessorTitular();
                professorTitular.setNomeProf(prof.getNomeProf());
                professorTitular.setSobrenomeProf(prof.getSobrenomeProf());
                professorTitular.setCodigoProf(prof.getCodigoProf());
                // Necessario fazer um casting, vide buscarAdjunto
                //professorTitular.getEspecialidade();
                return professorTitular;
            }
        }
        return null;
        }



    public ProfessorAdjunto buscarAdjunto(Integer codigoProfAdjunto){
        for (Professor prof : listaDeProfessores) {
            if(prof.getCodigoProf().equals(codigoProfAdjunto)){
                // Mesmo caso do profeso titular
                ProfessorAdjunto professorAdjunto = new ProfessorAdjunto();
                professorAdjunto.setNomeProf(prof.getNomeProf());
                professorAdjunto.setSobrenomeProf(prof.getSobrenomeProf());
                professorAdjunto.setCodigoProf(prof.getCodigoProf());
                //horas de monitoria não ta dando pra puxar.
                // FabioTadashi: As horas de monitoria estao no ProfessorAdjunto
                // e este for é de Professor, para isso seria necessário fazer um casting
                // professorAdjunto.setHorasMonitoria(((ProfessorAdjunto) prof).getHorasMonitoria());
                return professorAdjunto;
            }
        }
        return null;
    }

    public void alocarProfessores(Integer codigoCurso, Integer codigoProfTitular, Integer codigoProfAdjunto){
        /*O método deve:
● Encontrar o professor titular na lista de professores.
● Encontrar o professor adjunto na lista de professores.
● Alocar ambos professores ao curso.*/

        ProfessorTitular professorTitular = buscarTitular(codigoProfTitular);
        ProfessorAdjunto professorAdjunto = buscarAdjunto(codigoProfAdjunto);

        // Aqui poderia usar a msm idea e chamar o buscarCurso(codigoCurso)
        for (Curso curso : listaDeCursos) {
            if(curso.equals(codigoCurso)){
                curso.setProfessorAdjunto(professorAdjunto);
                curso.setProfessorTitular(professorTitular);
            }
        }

    }

    public void consultar (Integer matricula){
        for (Curso curso : listaDeCursos) {
            Boolean estaNoCurso = false;
            for (Aluno aluno : curso.getAlunosMatriculados()) {
                if(aluno.getMatricula().equals(matricula)){
                    estaNoCurso = true;
                    System.out.println("O aluno "+aluno.getNome()+" "+aluno.getSobrenome()+" está matriculado no curso de "+curso.getNomeCurso());
                }
            }
            if (!estaNoCurso){
                System.out.println("O aluno não está matriculado em nenhum dos nossos cursos.");
            }
        }
    }

    public List<Aluno> getListaDeAlunos() {
        return listaDeAlunos;
    }

    public void setListaDeAlunos(List<Aluno> listaDeAlunos) {
        this.listaDeAlunos = listaDeAlunos;
    }

    public List<Professor> getListaDeProfessores() {
        return listaDeProfessores;
    }

    public void setListaDeProfessores(List<Professor> listaDeProfessores) {
        this.listaDeProfessores = listaDeProfessores;
    }

    public List<Curso> getListaDeCursos() {
        return listaDeCursos;
    }

    public void setListaDeCursos(List<Curso> listaDeCursos) {
        this.listaDeCursos = listaDeCursos;
    }

    public List<Matricula> getListaDeMatricula() {
        return listaDeMatricula;
    }

    public void setListaDeMatricula(List<Matricula> listaDeMatricula) {
        this.listaDeMatricula = listaDeMatricula;
    }
}
