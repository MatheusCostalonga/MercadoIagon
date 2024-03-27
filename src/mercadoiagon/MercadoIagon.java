package mercadoiagon;

import com.formdev.flatlaf.intellijthemes.FlatSpacegrayIJTheme;
import telas.TelaPrincipal;

public class MercadoIagon {

    public static void main(String[] args) {
        FlatSpacegrayIJTheme.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

}
