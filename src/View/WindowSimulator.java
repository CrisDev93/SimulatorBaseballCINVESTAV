package View;


import View.Drawn;
import View.ControlPanel;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowSimulator extends JFrame {

    ControlPanel cp;
	public WindowSimulator() throws IOException {
            String stage="img/baseballmap.png";
                
            
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new Drawn(stage));
		setTitle("Escenario");
		setSize(1200,700);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
           //   this.cp = c;
	}

	
}