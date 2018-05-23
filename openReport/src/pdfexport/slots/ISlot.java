package pdfexport.slots;

import javafx.event.ActionEvent;

public interface ISlot {
    public void addTitle(ActionEvent event);
    public void addHeader(ActionEvent event);
    public void addSprite(ActionEvent event);
    public void addSignature(ActionEvent event);
    public void addSimpleTable(ActionEvent event);
    public void addText(ActionEvent event);
}
