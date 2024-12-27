package software.ulpgc.MoneyCalculator.apps.swing.date.conversion.dialogs;

import software.ulpgc.MoneyCalculator.architecture.view.DateDialog;

import javax.swing.*;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class SwingDateDialog extends JSpinner implements DateDialog {
    public static final String DATE_PATTERN = "dd/MM/yyyy";
    public static final SpinnerDateModel SPINNER_DATE_MODEL = new SpinnerDateModel();

    public SwingDateDialog() {
        super(SPINNER_DATE_MODEL);
        this.setEditor(new DateEditor(this, DATE_PATTERN));
    }

    @Override
    public ZonedDateTime getDate() {
        Instant instant = ( (Date) this.getValue()).toInstant();
        return ZonedDateTime.ofInstant(instant, ZoneId.systemDefault());
    }
}
