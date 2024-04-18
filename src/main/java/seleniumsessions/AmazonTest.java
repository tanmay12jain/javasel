package seleniumsessions;

public class AmazonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BrowserUtil brutil = new BrowserUtil();
		brutil.launchBrowser("chrome");
		brutil.launchURL("https://www.amazon.in/");
	    String title = brutil.getPageTitle();
		if(title.contains("Amazon")) {
			System.out.println("Test--Pass");
		}
		else {
			System.out.println("test--failed");
		}
		brutil.getPageURL();
		
		brutil.closeBrowser();
	}

}
