package br.com.chronosAcademy.core;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class GeraPage {
    String space = "    ";
    @Test
    public void geraPage() throws FileNotFoundException {
        String diretorio = "src/test/java/br/com/chronosAcademy/maps";
        File file = new File(diretorio);
        File afile[] = file.listFiles();
        int i = 0;
        for (int j = afile.length; i < j; i++) {
            File arquivos = afile[i];
            String classe = arquivos.getName().replace("Map.java", "Page");
            System.out.println(classe);
            inicializaClasse(classe);
            getClasse(diretorio, arquivos.getName(), classe);
            System.out.println("}");
            System.out.println("###################################################################");

        }

    }

    public String getClasse(String diretorio, String nomeArquivo, String classe) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader(diretorio+"/"+nomeArquivo));
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.contains("WebElement ")){
                String[] objetos = line.split(" ");
                String elemento = objetos[objetos.length-1].replace(";","");
               // System.out.println(elemento);
                if (elemento.contains("inp")){
                    getSendKeys(elemento, nomeArquivo, classe);
                }else if(elemento.contains("btn") || elemento.contains("link") || elemento.contains("opt")){
                    getClick(elemento, nomeArquivo, classe);
                }else if(elemento.contains("text")){
                    getText(elemento, nomeArquivo);
                }else if(elemento.contains("slc")){
                    getSelect(elemento, nomeArquivo, classe);
                }
            }

        }

        return "";
    }

    public String getMinusculo(String texto){
        //StringBuilder sb = new StringBuilder();
        texto = texto.substring(0,1).toLowerCase()+texto.substring(1);
        return texto;
    }

    public void getSendKeys(String elemento, String nomeArquivo, String classe){
        String elementoreplace = elemento.replace("inp","");
        String objeto = getMinusculo(elementoreplace);
        System.out.println(space+"public "+classe+" set"+elementoreplace+"(String "+objeto+"){");
        System.out.print(space+space+getMinusculo(nomeArquivo.replace(".java", "")));
        System.out.println("."+elemento+".sendKeys("+objeto+");");
        System.out.println(space+space+"return this;");
        System.out.println(space+"}");
    }

    public void getSelect(String elemento, String nomeArquivo, String classe){
        String elementoreplace = elemento.replace("slc","");
        String objeto = getMinusculo(elementoreplace);
        System.out.println(space+"public "+classe+" select"+elementoreplace+"(String "+objeto+"){");
        System.out.println(space+space+"Select select = new Select(" +
                getMinusculo(nomeArquivo.replace(".java", "")) +
                        "."+elemento+");");
        System.out.println(space+space+"select.selectByVisibleText("+objeto+");");

        System.out.println(space+space+"return this;");
        System.out.println(space+"}");
    }

    public void getClick(String elemento, String nomeArquivo, String classe){
        String elementoreplace = elemento.replace("btn","")
                .replace("link","")
                .replace("opt","");
        String objeto = getMinusculo(elementoreplace);
        System.out.println(space+"public "+classe+" click"+elementoreplace+"(){");


        System.out.print(space+space+ getMinusculo(nomeArquivo.replace(".java", "")));
        System.out.println("."+elemento+".click();");
        System.out.println(space+space+"return this;");
        System.out.println(space+"}");
    }

    public void getText(String elemento, String nomeArquivo){
        String elementoreplace = elemento.replace("text","");

        System.out.println(space+"public String get"+elementoreplace+"(){");

        System.out.print(space+space+ "return "+getMinusculo(nomeArquivo.replace(".java", "")));
        System.out.println("."+elemento+".getText();");
        System.out.println(space+"}");
    }

    public void inicializaClasse(String classe){

        System.out.println("public class "+classe+" {");


        System.out.println(space+classe.replace("Page","Map")+" "+getMinusculo(classe.replace("Page", "Map"))+";");
        System.out.println(space+"public "+classe+"(){");
        System.out.println(space+space+getMinusculo(classe.replace("Page","Map"))+" = new "+classe.replace("Page", "Map")+"();");
        System.out.println(space+space+"PageFactory.initElements(Driver.getDriver(), "+getMinusculo(classe.replace("Page", "Map"))+");");
        System.out.println(space+"}");
        System.out.println();

    }


}
