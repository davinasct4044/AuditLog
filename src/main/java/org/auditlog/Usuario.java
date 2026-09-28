package org.auditlog;

public class Usuario {
    private String nome;
    private String ip;

    public String getNome() {
        return this.nome;
    }

    public String getIp() {
        return this.ip;
    }

    public boolean validarIP(String ip) {
        String[] ipDividido = ip.split("\\.");
        int qntIpDividido = 0;
        for(String parte : ipDividido) {
            qntIpDividido++;
            try {
                int numero = Integer.parseInt(parte);
                if (numero < 0 || numero > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }

        }
        if (ipDividido.length != 4) {
            return false;
        }
        return true;
    }

    public Usuario(String nome, String ip) {
        if (validarIP(ip)) {
            this.nome = nome;
            this.ip = ip;
        } else {
            throw new IllegalArgumentException("IP inválido");
        }


    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | IP:" + ip;
    }

}
