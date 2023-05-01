package com.example.convertersbacem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ConverterSbacemApplication {

    public static void main(String[] args)  throws IOException {

        File file = new File("C:\\Users\\marlo\\OneDrive\\backup_sbacem\\Sbacem\\CONVERSOR MODELO UBC TXT XLS\\RC066_09.TXT");
        Scanner scanner;
        try (FileInputStream inputStream = new FileInputStream(file)) {

            scanner = new Scanner(inputStream);
            List<String[]> data = new ArrayList<>();

            while (scanner.hasNextLine()) {

                    String[] lineData = scanner.nextLine().split(" ");
                    data.add(lineData);


                        String line = scanner.nextLine();
                        String TP_REG = line.substring(0, 1);

                        //REGISTRO – ‘2’ – DADOS CONSOLIDADOS DOS TITULARES PROCESSADOS
                        if (TP_REG.equals("2")) {

                            String CD_ECAD = line.substring(2, 13);
                            String CD_CAE = line.substring(14, 24);
                            String CPF_CGC = line.substring(25, 38);
                            String CD_IFPI = line.substring(39, 41);
                            String NMTIT = line.substring(42, 86);
                            String PSEUDO = line.substring(87, 131);
                            String NR_RECB = line.substring(132, 144);
                            String VL_T_DIST = line.substring(145, 166);
                            String VL_T_INC = line.substring(167, 188);
                            String VL_T_RET = line.substring(189, 210);
                            String VL_T_PEND = line.substring(211, 232);
                            String VL_T_PARM = line.substring(233, 254);
                            String VL_T_DESC = line.substring(255, 276);
                            String VL_T_CRED = line.substring(277, 298);
                            String VL_T_REC = line.substring(299, 320);
                            String RAD_IFPI = line.substring(321, 322);
                            String NOM_PLANO = line.substring(323, 372);
                            String IND_PGSUBEDITPROD = line.substring(373, 373);
                            String TIP_AMOSTRA = line.substring(374, 374);
                            String FILLER = line.substring(375, 400);

                        }
                        //REGISTRO – ‘3’ – DADOS POR RUBRICA / CATEGORIA DOS TITULARES PROCESSADOS
                        if (TP_REG.equals("3")){

                            String NR_RECB = line.substring(2, 14);
                            String CD_RUBR = line.substring(15, 20);
                            String DC_RUBR = line.substring(21, 70);
                            String CD_CAT = line.substring(71, 72);
                            String VL_DIST = line.substring(73, 94);
                            String VL_INC = line.substring(95, 116);
                            String VL_RET = line.substring(117, 138);
                            String VL_PEND = line.substring(139, 160);
                            String VL_PARM = line.substring(161, 182);
                            String VL_DESC = line.substring(183, 204);
                            String VL_CRED = line.substring(205, 226);
                            String VL_TOT = line.substring(227, 248);
                            String IND_MANUAL = line.substring(249, 249);
                            String NOM_PLANO = line.substring(250, 299);
                            String IND_PGSUBEDITPROD = line.substring(300, 300);
                            String TIP_AMOSTRA = line.substring(301, 301);
                            String FILLER = line.substring(302, 350);


                        }

                        //REGISTRO – ‘4’ – IDENTIFICAÇÃO DOS AJUSTES PROCESSADOS
                        if (TP_REG.equals("4")){

                            String NR_RECB = line.substring(2, 14);
                            String CD_RUBR = line.substring(15, 20);
                            String DC_RUBR = line.substring(21, 70);
                            String CD_CAT = line.substring(71, 72);
                            String TP_AJUSTE = line.substring(73, 117);
                            String CRED_DEPT = line.substring(118, 118);
                            String VL_AJUSTE = line.substring(119, 140);

                            String NOM_PLANO = line.substring(141, 190);
                            String IND_PGSUBEDITPROD = line.substring(191, 191);
                            String TIP_AMOSTRA = line.substring(192, 192);
                            String FILLER = line.substring(193, 300);


                        }
                       




                        // ...
                       // Dado dado = new Dado(col1, col2, col3);
                        // ou
                     //   String[] rowData = {col1, col2, col3};
                        // ...


            }

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Planilha 1");
            int rowIndex = 0;
            for (String[] rowData : data) {
                XSSFRow row = sheet.createRow(rowIndex++);
                int cellIndex = 0;
                for (String cellData : rowData) {
                    XSSFCell cell = row.createCell(cellIndex++);
                    cell.setCellValue(cellData);
                }
            }

            File fileOut = new File("C:\\Users\\marlo\\OneDrive\\backup_sbacem\\Sbacem\\CONVERSOR MODELO UBC TXT XLS\\arquivo_ubc.xlsx");
            FileOutputStream outputStream = new FileOutputStream(fileOut);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();



    }








        SpringApplication.run(ConverterSbacemApplication.class, args);
    }

}
