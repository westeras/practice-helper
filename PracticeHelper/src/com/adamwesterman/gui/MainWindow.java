package com.adamwesterman.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

public class MainWindow {

	protected Shell shlPracticeHelper;
	private Text text_search;
	private List list_added_songs;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlPracticeHelper.open();
		shlPracticeHelper.layout();
		while (!shlPracticeHelper.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlPracticeHelper = new Shell();
		shlPracticeHelper.setSize(574, 390);
		shlPracticeHelper.setText("Practice Helper");
		
		text_search = new Text(shlPracticeHelper, SWT.BORDER);
		text_search.setBounds(164, 36, 293, 26);
		
		list_added_songs = new List(shlPracticeHelper, SWT.BORDER);
		list_added_songs.setBounds(10, 35, 137, 300);
		
		table = new Table(shlPracticeHelper, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(164, 77, 371, 258);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tc1 = new TableColumn(table, SWT.CENTER);
	    TableColumn tc2 = new TableColumn(table, SWT.CENTER);
	    TableColumn tc3 = new TableColumn(table, SWT.CENTER);
	    tc1.setText("Song Name");
	    tc2.setText("Artist");
	    tc3.setText("Album");
	    
	    table.setHeaderVisible(true);
		
		Button btnSearch = new Button(shlPracticeHelper, SWT.NONE);
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String search = text_search.getText();
				if (!search.equals("")) {
					
				}
			}
		});
		
		btnSearch.setBounds(463, 33, 72, 30);
		btnSearch.setText("Search");
		
	}
}
