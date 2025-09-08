package utilities;

public class ExcelPathProvider {
	public static final String USER_DIRECTORY = System.getProperty("user.dir");

    public static String getExcelPath(String fileName) {
        return USER_DIRECTORY + "/src/main/resources/" + fileName;
    }
}
