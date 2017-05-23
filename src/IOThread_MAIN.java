import java.util.LinkedList;
import java.util.Iterator;
import java.util.Random;

public class IOThread_MAIN
{
	public static void main(String[] args) throws InterruptedException
	{
		int nodes_T	= 20 ;
		Random r1	= new Random();
		PCB	pcbRunning = null ;
		
		LinkedList<PCB> QReady	= new LinkedList<PCB>();
		
		for (int ii=0; ii<nodes_T; ii++)
		{
			QReady.addLast(new PCB());
		}
		
		while (!QReady.isEmpty())
		{
			pcbRunning	= QReady.removeFirst();
			
			if ((r1.nextInt(100)%10)==2)
			{
				Thread iop	= new Thread(new IOProcess
						(pcbRunning
						,QReady
						)
				);
				
				iop.start();

				System.out.printf("main: thread started %s %d %s\n"
						,iop.getName()
						,iop.getId()
						,iop.getState()
						);
			}
		}
		
		System.out.printf("\nmain: threads still running: %d\n\n"
				,Thread.activeCount()-1
				);
		
		for (PCB loopI : QReady)
			System.out.printf("main: %s\n"	,loopI.showPCB()) ;

		System.out.printf("\t***** done *****\n");
	}
}
