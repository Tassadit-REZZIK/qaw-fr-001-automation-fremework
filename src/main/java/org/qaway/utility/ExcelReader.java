package org.qaway.utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    FileInputStream excelFile; // détérminer où est ce qu'il est le fichier
    // pour pouvoir lire dans une libreraie externe faut rajouter un dependency apache POI
    XSSFWorkbook workbook; // version virtuelle du fichier
    XSSFSheet sheet; // lire le sheet (l'objet)
//    String filePath = "C:\\Users\\rezzi\\IdeaProjects\\qaw-fr-001-automation-framework\\data\\test-data.xlsx"; // récupérer le path
//    String sheetName = "data"; // on a utilisé sheet pour récupérer autre chose

    String filePath;
    String sheetName;

    // on crée un constracteur pour filePath et sheetName car la façon dont il sont déclarés n'est pas bonne
    public ExcelReader(String filePath, String sheetName){

        this.filePath = filePath;
        this.sheetName = sheetName;
    }

    // une méthode pour lire dans un fichier

    public String getDataFromCell(int row, int column){
        String value = null;
        try {
            excelFile = new FileInputStream(filePath); // récupérer le file
            workbook = new XSSFWorkbook(excelFile); // création d'un fichier virtuel de l'orgine
            sheet = workbook.getSheet(sheetName); // récupérer le sheet avec la méthode get sheet
//            value = sheet.getRow(row).getCell(column).getStringCellValue(); // accéder à row, colonne, le key et la valeur du croisement
            value = sheet.getRow(row).getCell(column).getStringCellValue(); // pour récupérer la valeur en String
            excelFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return value;
    }

//    public static void main(String[] args) {
//        ExcelReader excelReader = new ExcelReader();
//        System.out.println(excelReader.getDataFromCell(1,0));
//    }

    // pour récupérer toute la colonne
    public List<String> getEntireColumnData(int rowStart, int column){
        List<String> columnData = new ArrayList<>(); // je retourne une list des strings
        try {
            excelFile = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(excelFile);
            sheet = workbook.getSheet(sheetName);
            for (int i = rowStart; i <= sheet.getLastRowNum(); i++) { // quelque soit le nombre je prends le dérnier
                columnData.add(sheet.getRow(i).getCell(column).getStringCellValue());
            }
            excelFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return columnData;
    }

//    public static void main(String[] args) {
//        ExcelReader excelReader = new ExcelReader();
//        System.out.println(excelReader.getEntireColumnData(0,1));
//    }

    // je donne la valeur de login page title pour récupérer swaglabs

    public String getDataForGivenHeaderAndKey(String header, String key){ // je lui donne le header et sa clé
        String value = null;
        // i; présente des colonnes, j; présente des lignes
        int i = 0;
        while (getDataFromCell(0,i) != null){ // on vérifie est ce que le header (colonne)c'est la clé et non pas null
            if (getDataFromCell(0, i).equalsIgnoreCase(header)){ // la celle (0,i) = header, donc s'arrete
                for (int j = 0; j < getEntireColumnData(1,i).size(); j++) { // pour récupérer une liste
                    if (getEntireColumnData(1,i).get(j).equalsIgnoreCase(key)){ // faire l'itération en vérifianr le key (valeur)
                        value = getEntireColumnData(1,i+1).get(j); // je récupére le i+1
                    }
                }
                break;
            }
            i++;
        }
        return value; // elle me retourne la valeur du string que je cherche
    }


//    public static void main(String[] args) {
//        ExcelReader excelReader = new ExcelReader();
//        System.out.println(excelReader.getDataForGivenHeaderAndKey("key","invalid password error message"));
//    }

}