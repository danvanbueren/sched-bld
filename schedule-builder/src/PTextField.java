import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class PTextField extends JTextField {

	public PTextField(final String promptText, boolean subdueOnInit) {
		super(promptText);

		if (subdueOnInit)
			setForeground(new Color(160, 160, 160));

		addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (getText().isEmpty()) {
					setText(promptText);
					setForeground(new Color(160, 160, 160));
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (getText().equals(promptText)) {
					setText("");
					setForeground(new Color(0, 0, 0));
				}
			}
		});
		
	}
	
	public void setTextFill(String t) {
		setText(t);
		setForeground(new Color(0, 0, 0));
	}

}