/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M3.Classi;

/**
 *
 * @author euralcoop
 */
public class Materasso {
    private String nome;
    private String id;
    private String url;
    private String descrizione;
    private String dettagli;
    private int disponibili;
    private double prezzo;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * @param descrizione the descrizione to set
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * @return the dettagli
     */
    public String getDettagli() {
        return dettagli;
    }

    /**
     * @param dettagli the dettagli to set
     */
    public void setDettagli(String dettagli) {
        this.dettagli = dettagli;
    }

    /**
     * @return the disponibili
     */
    public int getDisponibili() {
        return disponibili;
    }

    /**
     * @param disponibili the disponibili to set
     */
    public void setDisponibili(int disponibili) {
        this.disponibili = disponibili;
    }

    /**
     * @return the prezzo
     */
    public double getPrezzo() {
        return prezzo;
    }

    /**
     * @param prezzo the prezzo to set
     */
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
}
