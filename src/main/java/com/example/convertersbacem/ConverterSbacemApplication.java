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

                            String CD_ECAD = line.substring(1, 12);
                            String CD_CAE = line.substring(13, 23);
                            String CPF_CGC = line.substring(24, 37);
                            String CD_IFPI = line.substring(38, 40);
                            String NMTIT = line.substring(41, 85);
                            String PSEUDO = line.substring(86, 130);
                            String NR_RECB = line.substring(131, 143);
                            String VL_T_DIST = line.substring(144, 165);
                            String VL_T_INC = line.substring(166, 187);
                            String VL_T_RET = line.substring(188, 209);
                            String VL_T_PEND = line.substring(210, 231);
                            String VL_T_PARM = line.substring(232, 253);
                            String VL_T_DESC = line.substring(254, 275);
                            String VL_T_CRED = line.substring(276, 297);
                            String VL_T_REC = line.substring(298, 319);
                            String RAD_IFPI = line.substring(320, 321);
                            String NOM_PLANO = line.substring(322, 371);
                            String IND_PGSUBEDITPROD = line.substring(372, 372);
                            String TIP_AMOSTRA = line.substring(373, 373);
                            String FILLER = line.substring(374, 399);

                        }
                        //REGISTRO – ‘3’ – DADOS POR RUBRICA / CATEGORIA DOS TITULARES PROCESSADOS
                        if (TP_REG.equals("3")){

                            String NR_RECB = line.substring(1, 13);
                            String CD_RUBR = line.substring(14, 19);
                            String DC_RUBR = line.substring(20, 69);
                            String CD_CAT = line.substring(70, 71);
                            String VL_DIST = line.substring(72, 93);
                            String VL_INC = line.substring(94, 115);
                            String VL_RET = line.substring(116, 137);
                            String VL_PEND = line.substring(138, 159);
                            String VL_PARM = line.substring(160, 181);
                            String VL_DESC = line.substring(182, 203);
                            String VL_CRED = line.substring(204, 225);
                            String VL_TOT = line.substring(226, 247);
                            String IND_MANUAL = line.substring(248, 248);
                            String NOM_PLANO = line.substring(249, 298);
                            String IND_PGSUBEDITPROD = line.substring(299, 299);
                            String TIP_AMOSTRA = line.substring(300, 300);
                            String FILLER = line.substring(301, 349);


                        }

                        //REGISTRO – ‘4’ – IDENTIFICAÇÃO DOS AJUSTES PROCESSADOS
                        if (TP_REG.equals("4")){

                            String NR_RECB = line.substring(1, 13);
                            String CD_RUBR = line.substring(14, 19);
                            String DC_RUBR = line.substring(20, 69);
                            String CD_CAT = line.substring(70, 71);
                            String TP_AJUSTE = line.substring(72, 116);
                            String CRED_DEPT = line.substring(117, 117);
                            String VL_AJUSTE = line.substring(118, 139);

                            String NOM_PLANO = line.substring(140, 189);
                            String IND_PGSUBEDITPROD = line.substring(190, 190);
                            String TIP_AMOSTRA = line.substring(191, 191);
                            String FILLER = line.substring(192, 299);


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
                String TP_REG = rowData[0].substring(0, 1);
               // if(TP_REG.equals("2") || TP_REG.equals("3") || TP_REG.equals("4") ) {

                XSSFRow row = sheet.createRow(rowIndex++);
                int cellIndex = 0;


                    for (String cellData : rowData) {
                        XSSFCell cell = row.createCell(cellIndex++);
                        cell.setCellValue(cellData);

                   }
               // }
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
