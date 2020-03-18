package sample.makePDFFile;

public class TableContent implements HTMLContent {

    public String getHTML() {

        String content = "<b style=\"font-family: Arial, Verdana; font-size: 10pt; font-style: normal; font-variant: normal; font-weight: normal; line-height: normal; color: rgb(204, 255, 255); background-color: rgb(51, 102, 255);\">zzz&nbsp;</b>"
                + "<div style=\"font-family: Arial, Verdana; font-size: 10pt; font-style: normal; font-variant: normal; font-weight: normal; line-height: normal;\"><b style=\"color: rgb(204, 255, 255); background-color: rgb(51, 102, 255);\"><br /></b></div>"
                + "<div><b style=\"font-family: Arial, Verdana; font-size: 10pt; font-style: normal; font-variant: normal; font-weight: normal; line-height: normal; color: rgb(204, 255, 255); background-color: rgb(51, 102, 255);\">Test &nbsp;</b> &nbsp; "
                + "<span style=\"color: rgb(255, 0, 0);\">&nbsp;<span style=\"font-weight: bold;\">Description</span> &nbsp;</span>"
                + "<span style=\"color: rgb(153, 51, 153); font-style: italic;\">Other Color</span>"
                + "</div>";

        return content;
    }
}
