package modelos;

import java.util.ArrayList;
import java.util.List;

public class Curso {

    private String nomeCurso;

    private Integer codigoCurso;

    private Integer quantidadeMaximaAlunos;

    private ProfessorTitular professorTitular;

    private ProfessorAdjunto professorAdjunto;

    private List<Aluno> alunosMatriculados= new ArrayList<Aluno>();

    public Boolean adicionarUmAluno(Aluno umAluno) {
          if (alunosMatriculados.size()<quantidadeMaximaAlunos) {
            alunosMatriculados.add(umAluno);
            System.out.println("O aluno pode ser matriculado no curso selecionado");
              System.out.println("O aluno "+umAluno.getNome()+" "+umAluno.getSobrenome()+" foi adicionado ao curso "+nomeCurso+" com código "+codigoCurso);
            return true;
        } else {
            System.out.println("O aluno não pode ser matrículado, pois o curso já está cheio. =(");
            return false;
        }
    }


    public void excluirAluno (Aluno aluno){
        System.out.println("O modelos "+aluno+" foi removido.");
    }

    public Integer getQuantidadeMaximaAlunos() {
        return quantidadeMaximaAlunos;
    }

    public void setQuantidadeMaximaAlunos(Integer quantidadeMaximaAlunos) {
        this.quantidadeMaximaAlunos = quantidadeMaximaAlunos;
    }

    public ProfessorTitular getProfessorTitular() {
        return professorTitular;
    }

    public void setProfessorTitular(ProfessorTitular professorTitular) {
        this.professorTitular = professorTitular;
    }

    public ProfessorAdjunto getProfessorAdjunto() {
        return professorAdjunto;
    }

    public void setProfessorAdjunto(ProfessorAdjunto professorAdjunto) {
        this.professorAdjunto = professorAdjunto;
    }

    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public void setAlunosMatriculados(List<Aluno> alunosMatriculados) {
        this.alunosMatriculados = alunosMatriculados;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Integer getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(Integer codigoCurso) {
        this.codigoCurso = codigoCurso;
    }
}
