package poi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import file.FileUtil;
import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddressList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.StringUtil;
import org.apache.poi.xssf.usermodel.XSSFDataValidationConstraint;
import org.apache.poi.xssf.usermodel.XSSFDataValidationHelper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhihongp
 */

@SuppressWarnings("deprecation")
public class ExcelUtil {

    /**
     * 日志
     */
    private final static Logger log = LoggerFactory.getLogger(ExcelUtil.class);

    public final static String DEFAULT_EXCEL_TYPE = ".xls";

    public final static String NEW_EXCEL_TYPE = ".xlsx";

    public final static String DEFAULT_EXCEL_SUFFIX = "xls";

    public final static String NEW_EXCEL_SUFFIX = "xlsx";

    private final static String DEFAULT_FONT_NAME = "新宋体";

    private final static int DEFAULT_COLUMN_WIDTH = 14;

    private final static short DEFAULT_FONT_HEIGHT = 12;

    private final static int MAX_ROW_NUM = 65535;

    private final static int NEW_MAX_ROW_NUM = 1048575;

    public static enum ExcelType {
        XLS,
        XLSX
    }

    /**
     * @param file
     * @param beginRowNum
     * @param type
     * @param action
     * @throws IOException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static <T> ExcelResult importExcelWithHeader(String file, int beginRowNum, Class<T> type,
                                                        ExcelCallback<T> action) throws IOException,
        InstantiationException, IllegalAccessException {
        String excelName = getExcelName(file);
        ExcelType excelType = getExcelType(file);
        InputStream inputStream = new FileInputStream(excelName);
        ExcelResult excelResult = importExcelWithHeader(excelType, beginRowNum, inputStream, type, action);
        inputStream.close();
        return excelResult;
    }

    /**
     * @param file
     * @param beginIndex
     * @param type
     * @param action
     * @throws IOException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static <T> ExcelResult importExcelWithHeader(ExcelType excelType, int beginRowNum, InputStream inputStream,
                                                        Class<T> type, ExcelCallback<T> action)
        throws IOException, InstantiationException, IllegalAccessException {
        Date start = new Date();
        ExcelResult excelResult = importE(excelType, true, beginRowNum, inputStream, type, action);
        Date end = new Date();
        long cost = end.getTime() - start.getTime();
        excelResult.setCost(cost);
        return excelResult;
    }

    /**
     * @param file
     * @param type
     * @param action
     * @throws IOException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static <T> ExcelResult importExcel(String file, Class<T> type, ExcelCallback<T> action)
        throws IOException, InstantiationException,
        IllegalAccessException {

        String excelName = getExcelName(file);
        ExcelType excelType = getExcelType(file);
        InputStream inputStream = new FileInputStream(excelName);
        ExcelResult excelResult = importExcel(excelType, inputStream, type, action);
        inputStream.close();
        return excelResult;
    }

    /**
     * @param file
     * @param type
     * @param action
     * @throws IOException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static <T> ExcelResult importExcel(ExcelType excelType, InputStream inputStream, Class<T> type,
                                              ExcelCallback<T> action) throws IOException,
        InstantiationException, IllegalAccessException {
        Date start = new Date();
        ExcelResult excelResult = importE(excelType, false, 0, inputStream, type, action);
        Date end = new Date();
        long cost = end.getTime() - start.getTime();
        excelResult.setCost(cost);
        return excelResult;
    }

    public static <T> ExcelResult exportExcelWithHeader(String file, Collection<T> objects,
                                                        List<ExcelFieldDefinition> fieldDefinitionList, int beginRowNum,
                                                        Class<T> type)
        throws IllegalArgumentException, IllegalAccessException, IOException {
        String excelName = getExcelName(file);
        ExcelType excelType = getExcelType(file);
        OutputStream outputStream = new FileOutputStream(excelName);
        ExcelResult excelResult = exportExcelWithHeader(objects, fieldDefinitionList, excelType, beginRowNum,
            outputStream, type);
        outputStream.flush();
        outputStream.close();
        return excelResult;
    }

    public static <T> ExcelResult exportExcelWithHeader(Collection<T> objects,
                                                        List<ExcelFieldDefinition> fieldDefinitionList,
                                                        ExcelType excelType,
                                                        int beginRowNum, OutputStream outputStream, Class<T> type)
        throws IllegalArgumentException, IllegalAccessException, IOException {
        Date start = new Date();
        ExcelResult excelResult = exportE(objects, fieldDefinitionList, excelType, true, beginRowNum, outputStream,
            type);
        Date end = new Date();
        long cost = end.getTime() - start.getTime();
        excelResult.setCost(cost);
        return excelResult;
    }

    public static <T> ExcelResult exportExcel(String file, Collection<T> objects,
                                              List<ExcelFieldDefinition> fieldDefinitionList, int beginRowNum,
                                              Class<T> type)
        throws IllegalArgumentException, IllegalAccessException, IOException {

        String excelName = getExcelName(file);
        ExcelType excelType = getExcelType(file);
        OutputStream outputStream = new FileOutputStream(excelName);
        ExcelResult excelResult = exportExcel(objects, fieldDefinitionList, excelType, beginRowNum, outputStream, type);
        outputStream.flush();
        outputStream.close();
        return excelResult;
    }

    public static <T> ExcelResult exportExcel(Collection<T> objects, List<ExcelFieldDefinition> fieldDefinitionList,
                                              ExcelType excelType, int beginRowNum,
                                              OutputStream outputStream, Class<T> type)
        throws IllegalArgumentException, IllegalAccessException, IOException {
        Date start = new Date();
        ExcelResult excelResult = exportE(objects, fieldDefinitionList, excelType, false, beginRowNum, outputStream,
            type);
        Date end = new Date();
        long cost = end.getTime() - start.getTime();
        excelResult.setCost(cost);
        return excelResult;
    }

    public static Object getValue(Row row, int cellNum) {
        if (row == null) {
            return null;
        }

        Cell cell = row.getCell(cellNum);

        if (cell == null) {
            return null;
        }
        //cell.setCellType(HSSFCell.CELL_TYPE_STRING);//无条件转为文本，迫不得已
        return getValue(cell);
    }

    public static String getValueStr(Row row, int cellNum) {
        if (row == null) {
            return null;
        }

        Cell cell = row.getCell(cellNum);

        if (cell == null) {
            return null;
        }

        return getValueStr(cell);
    }

    public static Object getValue(Cell cell) {
        int cellType = cell.getCellType();

        if (cellType == Cell.CELL_TYPE_BOOLEAN) {
            return cell.getBooleanCellValue();
        } else if (cellType == Cell.CELL_TYPE_NUMERIC) {
            //cell.setCellType(HSSFCell.CELL_TYPE_STRING);
            String value = String.valueOf(cell.getNumericCellValue());
            if(value.contains(".")){
                return value.substring(0, value.lastIndexOf("."));
            }
            return value;

        } else if (cellType == Cell.CELL_TYPE_FORMULA) {
            return cell.getCellFormula();
        } else {
            return cell.getStringCellValue();
        }
    }

    public static String getValueStr(Cell cell) {
        int cellType = cell.getCellType();

        if (cellType == Cell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(cell.getBooleanCellValue());
        } else if (cellType == Cell.CELL_TYPE_NUMERIC) {
            return String.valueOf(cell.getNumericCellValue());
        } else if (cellType == Cell.CELL_TYPE_FORMULA) {
            return cell.getCellFormula();
        } else {
            return cell.getStringCellValue();
        }
    }

    /**
     * @param inputStream
     * @param excelType
     * @param withHeader
     * @param beginRowNum
     * @param type
     * @param action
     * @return
     * @throws IOException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    private static <T> ExcelResult importE(ExcelType excelType, boolean withHeader, int beginRowNum, InputStream
        inputStream, Class<T> type,
                                           ExcelCallback<T> action)
        throws IOException, InstantiationException, IllegalAccessException {
        ExcelResult excelResult = null;
        Workbook workbook = null;

        if (ExcelType.XLS.equals(excelType)) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            workbook = new XSSFWorkbook(inputStream);
        }

        Sheet sheet = workbook.getSheetAt(0);

        if (sheet == null) {
            excelResult = new ExcelResult(false, 0, 0, 0);
            return excelResult;
        }

        T obj = null;
        excelResult = new ExcelResult();
        int lastRowNum = sheet.getLastRowNum();
        int totalNum = withHeader ? lastRowNum : lastRowNum + 1;
        excelResult.setTotalNum(totalNum);
        int successNum = 0;
        int failureNum = 0;

        for (int rowNum = 0; rowNum <= lastRowNum; rowNum++) {
            if (withHeader && rowNum < beginRowNum) {
                continue;
            }

            Row row = sheet.getRow(rowNum);

            if (row == null) {
                continue;
            }

            if (obj == null) {
                obj = type.newInstance();
            }

            Field[] fields = type.getDeclaredFields();

            for (Field field : fields) {
                ExcelField excelField = field.getAnnotation(ExcelField.class);

                if (excelField == null) {
                    continue;
                }

                int cellNum = excelField.order();
                Class<?> fieldType = field.getType();
                Object value = getValue(row, cellNum);
                Object fieldValue = null;

                if (value != null) {
                    Class<?> valueType = value.getClass();
                    fieldValue = getFiledValue(value, fieldType, valueType);
                }

                field.setAccessible(true);
                field.set(obj, fieldValue);
            }

            boolean flag = action.handleImportData(obj, rowNum);

            if (flag) {
                successNum++;
            } else {
                failureNum++;
            }

            excelResult.setSuccessNum(successNum);
            excelResult.setFailureNum(failureNum);
        }

        boolean isSuccess = true;

        if (totalNum != successNum) {
            isSuccess = false;
        }

        excelResult.setSuccess(isSuccess);
        return excelResult;
    }

    private static <T> ExcelResult exportE(Collection<T> objects, List<ExcelFieldDefinition> fieldDefinitionList,
                                           ExcelType excelType, boolean withHeader,
                                           int beginRowNum, OutputStream outputStream, Class<T> type)
        throws IllegalArgumentException, IllegalAccessException, IOException {
        Workbook workbook = null;
        int rowNum = withHeader ? objects.size() + 1 : objects.size();
        int maxRowNum = 0;

        if (ExcelType.XLS.equals(excelType)) {
            workbook = new HSSFWorkbook();
            maxRowNum = MAX_ROW_NUM + 1;

            if (rowNum > maxRowNum) {
                throw new RuntimeException("Excel xls max row num could not more than " + maxRowNum);
            }
        } else {
            workbook = new XSSFWorkbook();
            maxRowNum = NEW_MAX_ROW_NUM + 1;

            if (rowNum > maxRowNum) {
                throw new RuntimeException("Excel xlsx max row num could not more than " + maxRowNum);
            }
        }

        Sheet sheet = workbook.createSheet();
        sheet.setDefaultColumnWidth(DEFAULT_COLUMN_WIDTH);
        int totalNum = objects.size();
        ExcelResult excelResult = new ExcelResult();
        excelResult.setTotalNum(totalNum);
        int successNum = 0;
        int failureNum = 0;
        Map<Integer, Boolean> cellExplicit = new HashMap<Integer, Boolean>();

        if (withHeader) {
            Row row = sheet.createRow(0);
            Field[] fields = type.getDeclaredFields();

            for (Field field : fields) {
                ExcelField excelField = field.getAnnotation(ExcelField.class);

                if (excelField == null) {
                    continue;
                }

                if (fieldDefinitionList != null) {
                    String header = excelField.header();

                    if (!fieldDefinitionList.contains(header)) {
                        continue;
                    }
                }

                int cellNum = excelField.order();
                String cellValue = excelField.header();
                String[] explicitListValues = excelField.explicitListValues();

                if (cellValue != null) {
                    CellStyle cellStyle = getDefaultHeaderStyle(workbook);
                    Cell cell = row.createCell(cellNum);
                    cell.setCellStyle(cellStyle);
                    cell.setCellValue(cellValue);
                }

                if (explicitListValues != null && explicitListValues.length > 0) {
                    setValidationData(sheet, 1, maxRowNum - 1, cellNum, cellNum, explicitListValues);
                    cellExplicit.put(cellNum, true);
                }
            }
        }

        for (T obj : objects) {
            try {
                Row row = sheet.createRow(sheet.getLastRowNum() + 1);
                Field[] fields = type.getDeclaredFields();

                for (Field field : fields) {
                    ExcelField excelField = field.getAnnotation(ExcelField.class);

                    if (excelField == null) {
                        continue;
                    }

                    if (fieldDefinitionList != null) {
                        String header = excelField.header();

                        if (!fieldDefinitionList.contains(header)) {
                            continue;
                        }
                    }

                    int cellNum = excelField.order();
                    field.setAccessible(true);
                    Object objValue = field.get(obj);
                    CellStyle cellStyle = getDefaultDataStyle(workbook);
                    Cell cell = row.createCell(cellNum);
                    cell.setCellStyle(cellStyle);
                    Boolean explicitObj = cellExplicit.get(cellNum);
                    boolean explicit = explicitObj == null ? false : explicitObj;

                    if (objValue == null) {
                        String fieldValue = "";
                        cell.setCellValue(fieldValue);
                    } else if (objValue instanceof String) {
                        String fieldValue = (String)objValue;
                        cell.setCellValue(fieldValue);
                    } else if (objValue instanceof Integer) {
                        Integer fieldValue = (Integer)objValue;
                        cell.setCellValue(fieldValue);
                    } else if (objValue instanceof Boolean) {
                        Boolean fieldValue = (Boolean)objValue;
                        cell.setCellValue(fieldValue);
                    } else if (objValue instanceof Float) {
                        Float fieldValue = (Float)objValue;
                        cell.setCellValue(fieldValue);
                    } else if (objValue instanceof Short) {
                        Short fieldValue = (Short)objValue;
                        cell.setCellValue(fieldValue);
                    } else if (objValue instanceof Date) {
                        Date fieldValue = (Date)objValue;
                        cell.setCellValue(fieldValue);
                    } else {
                        String fieldValue = objValue.toString();
                        cell.setCellValue(fieldValue);
                    }

                    if (!explicit) {
                        String[] explicitListValues = excelField.explicitListValues();

                        if (explicitListValues != null && explicitListValues.length > 0) {
                            setValidationData(sheet, 1, maxRowNum - 1, cellNum, cellNum, explicitListValues);
                        }
                    }
                }

                successNum++;
            } catch (Exception e) {
                log.error("Excel export error, obj=" + obj, e);
                failureNum++;
            }

            excelResult.setSuccessNum(successNum);
            excelResult.setFailureNum(failureNum);
        }

        boolean isSuccess = true;

        if (totalNum != successNum) {
            isSuccess = false;
        }

        excelResult.setSuccess(isSuccess);
        workbook.write(outputStream);
        return excelResult;
    }

    public static String getExcelName(String file) {
        String fileName = null;
        String suffix = FileUtil.getFileSuffix(file);

        if (suffix == null) {
            fileName = file + DEFAULT_EXCEL_TYPE;
        } else {
            if (!ExcelUtil.DEFAULT_EXCEL_SUFFIX.equalsIgnoreCase(suffix) && !ExcelUtil.NEW_EXCEL_SUFFIX
                .equalsIgnoreCase(suffix)) {
                throw new RuntimeException("File must be excel");
            }

            fileName = file;
        }

        return fileName;
    }

    public static ExcelType getExcelType(String file) {
        String suffix = FileUtil.getFileSuffix(file);
        ExcelType excelType = null;

        if (suffix == null) {
            excelType = ExcelType.XLS;
        } else {
            if (ExcelUtil.NEW_EXCEL_SUFFIX.equalsIgnoreCase(suffix)) {
                excelType = ExcelType.XLSX;
            } else if (ExcelUtil.DEFAULT_EXCEL_SUFFIX.equalsIgnoreCase(suffix)) {
                excelType = ExcelType.XLS;
            } else {
                throw new RuntimeException("File must be excel");
            }
        }

        return excelType;
    }

    private static Object getFiledValue(Object value, Class<?> fieldType, Class<?> valueType) {
        Object fieldValue = value;

        if (!fieldType.isAssignableFrom(valueType)) {
            if (fieldType.isAssignableFrom(String.class)) {
                fieldValue = String.valueOf(value);
            } else if (fieldType.isAssignableFrom(Integer.class)) {
                if (valueType.isAssignableFrom(String.class)) {
                    String valueTmp = (String)value;
                    fieldValue = Integer.valueOf(valueTmp);
                } else if (valueType.isAssignableFrom(Double.class)) {
                    Double valueTmp = (Double)value;
                    fieldValue = valueTmp.intValue();
                } else if (valueType.isAssignableFrom(Boolean.class)) {
                    Boolean valueTmp = (Boolean)value;

                    if (valueTmp) {
                        fieldValue = 1;
                    } else {
                        fieldValue = 0;
                    }
                }
            } else if (fieldType.isAssignableFrom(Long.class)) {
                if (valueType.isAssignableFrom(String.class)) {
                    String valueTmp = (String)value;
                    fieldValue = Long.valueOf(valueTmp);
                } else if (valueType.isAssignableFrom(Double.class)) {
                    Double valueTmp = (Double)value;
                    fieldValue = valueTmp.longValue();
                } else if (valueType.isAssignableFrom(Boolean.class)) {
                    Boolean valueTmp = (Boolean)value;

                    if (valueTmp) {
                        fieldValue = 1;
                    } else {
                        fieldValue = 0;
                    }
                }
            } else if (fieldType.isAssignableFrom(Double.class)) {
                if (valueType.isAssignableFrom(String.class)) {
                    String valueTmp = (String)value;
                    fieldValue = Double.valueOf(valueTmp);
                } else if (valueType.isAssignableFrom(Boolean.class)) {
                    Boolean valueTmp = (Boolean)value;

                    if (valueTmp) {
                        fieldValue = 1;
                    } else {
                        fieldValue = 0;
                    }
                }
            } else if (fieldType.isAssignableFrom(Boolean.class)) {
                if (valueType.isAssignableFrom(String.class)) {
                    String valueTmp = (String)value;
                    fieldValue = Boolean.valueOf(valueTmp);
                } else if (valueType.isAssignableFrom(Double.class)) {
                    Double valueTmp = (Double)value;

                    if (Double.compare(valueTmp, 1) == 0) {
                        fieldValue = true;
                    } else if (Double.compare(valueTmp, 0) == 0) {
                        fieldValue = false;
                    }
                }
            } else if (fieldType.isAssignableFrom(Date.class)) {
                if (valueType.isAssignableFrom(String.class)) {
                    String valueTmp = (String)value;
                    fieldValue = new Date(valueTmp);
                }
            } else if (fieldType.isAssignableFrom(Short.class)) {
                if (valueType.isAssignableFrom(String.class)) {
                    String valueTmp = (String)value;
                    fieldValue = Short.valueOf(valueTmp);
                } else if (valueType.isAssignableFrom(Double.class)) {
                    Double valueTmp = (Double)value;
                    fieldValue = valueTmp.shortValue();
                } else if (valueType.isAssignableFrom(Boolean.class)) {
                    Boolean valueTmp = (Boolean)value;

                    if (valueTmp) {
                        fieldValue = 1;
                    } else {
                        fieldValue = 0;
                    }
                }
            } else if (fieldType.isAssignableFrom(Float.class)) {
                if (valueType.isAssignableFrom(String.class)) {
                    String valueTmp = (String)value;
                    fieldValue = Float.valueOf(valueTmp);
                } else if (valueType.isAssignableFrom(Double.class)) {
                    Double valueTmp = (Double)value;
                    fieldValue = valueTmp.floatValue();
                } else if (valueType.isAssignableFrom(Boolean.class)) {
                    Boolean valueTmp = (Boolean)value;

                    if (valueTmp) {
                        fieldValue = 1;
                    } else {
                        fieldValue = 0;
                    }
                }
            }
        }

        return fieldValue;
    }

    private static CellStyle getDefaultHeaderStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontHeightInPoints(DEFAULT_FONT_HEIGHT);
        font.setFontName(DEFAULT_FONT_NAME);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        style.setFont(font);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        return style;
    }

    private static CellStyle getDefaultDataStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontHeightInPoints(DEFAULT_FONT_HEIGHT);
        font.setFontName(DEFAULT_FONT_NAME);
        style.setFont(font);
        return style;
    }

    private static ExcelResult testExportExcel(String file)
        throws IllegalArgumentException, IllegalAccessException, IOException {
        List<DdlConfig> objects = new ArrayList<>();
        DdlConfig ddlConfig1 = new DdlConfig("user", "id", 10, "demo", 2, "是");
        DdlConfig ddlConfig2 = new DdlConfig("order", "name", 4, "demo", 2, "否");
        DdlConfig ddlConfig3 = new DdlConfig("good", "nick", 12, "demo", 2, "是");
        objects.add(ddlConfig1);
        objects.add(ddlConfig2);
        objects.add(ddlConfig3);
        ExcelResult excelResult = ExcelUtil.exportExcelWithHeader(file, objects, null, 1, DdlConfig.class);
        return excelResult;
    }

    private static ExcelResult testImportExcel(String file)
        throws InstantiationException, IllegalAccessException, IOException {
        ExcelResult excelResult = ExcelUtil.importExcelWithHeader(file, 1, DdlConfig.class,
            new ExcelCallback<DdlConfig>() {
                @Override
                public boolean handleImportData(DdlConfig obj, int rowNum) {
                    boolean flag = true;
                    if (rowNum == 1) {
                        flag = false;
                    }
                    System.out.println("rowNum=" + rowNum + " Data=" + obj);
                    return flag;
                }
            });

        return excelResult;
    }

    /**
     * 添加数据有效性检查.
     *
     * @param sheet              要添加此检查的Sheet
     * @param firstRow           开始行
     * @param lastRow            结束行
     * @param firstCol           开始列
     * @param lastCol            结束列
     * @param explicitListValues 有效性检查的下拉列表
     * @throws IllegalArgumentException 如果传入的行或者列小于0(< 0)或者结束行/列比开始行/列小
     */
    private static void setValidationData(Sheet sheet, int firstRow, int lastRow, int firstCol, int lastCol, String[]
        explicitListValues)
        throws IllegalArgumentException {
        if (firstRow < 0 || lastRow < 0 || firstCol < 0 || lastCol < 0 || lastRow < firstRow || lastCol < firstCol) {
            throw new RuntimeException(
                "Wrong Row or Column index : " + firstRow + ":" + lastRow + ":" + firstCol + ":" + lastCol);
        }

        CellRangeAddressList addressList = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);

        if (sheet instanceof XSSFSheet) {
            XSSFDataValidationConstraint constraint = new XSSFDataValidationConstraint(explicitListValues);
            XSSFDataValidationHelper helper = new XSSFDataValidationHelper((XSSFSheet)sheet);
            DataValidation validation = helper.createValidation(constraint, addressList);
            validation.setSuppressDropDownArrow(true);
            validation.setShowErrorBox(true);
            validation.setShowPromptBox(true);
            sheet.addValidationData(validation);
        } else if (sheet instanceof HSSFSheet) {
            DVConstraint dvConstraint = DVConstraint.createExplicitListConstraint(explicitListValues);
            HSSFDataValidation validation = new HSSFDataValidation(addressList, dvConstraint);
            validation.setSuppressDropDownArrow(false);
            validation.setShowErrorBox(true);
            validation.setShowPromptBox(true);
            sheet.addValidationData(validation);
        }
    }

    public static void main(String[] args)
        throws IllegalArgumentException, IllegalAccessException, IOException, InstantiationException,
        InterruptedException {
        String file = "/Users/libai/Desktop/1.xlsx";
        //ExcelUtil.testExportExcel(file);
        Thread.sleep(5000l);
        ExcelUtil.testImportExcel(file);
    }
}
