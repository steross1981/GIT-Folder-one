package ManipulatingURLs;

import java.applet.AppletContext;
import java.awt.BorderLayout;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JApplet;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SiteSelector extends JApplet {

	private HashMap<String, URL> sites; // site names and URLSs 
	private ArrayList<String> siteNames; // site names
	private JList siteChooser; // list of sites to choose from
	
	
	public void init()
	{
		sites = new HashMap<String, URL>(); // create HashMap
		siteNames = new ArrayList<String>(); //create ArrayList
		
		// obtain parameters from XHTML document 
		getSitesFromHTMLParameters();
		
		// create GUI components and lay out interface
		add(new JLabel("Choose a Site to Browse"), BorderLayout.NORTH);
		 siteChooser = new JList(siteNames.toArray()); // populate playlist
		 siteChooser.addListSelectionListener( 
				 new ListSelectionListener() // anonymous inner class
				 {
					public void valueChanged(ListSelectionEvent event) 
					
					{
					 
					 // get selected site name 
					 Object object = siteChooser.getSelectedValue();
					 
					 // use site  name to locate corresponding URL
					URL newDocument = sites.get(object);
					
					// get applet container
					AppletContext browser = getAppletContext();
					
					// tell applet container to change pages
					browser.showDocument(newDocument);
					}
					 
				 });
		 
		 add(new JScrollPane(siteChooser), BorderLayout.CENTER);
				 
		
	}
	
	private void getSitesFromHTMLParameters()
	{
		String title;// site title
		String location;// site location 
		URL url;// URL of location
		int counter = 0; // count number of sites 
		
		title = getParameter("title" + counter);// get first site title
		
		// loop until no more parameters in XHTML document 
		while (title != null )
		{
			// obtain site location
			location = getParameter("location" + counter);
			
			try// place title. URL in HashMap and title in ArrayList
			{
				url = new URL(location);// convert location to URL 
				sites.put(title, url );// put title/URL in HashMap
				siteNames.add(title);// put title in ArrayList
			}// end try 
			catch(MalformedURLException urlException)
			{
				urlException.printStackTrace();
				
			}// end catch
			counter++;
			title = getParameter("title" + counter);
		}
			
		
		
	}
	
	
	
	
}
