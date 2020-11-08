/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteis;

import dao.ClientDAO;
import dao.ProviderDAO;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import model.Client;
import model.Credit;
import model.Debits;
import model.Provider;
import model.Utils;

/**
 *
 * @author Gui
 */
public class GerenciadorIntegra {

    private static String pathExport = "C:\\integracao\\financeiro\\exportacao\\";
    private static String pathImport = "C:\\integracao\\financeiro\\importação\\";

    /*Exportação
    *@Params flag: 1-Credit  2-Debit
    */
    public static void produzDadosIntegracao(int flag, int operacao, ArrayList lista) throws IOException {

        String arquivo;

        switch (flag) {
            case 0: {
                exportCredit(operacao, lista);
                break;
            }

            case 1: {
                exportDebit(operacao, lista);
                break;
            }
        }

    }

    /*Importação
    *@Params flag: 1-Fornecedores  2-Clientes
    */
    public static void consomeDadosIntegracao(int flag) throws Exception{
        switch(flag) {
            case 1: {
                importFornecedores();
                break;
            }
            
            case 2: {
                importClientes();
                break;
            }
        }
    }
    //........
    private static void exportCredit(int operacao, ArrayList lista) throws IOException {

        File arquivo = new File(pathExport + "creditos.csv");

        if (arquivo.exists()) {
            arquivo.delete();
        }

        arquivo = null;

        for (Object linha : lista) {

            Credit cr = (Credit) linha;

            Date data = new Date();
            SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            String dataFormatada = formatador.format(data);

            String conteudo = operacao + ";" + cr.getId() + ";" + Utils.formatarData(cr.getSale_date()) + ";" + Utils.formatarData(cr.getDue_date()) + ";" + Utils.formatarData(cr.getPayment_date()) + ";" + cr.getValue() + ";" + cr.getValue_paid() + ";" + cr.getDescription() + ";" + cr.getNote() + ";" + cr.getClient_id() + ";" + dataFormatada;
            ManipuladorArquivo.escritor(pathExport + "compras.csv", conteudo);

        }
    }

    private static void exportDebit(int operacao, ArrayList lista) throws IOException {

        File arquivo = new File(pathExport + "debitos.csv");

        if (arquivo.exists()) {
            arquivo.delete();
        }

        arquivo = null;

        for (Object linha : lista) {

            Debits cr = (Debits) linha;

            Date data = new Date();
            SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            String dataFormatada = formatador.format(data);

            String conteudo = operacao + ";" + cr.getId() + ";" + Utils.formatarData(cr.getBuy_date()) + ";" + Utils.formatarData(cr.getDue_date()) + ";" + Utils.formatarData(cr.getPayment_date()) + ";" + cr.getValue() + ";" + cr.getValue_paid() + ";" + cr.getDescription() + ";" + cr.getNote() + ";" + cr.getFornecedores_id() + ";" + dataFormatada;
            ManipuladorArquivo.escritor(pathExport + "debitos.csv", conteudo);

        }
    }

    private static void importFornecedores() throws IOException, Exception {

        File dir = new File(pathImport);

        if (!dir.exists()) {
            throw new IOException(pathImport + "Arquivo não encontrado");
        }

        File file = new File(pathImport + "fornecedores.csv");

        if (!file.exists()) {
            throw new IOException(pathImport + "Arquivo não encontrado");
        }

        ArrayList<String> registros = ManipuladorArquivo.leitor(pathImport + "fornecedores.csv");

        for (String linha : registros) {

            String data[] = linha.split(";");

            int op = Integer.parseInt(data[0]);

            switch (op) {
                case 0: {
                    insereNovoFornecedor(data);
                    break;
                }
                case 1: {
                    break;
                }
                case 2: {
                    break;
                }
            }
        }

        File destiny = new File("C:\\integracao\\compras\\importados\\");

        if (!destiny.exists()) {
            destiny.mkdir();
        }
        Date date = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy'T'HH;mm;ss");
        String dataAtual = formatador.format(date);
        System.out.println(dataAtual);

        boolean moved = file.renameTo(new File(destiny, file.getName().replaceAll(".csv", dataAtual + ".csv")));
    
        if (moved) {
            System.out.println("Arquivo movido com sucesso");
        }   else {
            System.out.println("Erro ao mover o arquivo");
        }
        
        file = null;
        dir = null;
    }
    
    private static void importClientes() throws IOException, Exception {

        File dir = new File(pathImport);

        if (!dir.exists()) {
            throw new IOException(pathImport + "Arquivo não encontrado");
        }

        File file = new File(pathImport + "clientes.csv");

        if (!file.exists()) {
            throw new IOException(pathImport + "Arquivo não encontrado");
        }

        ArrayList<String> registros = ManipuladorArquivo.leitor(pathImport + "clientes.csv");

        for (String linha : registros) {

            String data[] = linha.split(";");

            int op = Integer.parseInt(data[0]);

            switch (op) {
                case 0: {
                    insereNovoClientes(data);
                    break;
                }
                case 1: {
                    break;
                }
                case 2: {
                    break;
                }
            }
        }

        File destiny = new File("C:\\integracao\\cadastro\\importados\\");

        if (!destiny.exists()) {
            destiny.mkdir();
        }
        Date date = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy'T'HH;mm;ss");
        String dataAtual = formatador.format(date);
        System.out.println(dataAtual);

        boolean moved = file.renameTo(new File(destiny, file.getName().replaceAll(".csv", dataAtual + ".csv")));
    
        if (moved) {
            System.out.println("Arquivo movido com sucesso");
        }   else {
            System.out.println("Erro ao mover o arquivo");
        }
        
        file = null;
        dir = null;
    }
    
    
    private static void insereNovoFornecedor(String data[]) throws ParseException, Exception{
        ProviderDAO dao = new ProviderDAO();
        
        int id = Integer.parseInt(data[1]);
        
        Provider p = new Provider();
        
        p.setId(id);
        p.setCompany_name(data[2]);
        p.setTrade_name(data[3]);
        p.setCnpj(data[4]);
        p.setPhone(data[5]);
        p.setEmail(data[6]);
        
        dao.inserir(p);
        
       dao = null;
       p = null;
    }
    
    
    
    private static void insereNovoClientes(String data[]) throws ParseException, Exception{
        ClientDAO dao = new ClientDAO();
        
        int id = Integer.parseInt(data[1]);
        Client c = new Client();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

        Calendar n = Calendar.getInstance();
        
        n.setTime(formatador.parse(data[3]));
        
        c.setId(id);
        c.setName(data[2]);
        c.setCpf(data[4]);
        c.setBirth_date(n);
        c.setRg(data[5]);
        c.setPhone(data[6]);
        c.setAddress(data[7]);
        c.setCep(data[8]);
        c.setAddress_number(data[9]);
        c.setAddress_neighborhood(data[10]);
        c.setAddress_city(data[11]);
        c.setAddress_state(data[12]);
       
        
        dao.inserir(c);
        
       dao = null;
       c = null;
    }
    
    
}
