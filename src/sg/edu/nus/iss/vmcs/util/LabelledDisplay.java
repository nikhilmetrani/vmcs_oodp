/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */
package sg.edu.nus.iss.vmcs.util;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

import sg.edu.nus.iss.vmcs.observer.pattern.Subject;
import sg.edu.nus.iss.vmcs.observer.pattern.Observer;

/**
 * This boundary object displays an updatable text field next to a fixed label.
 *
 * @version 3.0 5/07/2003
 * @author Olivo Miotto, Pang Ping Li
 */
public class LabelledDisplay extends Panel implements Observer {
	/**This constant attribute denotes the default layout of the LabelledDisplay*/
	public final static int DEFAULT = 5;
	/**This constant attribute denotes the flow layout of the LabelledDisplay*/
	public final static int FLOW = 1;
	/**This constant attribute denotes the grid layout of the LabelledDisplay*/
	public final static int GRID = 2;

	private TextField value;
	private Label lb;

	/**
	 * This constructor creates an instance of LabelledDisplay object.
	 * @param label the label name.
	 * @param length the length of the text field.
	 * @param lt the layout of the display.
	 */
	public LabelledDisplay(String label, int length, int lt) {

		if (lt == FLOW)
			this.setLayout(new FlowLayout(FlowLayout.CENTER));
		else if (lt == GRID)
			this.setLayout(new GridLayout(1, 2));

		lb = new Label(label);
		lb.setAlignment(Label.RIGHT);
		Panel tp = new Panel();
		tp.setLayout(new FlowLayout());
		value = new TextField();
		value.setColumns(length);

		tp.add(value);

		this.add(lb);
		this.add(tp);
	}

	/**
	 * This method attach a listener to the LabelledDislay.
	 * @param listener the ActionListener for the display.
	 */
	public void addListener(ActionListener listener) {
		value.addActionListener(listener);
	}

	/**
	 * This method sets whether the TextField in the LabelledDisplay is editable.
	 * @param v TRUE making it editable, FALSE making it not editable.
	 */
	public void setEditable(boolean v) {
		value.setEditable(v);
		if (v == false) {
			value.setBackground(Color.lightGray);
			value.setFocusable(false);
		}
	}
	
	/**
	 * This method set the value to the text field in the LabelledDisplay&#46;
	 * @param vl the value to be set to the text field&#46;
	 */
	public void setValue(String vl) {
		value.setText(vl);
	}

	/**
	 * This method set the value to the text field in the LabelledDisplay&#46;
	 * @param vl the value to be set to the text field&#46;
	 */
	public void setValue(int vl) {
		setValue(String.valueOf(vl));
	}

	/**
	 * This method activates the LabelledDisplay if parameter is TRUE&#46;
	 * Otherwise, the LabelledDisplay is deactivated.
	 * @param st the active status of the LabelledDisplay.
	 */
	public void setActive(boolean st) {
		value.setEnabled(st);
		lb.setEnabled(st);
	}

	/**
	 * This method sets the text field background color in the LabelledDisplay.
	 * @param c the color of the background.
	 */
	public void setTextBackground(Color c) {
		value.setBackground(c);
	}

	/**
	 * This method sets the text field foreground in the LabelledDisplay.
	 * @param c the color of the foreground.
	 */
	public void setTextForeground(Color c) {
		value.setForeground(c);
	}
	
	public TextField getValue(){
		return value;
	}

	@Override
	public void update(Subject changedSubject) {
        try {
            Method method = changedSubject.getClass().getMethod("getQuantity");
            int quantity;
            quantity = (int) method.invoke((Object)changedSubject);
            setValue(quantity);
            System.out.printf("Machinery %s update: %d\n", lb.getText(), quantity);
        } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(LabelledDisplay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}//End of class LabelledDisplay