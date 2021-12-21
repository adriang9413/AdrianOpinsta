package pageObjects;

public class DefectReportsObjectPage {

    private static String defectReportsMenuButton = "//*[@href='https://sam.opinsta.com/dashboard/manage/report_items']";
    private static String editReport = "//*[@id='main-table']/tbody/tr[1]//button";
    private static String addNewReport = "new-entry-btn";
    private static String radioElement = "create-radio";
    private static String sectionName = "//*[@class='form-input elements-create mandatory-form']/input";
    private static String option1 = "//*[@placeholder='Please insert the option 1']";
    private static String option2 = "//*[@placeholder='Please insert the option 2']";
    private static String saveForm = "btn-save-created_report";
    private static String formPreview = "preview-report-btn";
    private static String closeFormPreview = "//*[@class='flex-1-1-auto']//*[@data-dismiss='modal']";
    private static String formPreviewModalContent = "preview_report-modal_content";
    private static String formPreviewH5 = "//*[@id='preview_report-modal_content']//h5";

    public static String getDefectReportsMenuButton() {
        return defectReportsMenuButton;
    }
    public static String getEditReport() {
        return editReport;
    }
    public static String getAddNewReport() {
        return addNewReport;
    }
    public static String getRadioElement() {
        return radioElement;
    }
    public static String getSectionName() {
        return sectionName;
    }
    public static String getOption1() {
        return option1;
    }
    public static String getOption2() {
        return option2;
    }
    public static String getSaveForm() {
        return saveForm;
    }
    public static String getFormPreview() {
        return formPreview;
    }
    public static String getCloseFormPreview() {
        return closeFormPreview;
    }
    public static String getFormPreviewModalContent() {
        return formPreviewModalContent;
    }
    public static String getFormPreviewH5() {
        return formPreviewH5;
    }
}
