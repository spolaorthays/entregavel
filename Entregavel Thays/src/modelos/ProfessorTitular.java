package modelos;

public class ProfessorTitular extends Professor{

    private String especialidade;

    public ProfessorTitular(){

    }

    public ProfessorTitular (String nome, String sobrenome, Integer codigoProf, String especialidade){
        this.setNomeProf(nome);
        this.setSobrenomeProf(sobrenome);
        this.setCodigoProf(codigoProf);
        this.especialidade=especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
