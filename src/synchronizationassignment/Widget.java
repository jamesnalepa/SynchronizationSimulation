// JAMES NALEPA

package synchronizationassignment;

public class Widget {

	private String handledBy;
	private int widgetID;


	public Widget(String x, int id)
	{
		handledBy = "handled by A";
		widgetID = id;
	}

	public void editHandledBy(String edit)
	{
		handledBy = handledBy + ", " + edit.toUpperCase();
	}

	public String getHandledBy()
	{
		return handledBy;
	}

	public int getID()
	{
		return widgetID;
	}
}