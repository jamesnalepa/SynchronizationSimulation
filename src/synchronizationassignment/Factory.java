// JAMES NALEPA

package synchronizationassignment;

public class Factory {

	static ConveyerBelt a_b;
	static ConveyerBelt b_c;
	static ConveyerBelt c_d;
	static Worker wa;						// belt and worker objects for reference by threads
	static Worker wb;
	static Worker wc;
	static Worker wd;

	public static void main(String[] args) throws InterruptedException {

		wa = new Worker("a");
		wb = new Worker("b");				// worker instances
		wc = new Worker("c");
		wd = new Worker("d");
		
		Thread a = new Thread(wa);
		Thread b = new Thread(wb);
		Thread c = new Thread(wc);			// creating threads
		Thread d = new Thread(wd);

		a_b = new ConveyerBelt("a_b");
		b_c = new ConveyerBelt("b_c");		// belt instances
		c_d = new ConveyerBelt("c_d");

		a.start();
		b.start();							// spinning up threads
		c.start();
		d.start();



	}

}
