package utils;

import org.openqa.selenium.WebDriver;
import pageObjects.DefectOverviewPageObject;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration extends BaseClass {
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
    static LocalDateTime now = LocalDateTime.now();

    static InputStream input1 = Configuration.class.getClassLoader().getResourceAsStream("properties/app.properties");
    static Properties prop1 = new Properties();

    static InputStream input2 = Configuration.class.getClassLoader().getResourceAsStream("properties/brief.properties");
    static Properties prop2 = new Properties();

    public Configuration(WebDriver driver) {
        super(driver);
    }

    public static String getAdmin() throws IOException {
        prop1.load(input1);
        return prop1.getProperty("admin");
    }

    public static String getAdminPassword() throws IOException {
        prop1.load(input1);
        return prop1.getProperty("adminPassword");
    }

    public static String getAdminUser() throws IOException {
        prop1.load(input1);
        return prop1.getProperty("adminUser");
    }

    public static String getAdminUserPassword() throws IOException {
        prop1.load(input1);
        return prop1.getProperty("adminUserPassword");
    }

    public static String getAdminUser1() throws IOException {
        prop1.load(input1);
        return prop1.getProperty("adminUser1");
    }

    public static String getAdminUserPassword1() throws IOException {
        prop1.load(input1);
        return prop1.getProperty("adminUserPassword1");
    }

    public static String getStandard() throws IOException {
        prop1.load(input1);
        return prop1.getProperty("standard");
    }

    public static String getStandardPassword() throws IOException {
        prop1.load(input1);
        return prop1.getProperty("standardPassword");
    }

    public static String getStandardUser() throws IOException {
        prop1.load(input1);
        return prop1.getProperty("standardUser");
    }

    public static String getStandardUserPassword() throws IOException {
        prop1.load(input1);
        return prop1.getProperty("standardUserPassword");
    }
    public static String getContractor() throws IOException {
        prop1.load(input1);
        return prop1.getProperty("contractor");
    }

    public static String getContractorPassword() throws IOException {
        prop1.load(input1);
        return prop1.getProperty("contractorPassword");
    }

    public static String getContractorUser() throws IOException {
        prop1.load(input1);
        return prop1.getProperty("contractorUser");
    }

    public static String getContractorUserPassword() throws IOException {
        prop1.load(input1);
        return prop1.getProperty("contractorUserPassword");
    }

    public static String getBriefGroupName() throws IOException {
        return "Group "+dtf.format(now);
    }

    public static String getBriefGroupUser() throws IOException{
        prop2.load(input2);
        return prop2.getProperty("groupUser");
    }

    public static String getBriefCategoryName() throws IOException {
        return "Category "+dtf.format(now);
    }

    public static String getBriefCategory2Name() throws IOException {
        return "Category2 "+dtf.format(now);
    }

    public static String getBriefCategoryDeadline() throws IOException{
        prop2.load(input2);
        return prop2.getProperty("categoryDeadline");
    }

    public static String getBriefCategoryCriticality() throws IOException{
        prop2.load(input2);
        return prop2.getProperty("categoryCriticality");
    }

    public static String getBriefTitle() throws IOException {
        return "Brief "+dtf.format(now);
    }

    public static String getBriefDetails1() throws IOException{
        prop2.load(input2);
        return prop2.getProperty("standardBriefDetails1");
    }

    public static String getBriefDetails2() throws IOException{
        prop2.load(input2);
        return prop2.getProperty("standardBriefDetails2");
    }

    public static String getBriefDate1() throws IOException{
        prop2.load(input2);
        return prop2.getProperty("date1");
    }

    public static String getBriefDate2() throws IOException{
        prop2.load(input2);
        return prop2.getProperty("date2");
    }

    public static String getBriefVersion() throws IOException{
        prop2.load(input2);
        return prop2.getProperty("versionUpdate");
    }

    public static String getBriefNewUser() throws IOException{
        prop2.load(input2);
        return prop2.getProperty("newUser");
    }

    public static String getPercentage() throws IOException{
        prop2.load(input2);
        return prop2.getProperty("percentage");
    }

    public String getDefectIdentifier() throws IOException{
        return $(DefectOverviewPageObject.getFirstDefectReport()).getText();
    }

    public static String getAssetGroupName() throws IOException{
        return "Asset Group "+dtf.format(now);
    }

    public static String getInspectionName() throws IOException{
        return "Inspection "+dtf.format(now);
    }

    public static String getGuidanceName() throws IOException{
        return "Guidance "+dtf.format(now);
    }
}
