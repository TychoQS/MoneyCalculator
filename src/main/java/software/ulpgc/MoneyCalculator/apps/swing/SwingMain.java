package software.ulpgc.MoneyCalculator.apps.swing;

public class SwingMain {
    public static void main(String[] args) {
        SwingMainFrame mainFrame = new SwingMainFrame();
        mainFrame.setVisible(true);
        // TODO -> Refactorizar CurrencyCodeToSymbol (Creo que como método estático de una clase queda mejor)
        // TODO -> Refactorizar para abrir los recursos perteneciente a la carpeta resources a como hemos visto en clase (Objeto .class)
    }
}
