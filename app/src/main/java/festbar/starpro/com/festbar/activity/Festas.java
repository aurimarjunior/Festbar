package festbar.starpro.com.festbar.activity;

public class Festas {

    private String nomeDaFesta;
    private String localFesta;
    private String logoFesta;
    private String dataFesta;
    private String horarioFesta;
    private String distanciaFesta;

    public Festas (){}

    public Festas(String nomeDaFesta, String localFesta, String logoFesta, String dataFesta, String horarioFesta, String distanciaFesta) {
        this.nomeDaFesta = nomeDaFesta;
        this.localFesta = localFesta;
        this.logoFesta = logoFesta;
        this.dataFesta = dataFesta;
        this.horarioFesta = horarioFesta;
        this.distanciaFesta = distanciaFesta;
    }

    public String getNomeDaFesta() {
        return nomeDaFesta;
    }

    public void setNomeDaFesta(String nomeDaFesta) {
        this.nomeDaFesta = nomeDaFesta;
    }

    public String getLocalFesta() {
        return localFesta;
    }

    public void setLocalFesta(String localFesta) {
        this.localFesta = localFesta;
    }

    public String getLogoFesta() {
        return logoFesta;
    }

    public void setLogoFesta(String logoFesta) {
        this.logoFesta = logoFesta;
    }

    public String getDataFesta() {
        return dataFesta;
    }

    public void setDataFesta(String dataFesta) {
        this.dataFesta = dataFesta;
    }

    public String getHorarioFesta() {
        return horarioFesta;
    }

    public void setHorarioFesta(String horarioFesta) {
        this.horarioFesta = horarioFesta;
    }

    public String getDistanciaFesta() {
        return distanciaFesta;
    }

    public void setDistanciaFesta(String distanciaFesta) {
        this.distanciaFesta = distanciaFesta;
    }
}
