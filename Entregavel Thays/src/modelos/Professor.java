package modelos;

// Esta classe poderia ser abstrata, já que ela nunca é instanciada
public class Professor {

    private String nomeProf;

    private String sobrenomeProf;

    private Integer tempoDeCasa;

    private Integer codigoProf;

    public Professor(){

    }

    public Professor(String nomeProf, String sobrenomeProf, Integer tempoDeCasa, Integer codigoProf) {
        this.nomeProf = nomeProf;
        this.sobrenomeProf = sobrenomeProf;
        this.tempoDeCasa = tempoDeCasa;
        this.codigoProf = codigoProf;
    }

    public String getNomeProf() {
        return nomeProf;
    }

    public void setNomeProf(String nomeProf) {
        this.nomeProf = nomeProf;
    }

    public String getSobrenomeProf() {
        return sobrenomeProf;
    }

    public void setSobrenomeProf(String sobrenomeProf) {
        this.sobrenomeProf = sobrenomeProf;
    }

    public Integer getTempoDeCasa() {
        return tempoDeCasa;
    }

    public void setTempoDeCasa(Integer tempoDeCasa) {
        this.tempoDeCasa = tempoDeCasa;
    }

    public Integer getCodigoProf() {
        return codigoProf;
    }

    public void setCodigoProf(Integer codigoProf) {
        this.codigoProf = codigoProf;
    }
}
