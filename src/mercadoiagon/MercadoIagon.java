package mercadoiagon;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import telas.TelaPrincipal;

public class MercadoIagon {

    public static void main(String[] args) {
        FlatMaterialLighterIJTheme.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

}
