
package Opcion3;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JFChooser {
        private JFileChooser archivo = new JFileChooser();

    public JFileChooser getArchivo() {
        return this.archivo;
    }

    public void setArchivo(JFileChooser archivo) {
        this.archivo = archivo;
    }
        
    public File ElegirCarpeta(JPanel panel){
            JFileChooser elector = new JFileChooser();
            File carpeta=null;
            elector.setCurrentDirectory(new File("."));
            elector.setDialogTitle("Elija la carpeta en donde se guardará su archivo");
            elector.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            elector.setAcceptAllFileFilterUsed(false);
            if (elector.showOpenDialog(panel)==JFileChooser.APPROVE_OPTION) {
                carpeta = elector.getSelectedFile();
        }
    return carpeta;
}
}
