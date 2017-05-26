import java.util.Random;
import java.util.LinkedList;

public class T_IOProcess extends Thread
{
	private Random	r1 =	new Random();
	private final LinkedList<PCB> QReady ;
	private PCB pcb ;
	private Thread thread_xy ;
	private String threadName ;
	
	public T_IOProcess	(LinkedList<PCB> qr0)
	{
		this.QReady	= qr0 ;
		
		thread_xy	= new Thread	(this	);
		this.threadName	= thread_xy.getName() ;

		thread_xy.start();
		
		System.out.printf("\t>>> %s <<<\tcreated\n"
				,this.threadName
				);
	}
	
	public void run() 
	{
		synchronized(this)
		{
			this.pcb = this.QReady.removeFirst();
		}
				
		System.out.printf("\t>>> %s <<<\tpcb: %d retrieved\n"	
				,this.threadName
				,pcb.get_ID()
				);

		try 
		{
			Thread.sleep(100 + r1.nextInt(100));
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}

		System.out.printf("\t>>> %s <<<\tpcb: %d\tCPU used: %d\tending\n"	
				,this.threadName
				,pcb.get_ID()
				,pcb.get_CPU_used()
				);
	}
}
