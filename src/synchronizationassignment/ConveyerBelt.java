// JAMES NALEPA

package synchronizationassignment;

import java.util.*;

public class ConveyerBelt
{
	
	String name;

	public ConveyerBelt(String n) {
		queue = new Vector<Widget>();
		name = n;
	}
	
	
	public synchronized void send(Widget item) {						// synchronized send method
		while (getSize() >= 5)
		{
			System.out.println("Conveyer Belt " + name + " is full");
			try {
				wait();								// if belt is full  ----> wait for a worker to read from the belt and notify
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		queue.addElement(item);
		
		notifyAll();
	}

	public synchronized Widget receive() {								// synchronized receive method
		
		while (getSize() == 0)
		{
			System.out.println("Conveyer Belt " + name + " is empty");
			try {
				wait();								// if the belt is empty wait for a worker to write to the belt and notify
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Widget item;

		if (queue.size() == 0)
			return null;
		else {
			item = queue.firstElement();        
			queue.removeElementAt(0);

			return item;
		}
	}

	public int getSize()
	{
		return queue.size();
	}

	private Vector<Widget> queue;
}