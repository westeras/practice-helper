package com.adamwesterman.gui;

import java.util.Collection;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import com.adamwesterman.core.APIHandler;

import de.umass.lastfm.Artist;

public class MainWindow {

	protected Shell shlPracticeHelper;
	private Text text_search;
	private List list_added_songs;
	private List list_search;

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
		shlPracticeHelper.setSize(450, 300);
		shlPracticeHelper.setText("Practice Helper");
		
		text_search = new Text(shlPracticeHelper, SWT.BORDER);
		text_search.setBounds(164, 35, 180, 26);
		
		list_added_songs = new List(shlPracticeHelper, SWT.BORDER);
		list_added_songs.setBounds(10, 35, 137, 210);
		
		list_search = new List(shlPracticeHelper, SWT.BORDER);
		list_search.setBounds(164, 82, 245, 163);		
		
		Button btnSearch = new Button(shlPracticeHelper, SWT.NONE);
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String search = text_search.getText();
				if (!search.equals("")) {
					Collection<Artist> artists = Artist.search(search, APIHandler.getAPIkey());
					for (Artist artist : artists) {
						list_search.add(artist.getName());
					}
				}
			}
		});
		
		btnSearch.setBounds(350, 33, 72, 30);
		btnSearch.setText("Search");

	}
}
