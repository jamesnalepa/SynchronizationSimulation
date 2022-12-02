// JAMES NALEPA

package synchronizationassignment;

public class Worker implements Runnable {

	int count = 0;			// int for unique Widget ID values
	public String t;		// Worker type to add to the Widget.handledBy
	private Widget w;		// temp Widget for working on

	public Worker(String type)
	{
		if (type.equalsIgnoreCase("a"))
		{
			w = new Widget(type, count + 1);
			t = type;
		}
		else if (type.equalsIgnoreCase("b"))		// setting the type of worker and creating a new Widget in A
		{
			t = type;
		}
		else if (type.equalsIgnoreCase("c"))
		{
			t = type;
		}
		else if (type.equalsIgnoreCase("d"))
		{
			t = type;
		}
		else
		{
			System.out.println("Worker type not recognized");
		}
	}

	@Override
	public void run()			// called by Thread.start() in Factory.main()
	{
		while (true)
		{
			if (t.equalsIgnoreCase("a"))			// Worker A operations
			{
				Factory.a_b.send(w);
				System.out.println("Worker A is placing widget" + w.getID() + "<" + w.getHandledBy() + ">" + " on the conveyer belt");
				
				try {
					Thread.sleep((long) Math.floor(Math.random() * (1 + 3000 - 1000)) + 1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				count = count + 1;					// Incrementing Count to create a new unique Widget ID
				w = createWidget(t);
			}
			else if (t.equalsIgnoreCase("b"))		// Worker B operations
			{
				w = Factory.a_b.receive();
				System.out.println("Worker B is retrieving widget" + w.getID() + "<" + w.getHandledBy() + ">" + " from the conveyer belt");
				editWidget(w, "b");

				try {
					Thread.sleep((long) Math.floor(Math.random() * (1 + 3000 - 1000)) + 1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Factory.b_c.send(w);
				System.out.println("Worker B is placing widget" + w.getID() + "<" + w.getHandledBy() + ">" + " on the conveyer belt");
			}
			else if (t.equalsIgnoreCase("c"))		// Worker C operations
			{
				w = Factory.b_c.receive();
				System.out.println("Worker C is retrieving widget" + w.getID() + "<" + w.getHandledBy() + ">" + " from the conveyer belt");
				
				editWidget(w, "c");

				try {
					Thread.sleep((long) Math.floor(Math.random() * (1 + 3000 - 1000)) + 1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("Worker C is placing widget" + w.getID() + "<" + w.getHandledBy() + ">" + " on the conveyer belt");
				Factory.c_d.send(w);
				
			}
			else if (t.equalsIgnoreCase("d"))		// Worker D operations
			{
				w = Factory.c_d.receive();
				System.out.println("Worker D is retrieving widget" + w.getID() + "<" + w.getHandledBy() + ">" + " from the conveyer belt");
				
				editWidget(w, "d");

				try {
					Thread.sleep((long) Math.floor(Math.random() * (1 + 3000 - 1000)) + 1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("Widget " + w.getID() + " has been " + w.getHandledBy());
			}
		}


	}

	public Widget createWidget(String type)
	{
		return new Widget(type, count + 1);			// Worker A's Widget creation
	}
	
	public void editWidget(Widget w, String edit)		// method for editing the Widget.handledBy variable
	{
		System.out.println("Worker " + t.toUpperCase() + " is working on widget" + w.getID() + "<" + w.getHandledBy() + ">");
		w.editHandledBy(edit);
	}
	
}